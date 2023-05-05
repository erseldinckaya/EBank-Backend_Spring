package com.ersel.ebank.business.abstracts;

import com.ersel.ebank.entities.concretes.TransactionType;

public interface TransactionTypeService {
    TransactionType findTransactionType(int id);
}
