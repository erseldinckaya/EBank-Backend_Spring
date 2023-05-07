package com.ersel.ebank.business.rules;

import org.springframework.stereotype.Service;

@Service
public class TransactionBusinessRules {

    public void checkIfBalanceLessZero(int balance, int amount){
        if(balance-amount < 0){
            throw new RuntimeException("Don't have enough money !");
        }
    }
}
