package com.yu.softy.testdemo.rocketmq.config;

import com.yu.softy.testdemo.rocketmq.mqlistener.MqProcessorRegistry;
import com.yu.softy.testdemo.rocketmq.mqlistener.TestMQProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQProcessorConfig {

    @Bean
    public MqProcessorRegistry mqProcessorRegistry(ApplicationContext applicationContext) {
        MqProcessorRegistry mqProcessorRegistry = new MqProcessorRegistry();
        mqProcessorRegistry.registerMqProcessor("Test", new TestMQProcessor());
        return mqProcessorRegistry;
    }

}
