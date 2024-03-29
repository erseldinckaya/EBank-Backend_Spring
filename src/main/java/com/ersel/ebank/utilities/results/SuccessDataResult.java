package com.ersel.ebank.utilities.results;

public class SuccessDataResult<T> extends DataResult<T>{
    public SuccessDataResult (T data, String message){
        super(data, message, true);
    }

    public SuccessDataResult (String message){
        super(null, message,true);
    }

    public SuccessDataResult (T data) {
        super(data, true);
    }

    public SuccessDataResult(){
        super(null,true);
    }
}
