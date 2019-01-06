package com.mini.service;

import com.mini.model.KC002;

import java.util.List;
import java.util.Map;

public interface IKC002Service {

    KC002[] selectKC002(Map param);
    void updateKC002(KC002 one);
    void insertKC002(List<KC002> kc002list);
    void deleteKC002(Map param);
}
