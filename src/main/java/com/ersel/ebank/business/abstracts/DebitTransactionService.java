package com.ersel.ebank.business.abstracts;

import com.ersel.ebank.entities.concretes.DebitTransaction;
import com.ersel.ebank.utilities.results.SuccessResult;

import java.util.List;

public interface DebitTransactionService {
    SuccessResult add(DebitTransaction request);
    List<DebitTransaction> getAll();
    List<DebitTransaction> getByAccountId(int id);
    List<DebitTransaction> getByDestinationId(int id);
}
