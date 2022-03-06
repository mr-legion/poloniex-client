package com.poloniex.impl;

import com.poloniex.PoloniexApiClientFactory;
import com.poloniex.PoloniexApiRestClient;
import com.poloniex.domain.general.Asset;
import com.poloniex.domain.market.MarketTicker;
import org.hamcrest.collection.IsMapWithSize;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PoloniexApiRestClientImplTest {

    private final PoloniexApiRestClient poloniexApiRestClient = PoloniexApiClientFactory.newInstance().newRestClient();

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
}