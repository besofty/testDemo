package com.yu.softy.testdemo.call_facade_service;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class RequestBodyEntity {
    private String testName;
    private String testContent;
}
