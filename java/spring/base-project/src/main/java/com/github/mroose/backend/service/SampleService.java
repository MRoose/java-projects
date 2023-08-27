package com.github.mroose.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import com.github.mroose.backend.dto.SampleDto;

@RequiredArgsConstructor
@Service
public class SampleService {

    private final WebClient baseWebClient;

    public Flux<SampleDto> getTodos() {
        return baseWebClient
                .get()
                .uri("http://jsonplaceholder.typicode.com/todos")
                .retrieve()
                .bodyToFlux(SampleDto.class);
    }
}