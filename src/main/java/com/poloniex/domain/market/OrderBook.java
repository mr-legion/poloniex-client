package com.poloniex.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.poloniex.constant.PoloniexApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

/**
 * Market order book.
 */
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
    private boolean frozen;

    /**
     * Indicates that orders posted to the market (new or move) must be non-matching orders
     * (no taker orders) or canceling open orders. Any orders that would match will be rejected.
     */
    @JsonSerialize(using = NumericBooleanSerializer.class)
    @JsonDeserialize(using = NumericBooleanDeserializer.class)
    private boolean postOnly;

    /**
     * An always-incrementing sequence number for this market.
     */
    private long seq;

    public OrderBook() {
    }

    public List<Order> getAsks() {
        return asks;
    }

    public void setAsks(List<Order> asks) {
        this.asks = asks;
    }

    public List<Order> getBids() {
        return bids;
    }

    public void setBids(List<Order> bids) {
        this.bids = bids;
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

    public long getSeq() {
        return seq;
    }

    public void setSeq(long seq) {
        this.seq = seq;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, PoloniexApiConstants.TO_STRING_BUILDER_STYLE)
                .append("asks", asks)
                .append("bids", bids)
                .append("frozen", frozen)
                .append("postOnly", postOnly)
                .append("seq", seq)
                .toString();
    }
}
