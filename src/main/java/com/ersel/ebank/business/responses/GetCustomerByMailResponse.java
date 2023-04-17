package com.ersel.ebank.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetCustomerByMailResponse {
    private int customerId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String mail;
    private int creditPoint;

    private String password;
}
