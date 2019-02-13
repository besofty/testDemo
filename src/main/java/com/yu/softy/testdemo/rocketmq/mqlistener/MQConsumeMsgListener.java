package com.yu.softy.testdemo.rocketmq.mqlistener;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Component
@Data
@Slf4j
public class MQConsumeMsgListener implements MessageListenerConcurrently {
    private final MqProcessorRegistry mqProcessorRegistry;

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
        if (CollectionUtils.isEmpty(msgs)) {
            log.info("接受到的消息为空，不处理，直接返回成功");
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }
        MessageExt messageExt = msgs.get(0);
        log.info("接受到的消息为：" + messageExt);
        try {
            return process(messageExt);
        } catch (Exception e) {
            log.error("consumeMessage exception ", e);
            return ConsumeConcurrentlyStatus.RECONSUME_LATER;
        }

    }

    private ConsumeConcurrentlyStatus process(MessageExt messageExt) {
        if (messageExt.getReconsumeTimes() == 3) {//消息已经重试了3次，如果不需要再次消费，则返回成功
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }
        return mqProcessorRegistry.getMqProcessor(messageExt.getTags())
            .process(messageExt);
    }


}
