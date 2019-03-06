package com.mini.model.request;

import com.mini.model.xs.XS001;
import com.mini.model.xs.XS002;

import java.util.ArrayList;

public class ReqSalesOrderNote {
    private XS001 form;
    private ArrayList<XS002> grid;

    public XS001 getForm() {
        return form;
    }

    public void setForm(XS001 form) {
        this.form = form;
    }

    public ArrayList<XS002> getGrid() {
        return grid;
    }

    public void setGrid(ArrayList<XS002> grid) {
        this.grid = grid;
    }
}
