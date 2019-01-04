package com.mini.service;

import com.mini.model.CG002;

import java.util.List;

public interface ICG002Service {

    CG002[] selectCG002(String purchase_note_id);
    void deleteCG002(String purchase_note_id);
    void insertCG002(List<CG002> cg002list);
    void updateCG002(CG002 one);
}
