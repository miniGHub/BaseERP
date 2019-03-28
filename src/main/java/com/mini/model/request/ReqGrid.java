package com.mini.model.request;

import java.util.ArrayList;

public class ReqGrid<T> {
    ArrayList<T> grid;

    public ArrayList<T> getGrid() {
        return grid;
    }

    public void setGrid(ArrayList<T> grid) {
        this.grid = grid;
    }
}
