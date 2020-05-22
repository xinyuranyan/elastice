package com.lixx.elasticsearchtemplate.message.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author : lxx
 * @date: 2020/5/22 17:24
 * @description:
 */
@Data
public class QueryResponse<T> {
    @JsonProperty("List")
    private List<T> list;
}
