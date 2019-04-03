package com.mini.model.request;

import com.mini.model.db.info.INFO_PRODUCT;

import java.util.ArrayList;

public class ReqProductInfo {
    private ArrayList<INFO_PRODUCT> grid;

    public ArrayList<INFO_PRODUCT> getGrid() {
        return grid;
    }

    public void setGrid(ArrayList<INFO_PRODUCT> grid) {
        this.grid = grid;
    }
}
