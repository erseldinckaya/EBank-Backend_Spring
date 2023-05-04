package com.ersel.ebank.dataAccess.abstracts;

import com.ersel.ebank.entities.concretes.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionTypeDao extends JpaRepository<TransactionType, Integer> {
    TransactionType findTransactionTypeByTypeId(int id);
}
