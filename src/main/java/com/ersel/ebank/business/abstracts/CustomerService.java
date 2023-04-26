package com.ersel.ebank.business.abstracts;

import com.ersel.ebank.business.requests.CreateCustomerRequest;
import com.ersel.ebank.business.requests.UpdateCustomerRequest;
import com.ersel.ebank.business.responses.GetByIdCustomerResponse;
import com.ersel.ebank.business.responses.GetCustomerByMailResponse;
import com.ersel.ebank.utilities.results.Result;
import com.ersel.ebank.utilities.results.SuccessDataResult;
import com.ersel.ebank.utilities.results.SuccessResult;

public interface CustomerService {
    //Result add(CreateCustomerRequest request);
    SuccessResult add(CreateCustomerRequest request);
    Result update(UpdateCustomerRequest request);
    SuccessDataResult<GetByIdCustomerResponse> findById(int id);
    SuccessDataResult<GetCustomerByMailResponse> findByMail(String mail);

}
