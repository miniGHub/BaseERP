package com.mini.model.request;

import java.util.ArrayList;

public class ReqFormGrid<F, G> {
    private F form;
    private ArrayList<G> grid;

    public F getForm() {
        return form;
    }

    public void setForm(F form) {
        this.form = form;
    }

    public ArrayList<G> getGrid() {
        return grid;
    }

    public void setGrid(ArrayList<G> grid) {
        this.grid = grid;
    }
}
