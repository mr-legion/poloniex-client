package com.poloniex.impl;

import com.poloniex.PoloniexApiAsyncRestClient;
import com.poloniex.domain.account.TransactionHistory;
import com.poloniex.domain.general.Asset;
import com.poloniex.domain.market.MarketTicker;
import com.poloniex.domain.market.OrderBook;

import java.time.Instant;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static com.poloniex.constant.PoloniexApiConstants.RETURN_DEPOSITS_WITHDRAWALS;

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

    // Market endpoints

    @Override
    public CompletableFuture<Map<String, MarketTicker>> getMarketTickers() {
        CompletableFuture<Map<String, MarketTicker>> future = new CompletableFuture<>();
        poloniexApiService.getMarketTickers().enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }

    @Override
    public CompletableFuture<OrderBook> getOrderBook(String market, Integer limit) {
        CompletableFuture<OrderBook> future = new CompletableFuture<>();
        poloniexApiService.getOrderBook(market, limit).enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }

    // Account endpoints

    @Override
    public CompletableFuture<TransactionHistory> getTransactions(Long start, Long end) {
        CompletableFuture<TransactionHistory> future = new CompletableFuture<>();
        long nonce = Instant.now().toEpochMilli();
        poloniexApiService.getTransactions(RETURN_DEPOSITS_WITHDRAWALS, start, end, nonce)
                .enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }
}
