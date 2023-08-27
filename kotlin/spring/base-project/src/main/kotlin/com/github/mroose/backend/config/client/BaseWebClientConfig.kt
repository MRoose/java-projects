package com.github.mroose.backend.config.client

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class BaseWebClientConfig {

    @Bean
    fun baseWebClient(): WebClient {
        return WebClient.create()
    }
}