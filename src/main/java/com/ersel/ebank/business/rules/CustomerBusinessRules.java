package com.ersel.ebank.business.rules;

import com.ersel.ebank.dataAccess.abstracts.CustomerDao;
import com.ersel.ebank.utilities.exceptions.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CustomerBusinessRules {
    private CustomerDao customerDao;

    public void checkIfCustomerMailExists(String mail){
        if(this.customerDao.existsCustomerByMail(mail)){
            throw new BusinessException("Customer already exists !");
        }
    }
}
