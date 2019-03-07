package com.mini.dao.dic;

import com.mini.model.dic.DIC_DEPART;

import java.util.ArrayList;

public interface IDicDepart {
    ArrayList<DIC_DEPART> SelectAllDepart();
    DIC_DEPART SelectDepart(int departId);
    void InsertDepart(ArrayList<DIC_DEPART> depart);
    void DeleteDepart();
}
