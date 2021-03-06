package com.poloniex.domain.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Deposit information.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Deposit {

    /**
     * The unique Poloniex specific deposit ID for this deposit.
     */
    private Long id;

    /**
     * Asset symbol.
     */
    private String asset;

    private Double quantity;

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
    private Integer conf;

    private LocalDateTime dateTime;

    public Deposit(@JsonProperty("depositNumber") Long id,
                   @JsonProperty("currency") String asset,
                   @JsonProperty("amount") Double quantity,
                   @JsonProperty("status") DepositStatus status,
                   @JsonProperty("address") String address,
                   @JsonProperty("txid") String txid,
                   @JsonProperty("confirmations") Integer conf,
                   @JsonProperty("timestamp") Long timestamp) {
        this.id = id;
        this.asset = asset;
        this.quantity = quantity;
        this.status = status;
        this.address = address;
        this.txid = txid;
        this.conf = conf;
        this.dateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp), ZoneId.systemDefault());
    }
}
