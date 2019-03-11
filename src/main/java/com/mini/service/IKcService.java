package com.mini.service;

import com.mini.model.kc.KC001;
import com.mini.model.kc.KC002;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface IKcService {

    KC001[] selectKC001(Map param);
    void updateKC001(KC001 one);
    void insertKC001(KC001 one);
    void deleteKC001(Map param);

    KC002[] selectKC002(Map param);
    void updateKC002(KC002 one);
    boolean saveStorageIn(ArrayList<KC002> kc002list);
    void deleteKC002(Map param);
}
