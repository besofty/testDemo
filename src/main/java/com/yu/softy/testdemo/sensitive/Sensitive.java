package com.yu.softy.testdemo.sensitive;

import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;

@Data
@Accessors(chain = true)
public class Sensitive {
    private String value;

    public static Sensitive valueOf(String value) {
        if(StringUtils.isBlank(value)){
            return null;
        }
        return new Sensitive().setValue(value);
    }
}
