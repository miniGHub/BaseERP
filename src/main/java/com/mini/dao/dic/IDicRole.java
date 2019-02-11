package com.mini.dao.dic;

import com.mini.model.dic.DIC_ROLE;

public interface IDicRole {
    public DIC_ROLE SelectAll();
    public String SelectName(int roleId);
}
