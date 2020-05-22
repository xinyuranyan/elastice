package com.lixx.elasticsearchtemplate.message.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

/**
 * @author lxx
 * @date 2020/5/14 21:50
 * @description 分页查询父类
 */
public class QueryByPageRequest {
    private static final int DEFAULT_PAGE_INDEX = 1;
    private static final int DEFAULT_PAGE_SIZE = 10;
    @Positive
    private Integer pageIndex = 1;
    @Positive
    @Max(1000L)
    @JsonProperty("PageSize")
    private Integer pageSize = 10;
    @PositiveOrZero
    private Integer offset = 0;

    public void setPageIndex(Integer pageIndex) {
        if (pageIndex == null) {
            pageIndex = 1;
        }

        this.pageIndex = pageIndex;
        this.refreshOffset();
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize == null) {
            pageSize = 10;
        }

        this.pageSize = pageSize;
        this.refreshOffset();
    }

    private void refreshOffset() {
        if (this.pageIndex == null) {
            this.pageIndex = 1;
        }

        if (this.pageSize == null) {
            this.pageSize = 10;
        }

        this.offset = (this.pageIndex - 1) * this.pageSize;
    }


    public QueryByPageRequest() {
    }

    public QueryByPageRequest(Integer pageIndex, Integer pageSize, Integer offset) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.offset = offset;
    }
}
