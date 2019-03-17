package com.mini.service;

import com.mini.model.UserCode;
import com.mini.model.info.INFO_USER;
import com.mini.model.UserInfoPage;

import java.util.ArrayList;

public interface IInfoService {
    UserCode Login(String id, String password);
    INFO_USER GetUserInfo(String id);
    ArrayList<UserInfoPage> GetAllUserInfo();
    ArrayList<UserInfoPage> GetAllUserInfoPage(int page, int start, int limit);
    int GetAllUserInfoSize();
    UserCode AddUserInfo(INFO_USER userInfo);
    UserCode UpdateUserInfo(INFO_USER userInfo);
    UserCode DeleteUserInfo(ArrayList<String> listId);
}
