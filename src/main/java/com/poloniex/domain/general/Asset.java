package com.poloniex.domain.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * An asset.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Asset {

    private Integer id;

    private String name;

    /**
     * The blockchain name the currency runs on.
     */
    private String blockchain;

    /**
     * The type of blockchain the currency runs on.
     */
    private String humanType;

    /**
     * The type of the currency.
     */
    private String currencyType;

    /**
     * If available, the deposit address for this currency.
     */
    private String depositAddress;

    /**
     * The network fee necessary to withdraw this currency.
     */
    @JsonProperty("txFee")
    private Double withdrawFee;

    /**
     * The minimum number of blocks necessary before a deposit can be credited to an account.
     */
    @JsonProperty("minConf")
    private Integer minConfirm;

    /**
     * Designates whether deposits and withdrawals are disabled.
     */
    private Boolean disabled;

    /**
     * Designates whether this currency has been delisted from the exchange.
     */
    private Boolean delisted;

    /**
     * Designates whether trading for this currency is disabled for trading.
     */
    private Boolean frozen;

    /**
     * Designates whether this currency is available to this customer due to geofencing restrictions.
     */
    private Boolean geofenced;
}