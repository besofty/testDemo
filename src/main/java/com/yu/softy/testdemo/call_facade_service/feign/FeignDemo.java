package com.yu.softy.testdemo.call_facade_service.feign;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class FeignDemo {
    private final FeignServiceFactory feignServiceFactory;

    public void test() {
        FeignService feignService = feignServiceFactory.createChuangRuiSmsFacadeService();
        feignService.test();
    }
}
