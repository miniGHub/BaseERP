package com.mini.service;

import com.mini.model.KC001;

import java.util.Map;

public interface IKC001Service {

    KC001[] selectKC001(Map param);
    void updateKC001(KC001 one);
    void insertKC001(KC001 one);
    void deleteKC001(String product_id);
}
