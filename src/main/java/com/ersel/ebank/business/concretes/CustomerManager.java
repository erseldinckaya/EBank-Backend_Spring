package com.ersel.ebank.business.concretes;

import com.ersel.ebank.business.abstracts.CustomerService;
import com.ersel.ebank.business.requests.CreateCustomerRequest;
import com.ersel.ebank.business.requests.UpdateCustomerRequest;
import com.ersel.ebank.business.responses.GetByIdCustomerResponse;
import com.ersel.ebank.business.responses.GetCustomerByMailResponse;
import com.ersel.ebank.dataAccess.abstracts.CustomerDao;
import com.ersel.ebank.entities.concretes.Customer;
import com.ersel.ebank.utilities.mappers.ModelMapperService;
import com.ersel.ebank.utilities.results.Result;
import com.ersel.ebank.utilities.results.SuccessDataResult;
import com.ersel.ebank.utilities.results.SuccessResult;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CustomerManager implements CustomerService {

    private CustomerDao customerDao;
    private ModelMapperService modelMapperService;

    @Override
    public Result add(CreateCustomerRequest request) {
        Customer customer = this.modelMapperService.forRequest().map(request, Customer.class);
        this.customerDao.save(customer);
        return new SuccessResult("Kullanıcı başarıyla eklendi !");
    }

    @Override
    public Result update(UpdateCustomerRequest request) {
        Customer customer = this.modelMapperService.forRequest().map(request, Customer.class);
        this.customerDao.save(customer);
        return new SuccessResult("Kullanıcı başarıyla güncellendi !");
    }

    @Override
    public SuccessDataResult<GetByIdCustomerResponse> findById(int id) {

        Customer customer = this.customerDao.findCustomerByCustomerId(id);
        GetByIdCustomerResponse response = this.modelMapperService.forResponse().map(customer, GetByIdCustomerResponse.class);
        return new SuccessDataResult<>(response,"Müşteri Bulundu !");
    }

    @Override
    public SuccessDataResult<GetCustomerByMailResponse> findByMail(String mail) {
        Customer customer = this.customerDao.findCustomerByMail(mail);
        GetCustomerByMailResponse response = this.modelMapperService.forResponse().map(customer, GetCustomerByMailResponse.class);
        return new SuccessDataResult<>(response,"Müşteri Bulundu !");
    }
}
