package com.yu.softy.testdemo.rocketmq.mqlistener;

import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.common.message.MessageExt;

public interface MQProcessor {

    ConsumeConcurrentlyStatus process(MessageExt messageExt);
}
