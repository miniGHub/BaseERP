package com.mini.service;

import com.mini.model.cg.CG001;

import java.util.Map;

public interface ICG001Service {

    CG001[] selectCG001(Map param);
    int deleteCG001(String purchase_note_id);
    int insertCG001(CG001 one);
    int updateCG001(CG001 one);
    int countTodayItems(String id_prefix);
}
