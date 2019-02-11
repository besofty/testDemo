package com.yu.softy.testdemo.call_facade_service.rest_template;

import com.yu.softy.testdemo.call_facade_service.RequestBodyEntity;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class RestTemplateDemo {
    private static final RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        HttpEntity<RequestBodyEntity> requestHttpEntity = getRequest();
        String response = restTemplate.postForEntity("http://localhost:8088/api/test", requestHttpEntity, String.class).getBody();
        System.out.println(response);
    }

    private static HttpEntity<RequestBodyEntity> getRequest() {
        RequestBodyEntity request = new RequestBodyEntity()
                .setTestName("testName")
                .setTestContent("testContent");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        return new HttpEntity<>(request, headers);
    }
}
