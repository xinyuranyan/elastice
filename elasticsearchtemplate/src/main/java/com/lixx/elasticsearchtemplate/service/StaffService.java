package com.lixx.elasticsearchtemplate.service;

import com.lixx.elasticsearchtemplate.entity.es.StaffEs;
import com.lixx.elasticsearchtemplate.exception.ErrorCodeException;
import com.lixx.elasticsearchtemplate.message.response.GetByPageResponse;
import com.lixx.elasticsearchtemplate.util.Jsons;
import lombok.SneakyThrows;
import lombok.var;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.script.ScriptType;
import org.elasticsearch.script.mustache.SearchTemplateRequest;
import org.elasticsearch.script.mustache.SearchTemplateResponse;
import org.elasticsearch.search.SearchHit;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author lxx
 * @date 2020/5/14 21:30
 * @description
 */
@Service
public class StaffService {

    /**
     * es索引名称-使用别名
     */
    private static final String ES_STAFF_INDEX = "Staff";

    private final RestHighLevelClient restHighLevelClient;

    public StaffService(RestHighLevelClient restHighLevelClient) {
        this.restHighLevelClient = restHighLevelClient;
    }


    @SneakyThrows
    private GetByPageResponse<StaffEs> queryByESSearchTemplate(String templateName, HashMap<String, Object> params) {
        SearchTemplateRequest searchTemplateRequest = new SearchTemplateRequest(new org.elasticsearch.action.search.SearchRequest(ES_STAFF_INDEX));
        searchTemplateRequest.setScript(templateName);
        searchTemplateRequest.setScriptType(ScriptType.STORED);
        searchTemplateRequest.setScriptParams(params);

        try {
            SearchTemplateResponse searchTemplateResponse = restHighLevelClient.searchTemplate(searchTemplateRequest, RequestOptions.DEFAULT);
            var searchResponseHits = searchTemplateResponse.getResponse().getHits();
            SearchHit[] hits = searchResponseHits.getHits();

            var responseList = new ArrayList<StaffEs>();

            for (SearchHit hit : hits) {
                var hitReplacement = Jsons.deserialize(hit.getSourceAsString(), StaffEs.class);
                responseList.add(hitReplacement);
            }
            var response = new GetByPageResponse<StaffEs>();
            response.setList(responseList);
            response.setTotalRecord(searchResponseHits.getTotalHits().value);
            return response;

        } catch (Exception e) {
            e.printStackTrace();
            throw new ErrorCodeException("", "查询异常" + e.getMessage());
        }
    }

}
