package com.ersel.ebank.api.controllers;

import com.ersel.ebank.business.abstracts.DebitAccountService;
import com.ersel.ebank.business.requests.CreateDebitAccountRequest;
import com.ersel.ebank.business.responses.GetDebitAccountsByCustomerIdResponse;
import com.ersel.ebank.entities.concretes.DebitAccount;
import com.ersel.ebank.utilities.results.SuccessDataResult;
import com.ersel.ebank.utilities.results.SuccessResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts/debit")
@AllArgsConstructor
@CrossOrigin
public class DebitAccountsController {
    private DebitAccountService debitAccountService;

    @PostMapping("/add")
    SuccessResult add(@RequestBody CreateDebitAccountRequest request){
        return this.debitAccountService.add(request);
    }
    @GetMapping("/getAll")
    public List<DebitAccount> getCards() {
        return this.debitAccountService.getCards();
    }

    @GetMapping("/getByCustomerId")
    public List<DebitAccount> getDebitsByCustomerId(@RequestParam int id){
        return this.debitAccountService.getDebitsByCustomerId(id);
    }

    @DeleteMapping("/delete")
    public SuccessResult deleteDebitCard(int id) {
        return this.debitAccountService.deleteDebitCard(id);
    }


    }
