package com.poloniex.impl;

import com.poloniex.PoloniexApiClientFactory;
import com.poloniex.PoloniexApiRestClient;
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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PoloniexApiRestClientImplTest {

    private PoloniexApiRestClient poloniexApiRestClient;

    @BeforeEach
    public void setUp() {
        String apiKey = System.getenv("API_KEY");
        String secret = System.getenv("SECRET");
        ApiCredentials apiCredentials = new ApiCredentials(apiKey, secret);
        this.poloniexApiRestClient = PoloniexApiClientFactory.newInstance(apiCredentials).newRestClient();
    }

    @Test
    public void getAssets_ShouldReturnAssets() {
        Map<String, Asset> assets = poloniexApiRestClient.getAssets();
        assertThat(assets, allOf(notNullValue(), is(not(IsMapWithSize.anEmptyMap()))));
    }

    @Test
    public void getMarketTickers_ShouldReturnMarketTickers() {
        Map<String, MarketTicker> marketTickers = poloniexApiRestClient.getMarketTickers();
        assertThat(marketTickers, allOf(notNullValue(), is(not(IsMapWithSize.anEmptyMap()))));
    }

    @Test
    public void getOrderBook_ShouldReturnOrderBookForBTCUSDT() {
        OrderBook orderBook = poloniexApiRestClient.getOrderBook("USDT_BTC", 10);
        assertThat(orderBook.getAsks(), is(not(empty())));
        assertThat(orderBook.getBids(), is(not(empty())));
    }

    @Test
    public void getTransactions_ShouldReturnTransactions() {
        long startTime = Instant.now().minus(30, ChronoUnit.DAYS).getEpochSecond();
        long endTime = Instant.now().getEpochSecond();
        TransactionHistory transactions = poloniexApiRestClient.getTransactions(startTime, endTime);
    }
}