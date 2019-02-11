package com.yu.softy.testdemo.context_hold.spring_security;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class TestContext implements Serializable {
    private String context;
}
