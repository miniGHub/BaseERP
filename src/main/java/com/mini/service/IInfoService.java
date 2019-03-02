package com.mini.service;

import com.mini.model.UserCode;
import com.mini.model.info.INFO_USER;

public interface IInfoService {
    UserCode Login(String id, String password);
    INFO_USER GetUserInfo(String id);
}
