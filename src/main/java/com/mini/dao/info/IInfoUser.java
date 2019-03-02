package com.mini.dao.info;

import com.mini.model.info.INFO_USER;

public interface IInfoUser {
    public INFO_USER SelectAll();
    public INFO_USER SelectUserInfo(String id);
}
