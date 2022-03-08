package com.poloniex.domain.account;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.poloniex.constant.PoloniexApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Withdrawal information.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Withdrawal {

    /**
     * The unique Poloniex specific withdrawal ID for this withdrawal.
     */
    private long id;

    /**
     * Asset symbol.
     */
    private String asset;

    /**
     * The total amount withdrawn including the fee.
     */
    private double quantity;
    private double fee;

    /**
     * The address to which the withdrawal was made.
     */
    private String address;

    /**
     * Optionally the transaction ID of the withdrawal.
     */
    private String txid;

    private WithdrawalStatus status;

    /**
     * The IP address which initiated the withdrawal request.
     */
    private String ipAddress;

    /**
     * The paymentID specified for this withdrawal. If none were specified, the field will be null.
     */
    private String paymentID;

    private LocalDateTime dateTime;

    public Withdrawal() {
    }

    @JsonCreator
    public Withdrawal(@JsonProperty("withdrawalNumber") long id,
                      @JsonProperty("currency") String asset,
                      @JsonProperty("amount") double quantity,
                      @JsonProperty("fee") double fee,
                      @JsonProperty("address") String address,
                      @JsonProperty("status") String statusInfo,
                      @JsonProperty("ipAddress") String ipAddress,
                      @JsonProperty("paymentID") String paymentID,
                      @JsonProperty("timestamp") long timestamp) {
        String[] statusAndTxid = statusInfo.split(":");
        this.id = id;
        this.asset = asset;
        this.quantity = quantity;
        this.fee = fee;
        this.address = address;
        this.txid = statusAndTxid[1].trim();
        this.status = WithdrawalStatus.valueOf(statusAndTxid[0]);
        this.ipAddress = ipAddress;
        this.paymentID = paymentID;
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

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
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

    public WithdrawalStatus getStatus() {
        return status;
    }

    public void setStatus(WithdrawalStatus status) {
        this.status = status;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
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
                .append("fee", fee)
                .append("address", address)
                .append("txid", txid)
                .append("status", status)
                .append("ipAddress", ipAddress)
                .append("paymentID", paymentID)
                .append("dateTime", dateTime)
                .toString();
    }
}
