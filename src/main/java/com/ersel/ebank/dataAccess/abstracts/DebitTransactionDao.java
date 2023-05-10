package com.ersel.ebank.dataAccess.abstracts;

import com.ersel.ebank.entities.concretes.DebitTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DebitTransactionDao extends JpaRepository<DebitTransaction, Integer> {
    List<DebitTransaction> findDebitTransactionByAccountId_AccountId(int id);
    List<DebitTransaction> findDebitTransactionsByDestinationId(int id);
    List<DebitTransaction> findDebitTransactionsByAccountId_AccountIdAndTypeId_TypeId(int accountId, int typeId);
    List<DebitTransaction> findDebitTransactionsByAccountId_Customer_CustomerIdAndTypeId_TypeId(int customerId, int typeId);
}
