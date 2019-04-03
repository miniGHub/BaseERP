package com.mini.dao.dic;

import com.mini.model.db.dic.DIC_REPOSITORY;

import java.util.ArrayList;

public interface IDicRepository {
    ArrayList<DIC_REPOSITORY> SelectAllRepository();
    DIC_REPOSITORY SelectRepository(int repositoryType);
    void InsertRepository(ArrayList<DIC_REPOSITORY> repository);
    void DeleteRepository();
}
