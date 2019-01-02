package com.mini.service.impl;

import com.mini.dao.IKC002Dao;
import com.mini.model.KC002;
import com.mini.service.IKC002Service;

import javax.annotation.Resource;

public class KC002ServiceImpl implements IKC002Service {

    @Resource
    private IKC002Dao KC002Dao;

    @Override
    public KC002 selectKC002(String product_id) {
        return this.KC002Dao.selectKC002(product_id);
    }

    @Override
    public void updateKC002(KC002 one) {
        this.KC002Dao.updateKC002(one);
    }

    @Override
    public void insertKC002(KC002[] one) {
        this.KC002Dao.insertKC002(one);
    }

    @Override
    public void deleteKC002(String product_id) {
        this.KC002Dao.deleteKC002(product_id);
    }
}
