package com.mini.dao.cg;

import com.mini.model.cg.CG001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface ICg001 {
    CG001[]  selectCG001(Map param);
    int deleteCG001(String purchase_note_id);
    int insertCG001(CG001 one);
    int updateCG001(CG001 one);
    int countPurchaseNoteIdLike(String purchase_note_id_like);
    ArrayList<String> SelectPurchaseNoteInApproval();
    int updatePurchaseNoteStatus(HashMap<String, Object> param);
}
