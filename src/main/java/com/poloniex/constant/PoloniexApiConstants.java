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
     * Default ToStringStyle used by toString methods.
     */
    public static final ToStringStyle TO_STRING_BUILDER_STYLE = ToStringStyle.SHORT_PREFIX_STYLE;
}
