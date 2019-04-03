package com.mini.model.response;

import com.mini.model.page.ProductInfoPage;

import java.util.ArrayList;

public class RespProductInfoPage{
    private int total;
    ArrayList<ProductInfoPage> items;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public ArrayList<ProductInfoPage> getItems() {
        return items;
    }

    public void setItems(ArrayList<ProductInfoPage> items) {
        this.items = items;
    }
}
