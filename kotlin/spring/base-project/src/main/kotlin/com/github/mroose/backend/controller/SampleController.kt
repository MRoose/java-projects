package com.github.mroose.backend.controller

import com.github.mroose.backend.dto.SampleDto
import com.github.mroose.backend.service.SampleService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
class SampleController(val sampleService: SampleService) {

    @GetMapping("/api/v1/todos")
    fun getTodos(): Flux<SampleDto> {
        return sampleService.getTodos()
    }
}