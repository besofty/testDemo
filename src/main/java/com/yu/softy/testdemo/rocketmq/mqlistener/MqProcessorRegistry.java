package com.yu.softy.testdemo.rocketmq.mqlistener;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class MqProcessorRegistry {
    private final ConcurrentHashMap<String, MQProcessor> tagProcessorMap = new ConcurrentHashMap();

    public MQProcessor getMqProcessor(String tag) throws UnsupportedOperationException {
        MQProcessor mqProcessor = tagProcessorMap.get(tag);
        if (mqProcessor == null) {
            log.error("不支持的消息tag, tag:{}", tag);
            throw new UnsupportedOperationException("不支持的消息tag");
        }
        return mqProcessor;
    }

    public void registerMqProcessor(String tag, MQProcessor mqProcessor) {
        tagProcessorMap.put(tag, mqProcessor);
    }
}
