package com.mini.service;

import com.mini.model.cg.CG001;
import com.mini.model.cg.CG002;

import java.util.List;
import java.util.Map;

public interface ICgService {

    CG001[] selectCG001(Map param);
    int deleteCG001(String purchase_note_id);
    int insertCG001(CG001 one);
    int updateCG001(CG001 one);
    int countTodayItems(String id_prefix);

    CG002[] selectCG002(String purchase_note_id);
    int deleteCG002(String purchase_note_id);
    int insertCG002(List<CG002> cg002list);
    int updateCG002(CG002 one);
}
