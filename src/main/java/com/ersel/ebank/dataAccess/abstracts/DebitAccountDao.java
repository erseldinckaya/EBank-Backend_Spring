package com.ersel.ebank.dataAccess.abstracts;

import com.ersel.ebank.entities.concretes.DebitAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DebitAccountDao extends JpaRepository<DebitAccount, Integer> {
    List<DebitAccount> getDebitAccountByCustomer_CustomerId(int id);
    DebitAccount getDebitAccountByAccountId(int id);
    DebitAccount getDebitAccountByCardNumber(String cardNumber);
}
