package com.mini.model.request;

import com.mini.model.db.info.INFO_SUPPLIER;

import java.util.ArrayList;

public class ReqSupplier {
    private ArrayList<INFO_SUPPLIER> grid;

    public ArrayList<INFO_SUPPLIER> getGrid() {
        return grid;
    }

    public void setGrid(ArrayList<INFO_SUPPLIER> grid) {
        this.grid = grid;
    }
}
