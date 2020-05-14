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
    @JsonProperty("PageIndex")
    private Integer pageIndex = 1;
    @Positive
    @Max(1000L)
    @JsonProperty("PageSize")
    private Integer pageSize = 10;
    @PositiveOrZero
    @JsonProperty("Offset")
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

    public static QueryByPageRequest.QueryByPageRequestBuilder builder() {
        return new QueryByPageRequest.QueryByPageRequestBuilder();
    }

    public QueryByPageRequest() {
    }

    public QueryByPageRequest(Integer pageIndex, Integer pageSize, Integer offset) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.offset = offset;
    }

    public Integer getPageIndex() {
        return this.pageIndex;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public Integer getOffset() {
        return this.offset;
    }

    public static class QueryByPageRequestBuilder {
        private Integer pageIndex;
        private Integer pageSize;
        private Integer offset;

        QueryByPageRequestBuilder() {
        }

        @JsonProperty("PageIndex")
        public QueryByPageRequest.QueryByPageRequestBuilder pageIndex(Integer pageIndex) {
            this.pageIndex = pageIndex;
            return this;
        }

        @JsonProperty("PageSize")
        public QueryByPageRequest.QueryByPageRequestBuilder pageSize(Integer pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        @JsonProperty("Offset")
        public QueryByPageRequest.QueryByPageRequestBuilder offset(Integer offset) {
            this.offset = offset;
            return this;
        }

        public QueryByPageRequest build() {
            return new QueryByPageRequest(this.pageIndex, this.pageSize, this.offset);
        }

        @Override
        public String toString() {
            return "QueryByPageRequest.QueryByPageRequestBuilder(pageIndex=" + this.pageIndex + ", pageSize=" + this.pageSize + ", offset=" + this.offset + ")";
        }
    }
}
