package com.github.mroose.backend.controller;

import com.github.mroose.backend.dto.SampleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import com.github.mroose.backend.service.SampleService;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
public class SampleController {

    private final SampleService sampleService;

    @GetMapping("/api/v1/todos")
    public Flux<SampleDto> getTodos() {
        return sampleService.getTodos();
    }
}