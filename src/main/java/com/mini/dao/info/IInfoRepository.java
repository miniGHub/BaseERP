package com.mini.dao.info;

import com.mini.model.info.INFO_REPOSITORY;

public interface IInfoRepository {
    public INFO_REPOSITORY SelectAll();
    public INFO_REPOSITORY SelectRepositoryInfo(String repositoryId);
}
