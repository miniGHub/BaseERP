package com.mini.dao.info;

import com.mini.model.info.INFO_USER;

public interface IInfoUser {
    INFO_USER SelectAll();
    INFO_USER SelectUserInfo(String id);
}
