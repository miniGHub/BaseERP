package com.mini.dao;

import com.mini.model.CG002;

public interface ICG002Dao {
    CG002[] selectCG002(String purchase_note_id);
    void deleteCG002(String purchase_note_id);
    void insertCG002(CG002[] one);
    void updateCG002(CG002 one);
}
