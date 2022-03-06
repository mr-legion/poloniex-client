package com.poloniex;

import com.poloniex.domain.general.Asset;

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

}