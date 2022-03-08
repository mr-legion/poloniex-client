package com.poloniex.impl;

import com.poloniex.domain.account.TransactionHistory;
import com.poloniex.domain.general.Asset;
import com.poloniex.domain.market.MarketTicker;
import com.poloniex.domain.market.OrderBook;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

import static com.poloniex.constant.PoloniexApiConstants.AUTHORIZATION_REQUIRED_HEADER;

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

    @GET("/public?command=returnOrderBook")
    Call<OrderBook> getOrderBook(@Query("currencyPair") String market, @Query("depth") Integer limit);

    // Account endpoints

    @FormUrlEncoded
    @Headers(AUTHORIZATION_REQUIRED_HEADER)
    @POST("/tradingApi")
    Call<TransactionHistory> getTransactions(@Field("command") String command,
                                             @Field("start") Long start,
                                             @Field("end") Long end,
                                             @Field("nonce") Long nonce);
}
