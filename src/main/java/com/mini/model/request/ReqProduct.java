package com.mini.model.request;

import com.mini.model.dic.DIC_PRODUCT;

import java.util.ArrayList;

public class ReqProduct {
    private ArrayList<DIC_PRODUCT> grid;

    public ArrayList<DIC_PRODUCT> getGrid() {
        return grid;
    }

    public void setGrid(ArrayList<DIC_PRODUCT> grid) {
        this.grid = grid;
    }
}
