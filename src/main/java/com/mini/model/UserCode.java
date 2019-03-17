package com.mini.model;

public enum UserCode {
    Exist(0),
    NotExist(1),
    PasswordError(2),
    AddSuccess(3),
    AddError(4),
    UpdateSuccess(5),
    UpdateError(6),
    DeleteSuccess(7),
    DeleteError(8);

    private int code;

    UserCode(int code){
        this.code = code;
    }

    public int getCode(){
        return this.code;
    }
}
