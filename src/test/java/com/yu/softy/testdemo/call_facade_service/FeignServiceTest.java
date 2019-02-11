package com.yu.softy.testdemo.call_facade_service;

import com.yu.softy.testdemo.call_facade_service.feign.ClientApi;
import com.yu.softy.testdemo.call_facade_service.feign.FeignService;
import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;
import org.junit.Test;

public class FeignServiceTest {

    private ClientApi clientApi = Feign.builder()
            .logger(new Slf4jLogger())
            .logLevel(Logger.Level.BASIC)
            .encoder(new JacksonEncoder())
            .decoder(new JacksonDecoder())
            .target(ClientApi.class, "http://localhost:8088");

    private FeignService feignService = new FeignService(clientApi);

    @Test
    public void test() {
        RequestBodyEntity requestBodyEntity = feignService.test();
        System.out.println(requestBodyEntity);
    }
}
