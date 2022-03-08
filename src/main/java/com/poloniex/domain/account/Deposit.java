package com.poloniex.domain.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.poloniex.constant.PoloniexApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Deposit information.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Deposit {

    /**
     * The unique Poloniex specific deposit ID for this deposit.
     */
    private long id;

    /**
     * Asset symbol.
     */
    private String asset;

    private double quantity;

    private DepositStatus status;

    /**
     * The address to which this deposit was sent.
     */
    private String address;

    /**
     * The blockchain transaction ID of this deposit.
     */
    private String txid;

    /**
     * The total number of confirmations for this deposit.
     */
    private int conf;

    private LocalDateTime dateTime;

    public Deposit() {
    }

    public Deposit(@JsonProperty("depositNumber") long id,
                   @JsonProperty("currency") String asset,
                   @JsonProperty("amount") double quantity,
                   @JsonProperty("status") DepositStatus status,
                   @JsonProperty("address") String address,
                   @JsonProperty("txid") String txid,
                   @JsonProperty("confirmations") int conf,
                   @JsonProperty("timestamp") long timestamp) {
        this.id = id;
        this.asset = asset;
        this.quantity = quantity;
        this.status = status;
        this.address = address;
        this.txid = txid;
        this.conf = conf;
        this.dateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp), ZoneId.systemDefault());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public DepositStatus getStatus() {
        return status;
    }

    public void setStatus(DepositStatus status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTxid() {
        return txid;
    }

    public void setTxid(String txid) {
        this.txid = txid;
    }

    public int getConf() {
        return conf;
    }

    public void setConf(int conf) {
        this.conf = conf;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, PoloniexApiConstants.TO_STRING_BUILDER_STYLE)
                .append("id", id)
                .append("asset", asset)
                .append("quantity", quantity)
                .append("status", status)
                .append("address", address)
                .append("txid", txid)
                .append("conf", conf)
                .append("dateTime", dateTime)
                .toString();
    }
}
