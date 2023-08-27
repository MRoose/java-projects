package com.github.mroose.backend.service;

import com.github.mroose.backend.config.client.BaseWebClientConfig;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import com.github.mroose.backend.dto.SampleDto;
import reactor.core.publisher.Mono;
import ru.tinkoff.kora.common.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SampleService {

    private final BaseWebClientConfig baseWebClient;

    public List<SampleDto> getTodos() {
        return baseWebClient.getTodos();
    }
}