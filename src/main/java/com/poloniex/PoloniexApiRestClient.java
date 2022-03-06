package com.poloniex;

import com.poloniex.domain.general.Asset;
import com.poloniex.domain.market.MarketTicker;
import com.poloniex.domain.market.OrderBook;

import java.util.Map;

/**
 * Poloniex API facade, supporting synchronous/blocking access Poloniex's REST API.
 */
public interface PoloniexApiRestClient {

    // General endpoints

    /**
     * Get all supported assets.
     *
     * @return assets
     */
    Map<String, Asset> getAssets();

    // Market endpoints

    /**
     * Get all the information about the markets.
     *
     * @return market tickers
     */
    Map<String, MarketTicker> getMarketTickers();

    /**
     * Get order book of a market.
     *
     * @param market ticker symbol (e.g. USDT_BTC)
     * @param limit  depth of the order book. Max depth is 100.
     * @return orderbook
     */
    OrderBook getOrderBook(String market, Integer limit);

}