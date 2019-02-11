package com.yu.softy.testdemo.sensitive;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * 字段预处理
 * 配合 @JsonDeserialize(using = SensitiveJsonDeserializer.class) 使用
 */
@Slf4j
public class SensitiveJsonDeserializer extends JsonDeserializer<Sensitive> {

    @Override
    public Sensitive deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return Sensitive.valueOf(jsonParser.getText());
    }
}
