package com.mini.model.code;

public enum OperationResultCode {
    Success(0),
    AddFailed(1),
    UpdateFailed(2),
    DeleteFailed(3),
    SaveFailed(4);

    private int code;

    OperationResultCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
