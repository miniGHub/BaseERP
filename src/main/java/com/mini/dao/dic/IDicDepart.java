package com.mini.dao.dic;

import com.mini.model.dic.DIC_DEPART;

public interface IDicDepart {
    public DIC_DEPART SelectAll();
    public String SelectName(int departId);
}
