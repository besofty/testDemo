package com.yu.softy.testdemo.call_facade_service.feign;

import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FeignServiceFactory {
    public FeignService createChuangRuiSmsFacadeService() {
        ClientApi clientApi = Feign.builder()
                .logLevel(Logger.Level.BASIC)
                .logger(new Slf4jLogger())
                .logLevel(Logger.Level.BASIC)
                //new ChuangRuiFormEncoder(chuangRuiConfig)
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(ClientApi.class, "http://localhost:8080");
        return new FeignService(clientApi);
    }
}
