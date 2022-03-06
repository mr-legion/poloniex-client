package com.poloniex.domain.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.poloniex.constant.PoloniexApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * An asset.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Asset {

    private int id;

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
    private double withdrawFee;

    /**
     * The minimum number of blocks necessary before a deposit can be credited to an account.
     */
    @JsonProperty("minConf")
    private int minConfirm;

    /**
     * Designates whether deposits and withdrawals are disabled.
     */
    private boolean disabled;

    /**
     * Designates whether this currency has been delisted from the exchange.
     */
    private boolean delisted;

    /**
     * Designates whether trading for this currency is disabled for trading.
     */
    private boolean frozen;

    /**
     * Designates whether this currency is available to this customer due to geofencing restrictions.
     */
    private boolean geofenced;

    public Asset() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBlockchain() {
        return blockchain;
    }

    public void setBlockchain(String blockchain) {
        this.blockchain = blockchain;
    }

    public String getHumanType() {
        return humanType;
    }

    public void setHumanType(String humanType) {
        this.humanType = humanType;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    public String getDepositAddress() {
        return depositAddress;
    }

    public void setDepositAddress(String depositAddress) {
        this.depositAddress = depositAddress;
    }

    public double getWithdrawFee() {
        return withdrawFee;
    }

    public void setWithdrawFee(double withdrawFee) {
        this.withdrawFee = withdrawFee;
    }

    public int getMinConfirm() {
        return minConfirm;
    }

    public void setMinConfirm(int minConfirm) {
        this.minConfirm = minConfirm;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public boolean isDelisted() {
        return delisted;
    }

    public void setDelisted(boolean delisted) {
        this.delisted = delisted;
    }

    public boolean isFrozen() {
        return frozen;
    }

    public void setFrozen(boolean frozen) {
        this.frozen = frozen;
    }

    public boolean isGeofenced() {
        return geofenced;
    }

    public void setGeofenced(boolean geofenced) {
        this.geofenced = geofenced;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, PoloniexApiConstants.TO_STRING_BUILDER_STYLE)
                .append("id", id)
                .append("name", name)
                .append("blockchain", blockchain)
                .append("humanType", humanType)
                .append("currencyType", currencyType)
                .append("depositAddress", depositAddress)
                .append("withdrawFee", withdrawFee)
                .append("minConfirm", minConfirm)
                .append("disabled", disabled)
                .append("delisted", delisted)
                .append("frozen", frozen)
                .append("geofenced", geofenced)
                .toString();
    }
}