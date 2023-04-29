package com.ersel.ebank.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetDebitAccountsByCustomerIdResponse {
    private int accountId;
    private String openningDate;
    private int balance;
    private String cardNumber;
    private String expDate;
    private int cvc;
}
