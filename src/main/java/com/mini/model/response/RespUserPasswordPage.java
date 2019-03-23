package com.mini.model.response;

import com.mini.model.UserPasswordPage;

import java.util.ArrayList;

public class RespUserPasswordPage {
    private int total;
    ArrayList<UserPasswordPage> items;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public ArrayList<UserPasswordPage> getItems() {
        return items;
    }

    public void setItems(ArrayList<UserPasswordPage> items) {
        this.items = items;
    }
}
