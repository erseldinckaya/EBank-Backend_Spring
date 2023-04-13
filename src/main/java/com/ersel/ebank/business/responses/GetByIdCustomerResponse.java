package com.ersel.ebank.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdCustomerResponse {

    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String mail;
    private int creditPoint;
}
