package com.mini.model.response;

import java.util.ArrayList;

public class RespInfoPage<T> {
    private int total;
    private ArrayList<T> items;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public ArrayList<T> getItems() {
        return items;
    }

    public void setItems(ArrayList<T> items) {
        this.items = items;
    }
}
