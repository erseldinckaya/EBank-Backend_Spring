package com.ersel.ebank.api.controllers;

import com.ersel.ebank.business.abstracts.DebitTransactionService;
import com.ersel.ebank.entities.concretes.DebitTransaction;
import com.ersel.ebank.utilities.results.SuccessResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/accounts/transaction")
@CrossOrigin
public class DebitTransactionsController {
    private DebitTransactionService debitTransactionService;

    @PostMapping("/add")
    SuccessResult add(@RequestBody DebitTransaction request){ return this.debitTransactionService.add(request);}

    @GetMapping("/getAll")
    List<DebitTransaction> getAll(){return this.debitTransactionService.getAll();}

    @GetMapping("/getByAccountId")
    List<DebitTransaction> getByAccountId(@RequestParam int id){return this.debitTransactionService.getByAccountId(id);}

    @GetMapping("/getByDestinationId")
    List<DebitTransaction> getByDestinationId(@RequestParam int id){return this.debitTransactionService.getByDestinationId(id);}

    @GetMapping("/getByCustomerId")
    List<DebitTransaction> getByCustomerId(@RequestParam int customerId){return this.debitTransactionService.getByCustomerId(customerId);}
}
