package com.mini.service.impl;

import com.mini.dao.kc.IKc001;
import com.mini.dao.kc.IKc002;
import com.mini.model.kc.KC001;
import com.mini.model.kc.KC002;
import com.mini.service.IKcService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("KcService")
public class KcServiceImpl implements IKcService {

    @Resource
    private IKc001 KC001Dao;

    @Resource
    private IKc002 KC002Dao;

    @Override
    public KC001[] selectKC001(Map param) {
        return this.KC001Dao.selectKC001(param);
    }

    @Override
    public void updateKC001(KC001 one) {
        this.KC001Dao.updateKC001(one);
    }

    @Override
    public void insertKC001(KC001 one) {
        this.KC001Dao.insertKC001(one);
    }

    @Override
    public void deleteKC001(Map param) {
        this.KC001Dao.deleteKC001(param);
        this.KC002Dao.deleteKC002(param);
    }

    @Override
    public KC002[] selectKC002(Map param) {
        return this.KC002Dao.selectKC002(param);
    }

    @Override
    public void updateKC002(KC002 one) {
        this.KC002Dao.updateKC002(one);
    }

    @Override
    public boolean saveStorageIn(ArrayList<KC002> kc002list) {
        for (int i=0; i<kc002list.size(); i++) {
            this.KC001Dao.addKC001Amount(kc002list.get(i));
        }
        if (this.KC002Dao.insertKC002(kc002list) == kc002list.size()) {
            return true;
        }
        return false;
    }

    @Override
    public void deleteKC002(Map param) {
        this.KC002Dao.deleteKC002(param);
    }
}
