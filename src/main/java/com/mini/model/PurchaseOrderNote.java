package com.mini.model;

import java.util.List;
import com.mini.model.cg.CG001;
import com.mini.model.cg.CG002;

public class PurchaseOrderNote {
    private CG001 form;
    private List<CG002> grid;

    public CG001 getForm() {
        return form;
    }

    public void setForm(CG001 form) {
        this.form = form;
    }

    public List<CG002> getGrid() {
        return grid;
    }

    public void setGrid(List<CG002> grid) {
        this.grid = grid;
    }
}
