package com.github.mroose.backend.config.client;

import com.github.mroose.backend.dto.SampleDto;
import ru.tinkoff.kora.http.client.common.annotation.HttpClient;
import ru.tinkoff.kora.http.common.HttpMethod;
import ru.tinkoff.kora.http.common.annotation.HttpRoute;

import java.util.List;

@HttpClient
public interface BaseWebClientConfig {

    @HttpRoute(method = HttpMethod.GET, path = "/todos")
    List<SampleDto> getTodos();
}