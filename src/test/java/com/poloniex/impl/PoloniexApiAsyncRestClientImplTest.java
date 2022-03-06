package com.poloniex.impl;

import com.poloniex.PoloniexApiAsyncRestClient;
import com.poloniex.PoloniexApiClientFactory;
import com.poloniex.domain.general.Asset;
import org.hamcrest.collection.IsMapWithSize;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.concurrent.ExecutionException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PoloniexApiAsyncRestClientImplTest {

    private final PoloniexApiAsyncRestClient poloniexApiAsyncRestClient = PoloniexApiClientFactory.newInstance().newAsyncRestClient();

    @Test
    public void getAssets_ShouldReturnAssets() throws ExecutionException, InterruptedException {
        Map<String, Asset> assets = poloniexApiAsyncRestClient.getAssets().get();
        assertThat(assets, allOf(notNullValue(), is(not(IsMapWithSize.anEmptyMap()))));
    }
}