package com.mini.service.impl;

import com.mini.dao.cg.ICG001Dao;
import com.mini.dao.cg.ICG002Dao;
import com.mini.model.cg.CG001;
import com.mini.service.ICG001Service;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service("CG001Service")
public class CG001ServiceImpl implements ICG001Service {

    @Resource
    private ICG001Dao CG001Dao;

    @Resource
    private ICG002Dao CG002Dao;

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
}
