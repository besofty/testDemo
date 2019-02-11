package com.yu.softy.testdemo.call_facade_service.web_client;

import com.yu.softy.testdemo.call_facade_service.RequestBodyEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Service
@Slf4j
@AllArgsConstructor
public class WebClientDemo {

    public static void test() {
        RequestBodyEntity requestBodyEntity = new RequestBodyEntity()
                .setTestContent("testContent")
                .setTestName("testDemo");
        WebClient.Builder webClient = WebClient.builder();
        Mono<RequestBodyEntity> result = webClient.build()
                .post()
                .uri("http://localhost:8088/api/test")
                .syncBody(requestBodyEntity)
                .retrieve()
                .bodyToMono(RequestBodyEntity.class);
        System.out.println(result.block());
    }

    public static void main(String[] args) {
        test();
    }

}
