package com.mini.dao.dic;

import com.mini.model.db.dic.DIC_ROLE;

import java.util.ArrayList;

public interface IDicRole {
    ArrayList<DIC_ROLE> SelectAllRole();
    DIC_ROLE SelectRole(int roleId);
    void InsertRole(ArrayList<DIC_ROLE> role);
    void DeleteRole();
}
