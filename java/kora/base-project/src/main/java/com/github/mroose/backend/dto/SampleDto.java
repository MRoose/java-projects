package com.github.mroose.backend.dto;

import ru.tinkoff.kora.json.common.annotation.Json;

@Json
public record SampleDto(Integer id, Integer userId, String title, Boolean completed) {
}