package com.mini.dao.info;

import com.mini.model.page.RepositoryInfoPage;
import com.mini.model.db.info.INFO_REPOSITORY;

import java.util.ArrayList;

public interface IInfoRepository {
    ArrayList<INFO_REPOSITORY> SelectAll();
    ArrayList<RepositoryInfoPage> SelectAllRepositoryInfo();
    int AddRepositoryInfo(INFO_REPOSITORY repositoryInfo);
    int UpdateRepositoryInfo(INFO_REPOSITORY repositoryInfo);
    int DeleteRepositoryInfo(ArrayList<String> idList);
    INFO_REPOSITORY SelectRepositoryInfo(String repository_id);
}
