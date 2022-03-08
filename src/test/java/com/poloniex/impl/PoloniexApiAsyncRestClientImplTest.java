package com.poloniex.impl;

import com.poloniex.PoloniexApiAsyncRestClient;
import com.poloniex.PoloniexApiClientFactory;
import com.poloniex.domain.account.TransactionHistory;
import com.poloniex.domain.general.Asset;
import com.poloniex.domain.market.MarketTicker;
import com.poloniex.domain.market.OrderBook;
import com.poloniex.security.ApiCredentials;
import org.hamcrest.collection.IsMapWithSize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PoloniexApiAsyncRestClientImplTest {

    private PoloniexApiAsyncRestClient poloniexApiAsyncRestClient;

    @BeforeEach
    public void setUp() {
        String apiKey = System.getenv("API_KEY");
        String secret = System.getenv("SECRET");
        ApiCredentials apiCredentials = new ApiCredentials(apiKey, secret);
        this.poloniexApiAsyncRestClient = PoloniexApiClientFactory.newInstance(apiCredentials).newAsyncRestClient();
    }

    @Test
    public void getAssets_ShouldReturnAssets() throws ExecutionException, InterruptedException {
        Map<String, Asset> assets = poloniexApiAsyncRestClient.getAssets().get();
        assertThat(assets, allOf(notNullValue(), is(not(IsMapWithSize.anEmptyMap()))));
    }

    @Test
    public void getMarketTickers_ShouldReturnMarketTickers() throws ExecutionException, InterruptedException {
        Map<String, MarketTicker> marketTickers = poloniexApiAsyncRestClient.getMarketTickers().get();
        assertThat(marketTickers, allOf(notNullValue(), is(not(IsMapWithSize.anEmptyMap()))));
    }

    @Test
    public void getOrderBook_ShouldReturnOrderBookForBTCUSDT() throws ExecutionException, InterruptedException {
        OrderBook orderBook = poloniexApiAsyncRestClient.getOrderBook("USDT_BTC", 10).get();
        assertThat(orderBook.getAsks(), is(not(empty())));
        assertThat(orderBook.getBids(), is(not(empty())));
    }

    @Test
    public void getTransactions_ShouldReturnTransactions() throws ExecutionException, InterruptedException {
        long startTime = Instant.now().minus(30, ChronoUnit.DAYS).getEpochSecond();
        long endTime = Instant.now().getEpochSecond();
        TransactionHistory transactions = poloniexApiAsyncRestClient.getTransactions(startTime, endTime).get();
    }
}