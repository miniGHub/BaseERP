package com.mini.dao;

import com.mini.model.KC002;

public interface IKC002Dao {
    KC002 selectKC002(String product_id);
    void updateKC002(KC002 one);
    void insertKC002(KC002[] one);
    void deleteKC002(String product_id);
}
