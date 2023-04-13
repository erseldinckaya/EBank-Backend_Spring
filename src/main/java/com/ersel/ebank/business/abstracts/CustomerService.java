package com.ersel.ebank.business.abstracts;

import com.ersel.ebank.business.requests.CreateCustomerRequest;
import com.ersel.ebank.business.requests.UpdateCustomerRequest;
import com.ersel.ebank.business.responses.GetByIdCustomerResponse;
import com.ersel.ebank.entities.concretes.Customer;
import com.ersel.ebank.utilities.results.Result;
import com.ersel.ebank.utilities.results.SuccessDataResult;

public interface CustomerService {
    Result add(CreateCustomerRequest request);
    Result update(UpdateCustomerRequest request);
    SuccessDataResult<GetByIdCustomerResponse> findById(int id);
}
