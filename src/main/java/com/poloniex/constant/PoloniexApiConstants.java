package com.poloniex.constant;

import lombok.experimental.UtilityClass;

/**
 * Constants used throughout Poloniex's API.
 */
@UtilityClass
public class PoloniexApiConstants {

    /**
     * Base domain.
     */
    public static final String BASE_DOMAIN = "poloniex.com";

    /**
     * REST API base URL.
     */
    public static final String API_BASE_URL = "https://" + BASE_DOMAIN;

    /**
     * HTTP Header to be used for API-KEY authentication.
     */
    public static final String API_KEY_HEADER = "Key";
    public static final String API_SIGN_HEADER = "Sign";

    /**
     * Decorator to indicate that an endpoint requires authorization.
     */
    public static final String AUTHORIZATION_REQUIRED = "AUTHORIZATION";
    public static final String AUTHORIZATION_REQUIRED_HEADER = AUTHORIZATION_REQUIRED + ": #";

    /**
     * Private API commands.
     */
    public static final String RETURN_DEPOSITS_WITHDRAWALS = "returnDepositsWithdrawals";
}
