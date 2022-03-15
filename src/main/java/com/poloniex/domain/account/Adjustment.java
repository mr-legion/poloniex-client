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
 * Adjustment information.
 */
@NoArgsConstructor
@Data
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
}
