package com.mini.dao.info;

import com.mini.model.info.INFO_USER;
import com.mini.model.UserInfoPage;

import java.util.ArrayList;

public interface IInfoUser {
    INFO_USER SelectAll();
    INFO_USER SelectUserInfo(String id);
    ArrayList<UserInfoPage> SelectAllUserInfo();
    void InsertUserInfo(INFO_USER userInfo);
    void UpdateUserInfo(INFO_USER userInfo);
    void DeleteUserInfo(ArrayList<String> listId);
    int CountUserInfo(String id);
}
