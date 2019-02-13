package com.yu.softy.testdemo.rocketmq.mqlistener;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TestMQProcessor implements MQProcessor{
    @Override
    public ConsumeConcurrentlyStatus process(MessageExt messageExt) {
        log.error("TestMQProcessor success {}", messageExt);
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}
