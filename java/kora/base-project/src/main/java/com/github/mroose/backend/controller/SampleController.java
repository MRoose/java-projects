package com.github.mroose.backend.controller;

import com.github.mroose.backend.dto.SampleDto;
import com.github.mroose.backend.service.SampleService;
import lombok.RequiredArgsConstructor;
import ru.tinkoff.kora.http.common.HttpMethod;
import ru.tinkoff.kora.http.common.annotation.HttpRoute;
import ru.tinkoff.kora.http.server.common.annotation.HttpController;

import java.util.List;

@HttpController
@RequiredArgsConstructor
public final class SampleController {

    private final SampleService sampleService;

    @HttpRoute(method = HttpMethod.GET, path = "/api/v1/todos")
    public List<SampleDto> getTodos() {
        return sampleService.getTodos();
    }
}