package com.lixx.elasticsearchtemplate.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lixx.elasticsearchtemplate.exception.ErrorCodeException;
import com.lixx.elasticsearchtemplate.jackson.ObjectMappers;

import java.io.IOException;

/**
 * @author : lxx
 * @date: 2020/5/22 17:27
 * @description:
 */
public abstract class Jsons {
    private static final ObjectMapper objectMapper;

    static {
        objectMapper = ObjectMappers.of();
    }

    public static String serialize(Object value) {
        try {
            return objectMapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new ErrorCodeException("JSON-0001", "Json Serialize Failed");
        }
    }

    public static <T> T deserialize(String value, Class<T> valueType) {
        try {
            return objectMapper.readValue(value, valueType);
        } catch (IOException e) {
            throw new ErrorCodeException("JSON-0002", "Json Deserialize Failed");
        }
    }
}