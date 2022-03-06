package com.poloniex;

import com.poloniex.domain.general.Asset;
import com.poloniex.domain.market.MarketTicker;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Poloniex API facade, supporting asynchronous/non-blocking access Poloniex's REST API.
 */
public interface PoloniexApiAsyncRestClient {

    // General endpoints

    /**
     * Get all supported assets (asynchronous).
     *
     * @return assets
     */
    CompletableFuture<Map<String, Asset>> getAssets();

    // Market endpoints

    /**
     * Get all the information about the markets (asynchronous).
     *
     * @return market tickers
     */
    CompletableFuture<Map<String, MarketTicker>> getMarketTickers();

}