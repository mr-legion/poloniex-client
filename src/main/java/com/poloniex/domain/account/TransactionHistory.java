package com.poloniex.domain.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.poloniex.constant.PoloniexApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

/**
 * Transaction history.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionHistory {

    private List<Adjustment> adjustments;
    private List<Deposit> deposits;
    private List<Withdrawal> withdrawals;

    public TransactionHistory() {
    }

    public List<Adjustment> getAdjustments() {
        return adjustments;
    }

    public void setAdjustments(List<Adjustment> adjustments) {
        this.adjustments = adjustments;
    }

    public List<Deposit> getDeposits() {
        return deposits;
    }

    public void setDeposits(List<Deposit> deposits) {
        this.deposits = deposits;
    }

    public List<Withdrawal> getWithdrawals() {
        return withdrawals;
    }

    public void setWithdrawals(List<Withdrawal> withdrawals) {
        this.withdrawals = withdrawals;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, PoloniexApiConstants.TO_STRING_BUILDER_STYLE)
                .append("adjustments", adjustments)
                .append("deposits", deposits)
                .append("withdrawals", withdrawals)
                .toString();
    }
}
