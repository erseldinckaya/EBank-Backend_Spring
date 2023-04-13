package com.ersel.ebank.utilities.results;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Result {
    private boolean status;
    private String message;

    public Result(boolean status){
        this.status = status;
    }

    public Result(boolean status, String message){
        this.status = status;
        this.message = message;
    }
}
