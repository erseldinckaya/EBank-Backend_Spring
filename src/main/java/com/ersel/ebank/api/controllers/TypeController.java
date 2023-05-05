package com.ersel.ebank.api.controllers;

import com.ersel.ebank.business.abstracts.TransactionTypeService;
import com.ersel.ebank.entities.concretes.TransactionType;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions/type")
@AllArgsConstructor
@CrossOrigin
public class TypeController {
    private TransactionTypeService typeService;

    @GetMapping("/getById")
    TransactionType getById(@RequestParam int id){
        return this.typeService.findTransactionType(id);
    }
}
