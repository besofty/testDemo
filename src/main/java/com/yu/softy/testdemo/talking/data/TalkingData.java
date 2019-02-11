package com.yu.softy.testdemo.talking.data;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class TalkingData {

    private static final String ACCESS_KEY = "13d38156a4eb0301da5a3cda1025038c";
    private static final String URL = "https://api.talkingdata.com/metrics/app/v1";
    private static final RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        HttpEntity<TalkingDataRequest> requestHttpEntity = getRequest("2018-12-25", "2018-12-27");
        String response = restTemplate.postForEntity(URL, requestHttpEntity, String.class).getBody();
        System.out.println(response);
    }

    private static HttpEntity<TalkingDataRequest> getRequest(String startDate, String endDate){
        List<String> metrics = new ArrayList<>();
        metrics.add("events");
        metrics.add("eventuser");
        List<String> eventIds = new ArrayList<>();
        eventIds.add("配置接口请求成功");
        FilterCondition filterCondition = new FilterCondition()
                .setStart(startDate)
                .setEnd(endDate)
                .setEventids(eventIds);
        TalkingDataRequest request = new TalkingDataRequest()
                .setAccesskey(ACCESS_KEY)
                .setMetrics(metrics)
                .setGroupby("daily")
                .setFilter(filterCondition);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        return new HttpEntity<>(request,headers);
    }

    @Data
    @Accessors(chain = true)
    static class TalkingDataRequest{
        private String accesskey;

        @ApiModelProperty(value = "查询的指标项(必填)")
        private List<String> metrics;

        @ApiModelProperty(value = "数据分组方式(必填)")
        private String groupby;

        @ApiModelProperty(value = "数据筛选条件(必填)")
        private FilterCondition filter;
        private String order;
        private Integer limit;
        private Boolean sum;
        private Boolean avg;

    }

    @Data
    @Accessors(chain = true)
    static class FilterCondition{
        @ApiModelProperty(value = "起始日(必填)")
        private String start;

        @ApiModelProperty(value = "截止日(必填)")
        private String end;
        private List<Integer> platformids;
        private List<String> versions;
        @ApiModelProperty(value = "渠道id")
        private List<Integer> channelids;
        @ApiModelProperty(value = "事件id")
        private List<String> eventids;
        private List<String> pagenames;
    }




}
