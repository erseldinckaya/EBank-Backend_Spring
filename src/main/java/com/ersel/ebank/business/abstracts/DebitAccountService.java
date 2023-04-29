package com.ersel.ebank.business.abstracts;

import com.ersel.ebank.business.requests.CreateDebitAccountRequest;
import com.ersel.ebank.business.responses.GetDebitAccountsByCustomerIdResponse;
import com.ersel.ebank.entities.concretes.DebitAccount;
import com.ersel.ebank.utilities.results.SuccessDataResult;
import com.ersel.ebank.utilities.results.SuccessResult;

import java.util.List;

public interface DebitAccountService {
    SuccessResult add(CreateDebitAccountRequest request);

    List<DebitAccount> getDebitsByCustomerId(int id);
    List<DebitAccount> getCards();
    SuccessResult deleteDebitCard(int id);
}
