package com.poloniex.impl;

import com.poloniex.PoloniexApiRestClient;
import com.poloniex.domain.general.Asset;

import java.util.Map;

import static com.poloniex.impl.PoloniexApiServiceGenerator.executeSync;

/**
 * Implementation of Poloniex's REST API using Retrofit with synchronous/blocking method calls.
 */
public class PoloniexApiRestClientImpl implements PoloniexApiRestClient {

    private final PoloniexApiService poloniexApiService;

    public PoloniexApiRestClientImpl(PoloniexApiService poloniexApiService) {
        this.poloniexApiService = poloniexApiService;
    }

    // General endpoints

    @Override
    public Map<String, Asset> getAssets() {
        return executeSync(poloniexApiService.getAssets());
    }
}