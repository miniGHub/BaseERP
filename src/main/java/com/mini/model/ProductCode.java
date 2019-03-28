package com.mini.model;

public enum ProductCode {
    Exist(0),
    NotExist(1),
    AddSuccess(3),
    AddError(4),
    UpdateSuccess(5),
    UpdateError(6),
    DeleteSuccess(7),
    DeleteError(8);


    private int code;

    ProductCode(int code){
        this.code = code;
    }

    public int getCode(){
        return this.code;
    }
}
