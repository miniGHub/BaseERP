package com.mini.service.impl;

import com.mini.dao.cg.ICg001;
import com.mini.dao.cg.ICg002;
import com.mini.model.cg.CG001;
import com.mini.model.cg.CG002;
import com.mini.service.ICgService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("CgService")
public class CgServiceImpl implements ICgService {

    @Resource
    private ICg001 CG001Dao;

    @Resource
    private ICg002 CG002Dao;

    @Override
    public CG001[] selectCG001(Map param) {
        return this.CG001Dao.selectCG001(param);
    }

    @Override
    public int deleteCG001(String purchase_note_id) {
        int ret = this.CG001Dao.deleteCG001(purchase_note_id);
        this.CG002Dao.deleteCG002(purchase_note_id);
        return ret;
    }

    @Override
    public int insertCG001(CG001 one) {
        return this.CG001Dao.insertCG001(one);
    }

    @Override
    public int updateCG001(CG001 one) {
        return this.CG001Dao.updateCG001(one);
    }

    @Override
    public int countTodayItems(String id_prefix) {
        return this.CG001Dao.countPurchaseNoteIdLike(id_prefix);
    }

    @Override
    public CG002[] selectCG002(String purchase_note_id) {
        return this.CG002Dao.selectCG002(purchase_note_id);
    }

    @Override
    public int deleteCG002(String purchase_note_id) {
        return this.CG002Dao.deleteCG002(purchase_note_id);
    }

    @Override
    public int insertCG002(List<CG002> cg002list) {
        return this.CG002Dao.insertCG002(cg002list);
    }

    @Override
    public int updateCG002(CG002 one) {
        return this.CG002Dao.updateCG002(one);
    }
}
