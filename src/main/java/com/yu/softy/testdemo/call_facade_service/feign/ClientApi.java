package com.yu.softy.testdemo.call_facade_service.feign;

import com.yu.softy.testdemo.call_facade_service.RequestBodyEntity;
import feign.Headers;
import feign.RequestLine;

public interface ClientApi {
    @RequestLine("POST /api/test")
    @Headers("Content-Type: application/json")
    RequestBodyEntity feignTest(RequestBodyEntity requestBodyEntity);
}
