package com.mini.service;

import com.mini.model.CG002;

public interface ICG002Service {

    CG002[] selectCG002(String purchase_note_id);
    void deleteCG002(String purchase_note_id);
    void insertCG002(CG002[] one);
    void updateCG002(CG002 one);
}
