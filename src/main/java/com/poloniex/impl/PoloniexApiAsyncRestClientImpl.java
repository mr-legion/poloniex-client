package com.poloniex.impl;

import com.poloniex.PoloniexApiAsyncRestClient;
import com.poloniex.domain.general.Asset;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Implementation of Poloniex's REST API using Retrofit with asynchronous/non-blocking method calls.
 */
public class PoloniexApiAsyncRestClientImpl implements PoloniexApiAsyncRestClient {

    private final PoloniexApiService poloniexApiService;

    public PoloniexApiAsyncRestClientImpl(PoloniexApiService poloniexApiService) {
        this.poloniexApiService = poloniexApiService;
    }

    // General endpoints

    @Override
    public CompletableFuture<Map<String, Asset>> getAssets() {
        CompletableFuture<Map<String, Asset>> future = new CompletableFuture<>();
        poloniexApiService.getAssets().enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }
}
