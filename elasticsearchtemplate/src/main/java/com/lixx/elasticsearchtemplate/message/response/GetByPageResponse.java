package com.lixx.elasticsearchtemplate.message.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author : lxx
 * @date: 2020/5/22 17:16
 * @description:
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class GetByPageResponse<T> extends QueryResponse<T> {
    @JsonProperty("TotalRecord")
    private Long totalRecord;
}
