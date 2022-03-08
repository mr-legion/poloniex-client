package com.poloniex.constant;

import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Constants used throughout Poloniex's API.
 */
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

    /**
     * Default ToStringStyle used by toString methods.
     */
    public static final ToStringStyle TO_STRING_BUILDER_STYLE = ToStringStyle.SHORT_PREFIX_STYLE;
}
