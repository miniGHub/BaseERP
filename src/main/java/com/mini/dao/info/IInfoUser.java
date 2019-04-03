package com.mini.dao.info;

import com.mini.model.page.UserInfoPage;
import com.mini.model.page.UserPasswordPage;
import com.mini.model.db.info.INFO_USER;

import java.util.ArrayList;

public interface IInfoUser {
    INFO_USER SelectUserInfo(String id);
    ArrayList<UserInfoPage> SelectAllUserInfo();
    ArrayList<UserPasswordPage> SelectAllUserPassword();
    void InsertUserInfo(INFO_USER userInfo);
    void UpdateUserInfo(INFO_USER userInfo);
    void DeleteUserInfo(ArrayList<String> listId);
    int CountUserInfo(String id);
    String SelectMaxId();
    int UpdatePassword(String id, String password);
}
