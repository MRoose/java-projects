package com.github.mroose.backend.service

import com.github.mroose.backend.dto.SampleDto
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux

@Service
class SampleService(val baseWebClient: WebClient) {

    fun getTodos(): Flux<SampleDto> {
        return baseWebClient
            .get()
            .uri("http://jsonplaceholder.typicode.com/todos")
            .retrieve()
            .bodyToFlux(SampleDto::class.java)
    }
}