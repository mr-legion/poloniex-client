package com.poloniex.impl;

import com.poloniex.domain.general.Asset;
import com.poloniex.domain.market.MarketTicker;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.Map;

/**
 * Poloniex's REST API URL mappings.
 */
public interface PoloniexApiService {

    // General endpoints

    @GET("/public?command=returnCurrencies")
    Call<Map<String, Asset>> getAssets();

    // Market endpoints

    @GET("/public?command=returnTicker")
    Call<Map<String, MarketTicker>> getMarketTickers();

}
