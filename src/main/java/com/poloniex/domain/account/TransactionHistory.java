package com.poloniex.domain.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Transaction history.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionHistory {
    private List<Adjustment> adjustments;
    private List<Deposit> deposits;
    private List<Withdrawal> withdrawals;
}
