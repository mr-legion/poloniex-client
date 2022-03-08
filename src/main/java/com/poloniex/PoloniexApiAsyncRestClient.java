package com.poloniex;

import com.poloniex.domain.account.TransactionHistory;
import com.poloniex.domain.general.Asset;
import com.poloniex.domain.market.MarketTicker;
import com.poloniex.domain.market.OrderBook;

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

    /**
     * Get order book of a market (asynchronous).
     *
     * @param market ticker symbol (e.g. USDT_BTC)
     * @param limit  depth of the order book. Max depth is 100.
     * @return orderbook
     */
    CompletableFuture<OrderBook> getOrderBook(String market, Integer limit);

    // Account endpoints

    /**
     * Get transaction history within a range window (asynchronous).
     *
     * @param start the start date of the range window in UNIX timestamp format
     * @param end   the end date of the range window in UNIX timestamp format
     * @return transactions
     */
    CompletableFuture<TransactionHistory> getTransactions(Long start, Long end);
}