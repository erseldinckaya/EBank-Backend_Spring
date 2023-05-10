package com.ersel.ebank.api.controllers;

import com.ersel.ebank.business.abstracts.CardValuesService;
import com.ersel.ebank.business.responses.GetCardValuesResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cardvalue")
@AllArgsConstructor
@CrossOrigin
public class CardValuesController {
    private CardValuesService cardValuesService;

    @GetMapping("/getById")
    public GetCardValuesResponse getById(@RequestParam int id){
        return this.cardValuesService.getValues(id);
    }

    @GetMapping("/getByCustomerId")
    public GetCardValuesResponse getByCustomerId(@RequestParam int customerId){
        return this.cardValuesService.getValuesByCustomerId(customerId);
    }
}
