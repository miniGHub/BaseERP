package com.mini.service.impl;

import com.mini.dao.ICG002Dao;
import com.mini.model.CG002;
import com.mini.service.ICG002Service;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("CG002Service")
public class CG002ServiceImpl implements ICG002Service {

    @Resource
    private ICG002Dao CG002Dao;

    @Override
    public CG002[] selectCG002(String purchase_note_id) {
        return this.CG002Dao.selectCG002(purchase_note_id);
    }

    @Override
    public void deleteCG002(String purchase_note_id) {
        this.CG002Dao.deleteCG002(purchase_note_id);
    }

    @Override
    public void insertCG002(List<CG002> cg002list) {
        this.CG002Dao.insertCG002(cg002list);
    }

    @Override
    public void updateCG002(CG002 one) {
        this.CG002Dao.updateCG002(one);
    }
}
