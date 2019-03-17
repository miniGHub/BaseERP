package com.mini.model.response;

import com.mini.model.UserInfoPage;

import java.util.ArrayList;

public class RespUserInfoPage {
    private int total;
    ArrayList<UserInfoPage> items;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public ArrayList<UserInfoPage> getItems() {
        return items;
    }

    public void setItems(ArrayList<UserInfoPage> items) {
        this.items = items;
    }
}
