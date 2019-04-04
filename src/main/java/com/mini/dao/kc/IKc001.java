package com.mini.dao.kc;

import com.mini.model.db.kc.KC001;
import com.mini.model.db.kc.KC002;

import java.util.Map;

public interface IKc001 {
    KC001[] selectKC001(Map param);
    int updateKC001(KC001 one);
    int insertKC001(KC001 one);
    int deleteKC001(Map param);
    int addKC001Amount(KC002 kc002);
}
