package com.mini.service;

import com.mini.model.cg.CG001;
import com.mini.model.cg.CG002;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface ICgService {

    boolean savePurchaseNote(CG001 one, List<CG002> cg002List);
    boolean updatePurchaseNote(CG001 one, List<CG002> cg002List);
    int countTodayItems(String id_prefix);
    CG001 getPurchaseNote(String purchase_note_id);
    ArrayList<CG002> getPurchaseNoteDetail(String purchase_note_id);
    ArrayList<String> GetPurchaseNoteInApproval();
    boolean updatePurchaseNoteStatus(String purchase_note_id, int note_status);
}
