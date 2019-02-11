package com.yu.softy.testdemo.call_facade_service.feign;

import com.yu.softy.testdemo.call_facade_service.RequestBodyEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class FeignService {
    private final ClientApi clientApi;

    public RequestBodyEntity test() {
        RequestBodyEntity requestBodyEntity = new RequestBodyEntity()
                .setTestContent("testContent")
                .setTestName("testDemo");
        return clientApi.feignTest(requestBodyEntity);
    }
}
