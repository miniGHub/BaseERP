package com.mini.model.code;

public enum SupplierCode {
    SaveSuccess(0);

    private int code;

    SupplierCode(int code){
        this.code = code;
    }

    public int getCode(){
        return this.code;
    }
}
