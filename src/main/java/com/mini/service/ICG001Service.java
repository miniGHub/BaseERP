package com.mini.service;

import com.mini.model.CG001;

import java.util.Map;

public interface ICG001Service {

    CG001[] selectCG001(Map param);
    void deleteCG001(String purchase_note_id);
    void insertCG001(CG001 one);
    void updateCG001(CG001 one);
}
