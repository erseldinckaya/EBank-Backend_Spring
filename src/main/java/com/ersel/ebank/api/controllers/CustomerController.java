package com.ersel.ebank.api.controllers;

import com.ersel.ebank.business.abstracts.CustomerService;
import com.ersel.ebank.business.requests.CreateCustomerRequest;
import com.ersel.ebank.business.requests.UpdateCustomerRequest;
import com.ersel.ebank.business.responses.GetByIdCustomerResponse;
import com.ersel.ebank.entities.concretes.Customer;
import com.ersel.ebank.utilities.results.Result;
import com.ersel.ebank.utilities.results.SuccessDataResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
@AllArgsConstructor
public class CustomerController {

    private CustomerService customerService;

    @PostMapping("/add")
    public Result add(@RequestBody CreateCustomerRequest request){
        return this.customerService.add(request);
    }
    @PutMapping("/update")
    public Result update(@RequestBody UpdateCustomerRequest request){ return this.customerService.update(request);}
    @GetMapping("/getById")
    public SuccessDataResult<GetByIdCustomerResponse> findById(@RequestParam int id){return this.customerService.findById(id);}
}
