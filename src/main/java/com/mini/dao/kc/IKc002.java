package com.mini.dao.kc;

import com.mini.model.kc.KC002;

import java.util.List;
import java.util.Map;

public interface IKc002 {
    KC002[] selectKC002(Map param);
    int updateKC002(KC002 one);
    int insertKC002(List<KC002> one);
    int deleteKC002(Map param);
}
