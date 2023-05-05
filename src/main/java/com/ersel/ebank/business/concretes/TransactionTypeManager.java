package com.ersel.ebank.business.concretes;

import com.ersel.ebank.business.abstracts.TransactionTypeService;
import com.ersel.ebank.dataAccess.abstracts.TransactionTypeDao;
import com.ersel.ebank.entities.concretes.TransactionType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TransactionTypeManager implements TransactionTypeService {
    private TransactionTypeDao typeDao;
    @Override
    public TransactionType findTransactionType(int id) {
        return this.typeDao.findTransactionTypeByTypeId(id);
    }
}
