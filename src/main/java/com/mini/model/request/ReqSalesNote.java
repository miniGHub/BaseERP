package com.mini.model.request;

import com.mini.model.db.xs.XS003;
import com.mini.model.db.xs.XS004;

import java.util.ArrayList;

public class ReqSalesNote {
    private XS003 form;
    private ArrayList<XS004> grid;

    public XS003 getForm() {
        return form;
    }

    public void setForm(XS003 form) {
        this.form = form;
    }

    public ArrayList<XS004> getGrid() {
        return grid;
    }

    public void setGrid(ArrayList<XS004> grid) {
        this.grid = grid;
    }
}
