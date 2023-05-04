package com.ersel.ebank.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateDebitTransactionRequest {
    private int destinationId;
    private int accountId;
    private String description;
    private int amount;
    private String transactionName;
    private int  typeId;
}
