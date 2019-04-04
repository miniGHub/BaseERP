package com.mini.service.impl;

import com.mini.dao.cg.ICg001;
import com.mini.dao.cg.ICg002;
import com.mini.model.db.cg.CG001;
import com.mini.model.db.cg.CG002;
import com.mini.service.ICgService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service("CgService")
public class CgServiceImpl implements ICgService {

    @Resource
    private ICg001 CG001Dao;

    @Resource
    private ICg002 CG002Dao;

    @Override
    public boolean savePurchaseNote(CG001 one, List<CG002> cg002List) {
        if (this.CG001Dao.insertCG001(one) == 1) {
            if (this.CG002Dao.insertCG002(cg002List) == cg002List.size()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updatePurchaseNote(CG001 one, List<CG002> cg002List) {
        if (this.CG001Dao.updateCG001(one) == 1) {
            this.CG002Dao.deleteCG002(one.getPurchase_note_id());
            if (this.CG002Dao.insertCG002(cg002List) == cg002List.size()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int countTodayItems(String id_prefix) {
        return this.CG001Dao.countPurchaseNoteIdLike(id_prefix);
    }

    @Override
    public CG001 getPurchaseNote(String purchase_note_id) {
        Map<String, Object> param = new HashMap<>();
        param.put("purchase_note_id", purchase_note_id);
        CG001[] cg001s = this.CG001Dao.selectCG001(param);
        if (cg001s.length >= 1) {
            return cg001s[0];
        }
        return null;
    }

    @Override
    public ArrayList<CG002> getPurchaseNoteDetail(String purchase_note_id) {
        return this.CG002Dao.selectCG002(purchase_note_id);
    }

    @Override
    public ArrayList<String> GetPurchaseNoteInApproval() {
        return this.CG001Dao.SelectPurchaseNoteInApproval();
    }

    @Override
    public boolean updatePurchaseNoteStatus(String purchase_note_id, int note_status) {
        return (this.CG001Dao.updatePurchaseNoteStatus(purchase_note_id, note_status) == 1);
    }
}
