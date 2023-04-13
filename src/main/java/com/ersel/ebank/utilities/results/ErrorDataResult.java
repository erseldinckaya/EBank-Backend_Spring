package com.ersel.ebank.utilities.results;

public class ErrorDataResult<T> extends DataResult {

    public ErrorDataResult(T data, String message){
        super(data, message,false);
    }

    public ErrorDataResult(String message){
        super(null, message,false);
    }

    public ErrorDataResult(T data) {
        super(data, false);
    }

    public ErrorDataResult(){
        super(null,false);
    }
}
