package com.mini.dao.dic;

import com.mini.model.dic.DIC_REPOSITORY;

public interface IDicRepository {
    public DIC_REPOSITORY SelectAll();
    public String SelectName(int repositoryId);
}
