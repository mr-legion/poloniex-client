package com.poloniex;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.poloniex.constant.PoloniexApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Poloniex API error.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PoloniexApiError {

    @JsonProperty("error")
    private String msg;

    public PoloniexApiError() {
    }

    public PoloniexApiError(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, PoloniexApiConstants.TO_STRING_BUILDER_STYLE)
                .append("msg", msg)
                .toString();
    }
}
