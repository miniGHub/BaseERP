package com.mini.service.impl;

import com.mini.dao.kc.IKC002Dao;
import com.mini.model.kc.KC002;
import com.mini.service.IKC002Service;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("KC002Service")
public class KC002ServiceImpl implements IKC002Service {

    @Resource
    private IKC002Dao KC002Dao;

    @Override
    public KC002[] selectKC002(Map param) {
        return this.KC002Dao.selectKC002(param);
    }

    @Override
    public void updateKC002(KC002 one) {
        this.KC002Dao.updateKC002(one);
    }

    @Override
    public void insertKC002(List<KC002> kc002list) {
        this.KC002Dao.insertKC002(kc002list);
    }

    @Override
    public void deleteKC002(Map param) {
        this.KC002Dao.deleteKC002(param);
    }
}
