package com.mini.dao.kc;

import com.mini.model.kc.KC002;

import java.util.List;
import java.util.Map;

public interface IKc002 {
    KC002[] selectKC002(Map param);
    void updateKC002(KC002 one);
    void insertKC002(List<KC002> one);
    void deleteKC002(Map param);
}
