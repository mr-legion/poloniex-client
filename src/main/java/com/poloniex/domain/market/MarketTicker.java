package com.poloniex.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.poloniex.constant.PoloniexApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Market information.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketTicker {

    private int id;

    /**
     * Indicates if this market is currently trading or not.
     */
    @JsonProperty("isFrozen")
    @JsonSerialize(using = NumericBooleanSerializer.class)
    @JsonDeserialize(using = NumericBooleanDeserializer.class)
    private boolean frozen;

    /**
     * Indicates that orders posted to the market (new or move) must be non-matching orders
     * (no taker orders) or canceling open orders. Any orders that would match will be rejected.
     */
    @JsonSerialize(using = NumericBooleanSerializer.class)
    @JsonDeserialize(using = NumericBooleanDeserializer.class)
    private boolean postOnly;

    @JsonSerialize(using = NumericBooleanSerializer.class)
    @JsonDeserialize(using = NumericBooleanDeserializer.class)
    private boolean marginTradingEnabled;

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

    public MarketTicker() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isFrozen() {
        return frozen;
    }

    public void setFrozen(boolean frozen) {
        this.frozen = frozen;
    }

    public boolean isPostOnly() {
        return postOnly;
    }

    public void setPostOnly(boolean postOnly) {
        this.postOnly = postOnly;
    }

    public boolean isMarginTradingEnabled() {
        return marginTradingEnabled;
    }

    public void setMarginTradingEnabled(boolean marginTradingEnabled) {
        this.marginTradingEnabled = marginTradingEnabled;
    }

    public Double getLast() {
        return last;
    }

    public void setLast(Double last) {
        this.last = last;
    }

    public Double getAsk() {
        return ask;
    }

    public void setAsk(Double ask) {
        this.ask = ask;
    }

    public Double getBid() {
        return bid;
    }

    public void setBid(Double bid) {
        this.bid = bid;
    }

    public Double getPercentChange() {
        return percentChange;
    }

    public void setPercentChange(Double percentChange) {
        this.percentChange = percentChange;
    }

    public Double getBaseVolume() {
        return baseVolume;
    }

    public void setBaseVolume(Double baseVolume) {
        this.baseVolume = baseVolume;
    }

    public Double getQuoteVolume() {
        return quoteVolume;
    }

    public void setQuoteVolume(Double quoteVolume) {
        this.quoteVolume = quoteVolume;
    }

    public Double getHigh24hr() {
        return high24hr;
    }

    public void setHigh24hr(Double high24hr) {
        this.high24hr = high24hr;
    }

    public Double getLow24hr() {
        return low24hr;
    }

    public void setLow24hr(Double low24hr) {
        this.low24hr = low24hr;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, PoloniexApiConstants.TO_STRING_BUILDER_STYLE)
                .append("id", id)
                .append("frozen", frozen)
                .append("postOnly", postOnly)
                .append("marginTradingEnabled", marginTradingEnabled)
                .append("last", last)
                .append("ask", ask)
                .append("bid", bid)
                .append("percentChange", percentChange)
                .append("baseVolume", baseVolume)
                .append("quoteVolume", quoteVolume)
                .append("high24hr", high24hr)
                .append("low24hr", low24hr)
                .toString();
    }
}
