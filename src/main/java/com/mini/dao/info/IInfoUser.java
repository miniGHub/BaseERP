package com.mini.dao.info;

import com.mini.model.UserInfoPage;
import com.mini.model.UserPasswordPage;
import com.mini.model.info.INFO_USER;

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
