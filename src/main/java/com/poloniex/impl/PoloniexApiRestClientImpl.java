package com.poloniex.impl;

import com.poloniex.PoloniexApiRestClient;
import com.poloniex.domain.account.TransactionHistory;
import com.poloniex.domain.general.Asset;
import com.poloniex.domain.market.MarketTicker;
import com.poloniex.domain.market.OrderBook;

import java.time.Instant;
import java.util.Map;

import static com.poloniex.constant.PoloniexApiConstants.RETURN_DEPOSITS_WITHDRAWALS;
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

    // Market endpoints

    @Override
    public Map<String, MarketTicker> getMarketTickers() {
        return executeSync(poloniexApiService.getMarketTickers());
    }

    @Override
    public OrderBook getOrderBook(String market, Integer limit) {
        return executeSync(poloniexApiService.getOrderBook(market, limit));
    }

    // Account endpoints

    @Override
    public TransactionHistory getTransactions(Long start, Long end) {
        long nonce = Instant.now().toEpochMilli();
        return executeSync(poloniexApiService.getTransactions(RETURN_DEPOSITS_WITHDRAWALS, start, end, nonce));
    }
}
