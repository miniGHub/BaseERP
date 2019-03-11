package com.mini.model.request;

import java.util.ArrayList;
import com.mini.model.cg.CG001;
import com.mini.model.cg.CG002;

public class ReqPurchaseNote {
    private CG001 form;
    private ArrayList<CG002> grid;

    public CG001 getForm() {
        return form;
    }

    public void setForm(CG001 form) {
        this.form = form;
    }

    public ArrayList<CG002> getGrid() {
        return grid;
    }

    public void setGrid(ArrayList<CG002> grid) {
        this.grid = grid;
    }
}
