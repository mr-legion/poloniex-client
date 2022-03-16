package com.poloniex.domain.account;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Withdrawal information.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Withdrawal {

    /**
     * The unique Poloniex specific withdrawal ID for this withdrawal.
     */
    private Long id;

    /**
     * Asset symbol.
     */
    private String asset;

    /**
     * The total amount withdrawn including the fee.
     */
    private Double quantity;
    private Double fee;

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

    @JsonCreator
    public Withdrawal(@JsonProperty("withdrawalNumber") Long id,
                      @JsonProperty("currency") String asset,
                      @JsonProperty("amount") Double quantity,
                      @JsonProperty("fee") Double fee,
                      @JsonProperty("address") String address,
                      @JsonProperty("status") String statusInfo,
                      @JsonProperty("ipAddress") String ipAddress,
                      @JsonProperty("paymentID") String paymentID,
                      @JsonProperty("timestamp") Long timestamp) {
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
}
