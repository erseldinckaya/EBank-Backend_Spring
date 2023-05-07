package com.ersel.ebank.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCardValuesResponse {
    private int balance;
    private int incomes;
    private int expenses;
    private boolean status;
}
