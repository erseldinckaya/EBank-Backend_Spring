package com.ersel.ebank.utilities.results;



public class DataResult<T> extends Result{
    private T data;

    public DataResult(T data, String message, Boolean status){
        super(status,message);
        this.data = data;
    }

    public DataResult(T data, Boolean status){
        super(status);
        this.data = data;
    }


    public T getData() {
        return data;
    }
}
