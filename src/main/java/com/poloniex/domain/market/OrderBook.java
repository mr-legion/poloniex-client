package com.poloniex.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Market order book.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderBook {

    private List<Order> asks;
    private List<Order> bids;

    /**
     * Indicates if this market is currently trading or not.
     */
    @JsonProperty("isFrozen")
    @JsonSerialize(using = NumericBooleanSerializer.class)
    @JsonDeserialize(using = NumericBooleanDeserializer.class)
    private Boolean frozen;

    /**
     * Indicates that orders posted to the market (new or move) must be non-matching orders
     * (no taker orders) or canceling open orders. Any orders that would match will be rejected.
     */
    @JsonSerialize(using = NumericBooleanSerializer.class)
    @JsonDeserialize(using = NumericBooleanDeserializer.class)
    private Boolean postOnly;

    /**
     * An always-incrementing sequence number for this market.
     */
    private Long seq;
}
