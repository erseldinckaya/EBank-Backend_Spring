package com.ersel.ebank.business.requests;

import com.ersel.ebank.entities.concretes.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateDebitAccountRequest {
    private int customerId;

}
