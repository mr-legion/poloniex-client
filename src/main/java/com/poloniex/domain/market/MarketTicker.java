package com.poloniex.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Market information.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketTicker {

    private Integer id;

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

    @JsonSerialize(using = NumericBooleanSerializer.class)
    @JsonDeserialize(using = NumericBooleanDeserializer.class)
    private Boolean marginTradingEnabled;

    /**
     * Execution price for the most recent trade for this pair.
     */
    private Double last;

    @JsonProperty("lowestAsk")
    private Double ask;

    @JsonProperty("highestBid")
    private Double bid;

    private Double percentChange;
    private Double baseVolume;
    private Double quoteVolume;
    private Double high24hr;
    private Double low24hr;
}
