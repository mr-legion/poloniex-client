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
 * Adjustment information.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Adjustment {

    /**
     * The type of adjustment.
     */
    private String title;

    /**
     * A human-readable description of the adjustment.
     */
    private String desc;

    /**
     * A help center link to describe the adjustment.
     */
    private String help;

    /**
     * Always adjustment.
     */
    private String category;

    /**
     * Asset symbol.
     */
    private String asset;

    private double quantity;

    private AdjustmentStatus status;

    private LocalDateTime dateTime;

    public Adjustment() {
    }

    @JsonCreator
    public Adjustment(@JsonProperty("adjustmentTitle") String title,
                      @JsonProperty("adjustmentDesc") String desc,
                      @JsonProperty("adjustmentHelp") String help,
                      @JsonProperty("category") String category,
                      @JsonProperty("currency") String asset,
                      @JsonProperty("amount") double quantity,
                      @JsonProperty("status") AdjustmentStatus status,
                      @JsonProperty("timestamp") long timestamp) {
        this.title = title;
        this.desc = desc;
        this.help = help;
        this.category = category;
        this.asset = asset;
        this.quantity = quantity;
        this.status = status;
        this.dateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp), ZoneId.systemDefault());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public AdjustmentStatus getStatus() {
        return status;
    }

    public void setStatus(AdjustmentStatus status) {
        this.status = status;
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
                .append("title", title)
                .append("desc", desc)
                .append("help", help)
                .append("category", category)
                .append("asset", asset)
                .append("quantity", quantity)
                .append("status", status)
                .append("dateTime", dateTime)
                .toString();
    }
}
