package com.mini.model;

public enum UserCode {
    Exist(0),NotExist(1),PasswordErr(2);

    private int code;

    private UserCode(int code){
        this.code = code;
    }

    public int getCode(){
        return this.code;
    }
}
