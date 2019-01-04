package com.mini.service.impl;

import com.mini.dao.IKC001Dao;
import com.mini.dao.IKC002Dao;
import com.mini.model.KC001;
import com.mini.service.IKC001Service;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service("KC001Service")
public class KC001ServiceImpl implements IKC001Service {

    @Resource
    private IKC001Dao  KC001Dao;

    @Resource
    private IKC002Dao  KC002Dao;

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
    public void deleteKC001(String product_id) {
        this.KC001Dao.deleteKC001(product_id);
        this.KC002Dao.deleteKC002(product_id);
    }
}
