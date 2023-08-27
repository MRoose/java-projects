package com.github.mroose.backend;

import ru.tinkoff.kora.application.graph.KoraApplication;
import ru.tinkoff.kora.common.KoraApp;
import ru.tinkoff.kora.config.common.CommonConfigModule;
import ru.tinkoff.kora.http.client.async.AsyncHttpClientModule;
import ru.tinkoff.kora.http.server.undertow.UndertowHttpServerModule;
import ru.tinkoff.kora.json.module.JsonModule;

@KoraApp
public interface Application extends
        CommonConfigModule,
        JsonModule,
        AsyncHttpClientModule,
        UndertowHttpServerModule {

    static void main(String[] args) {
        KoraApplication.run(ApplicationGraph::graph);
    }
}