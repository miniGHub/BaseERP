package com.mini.dao;

import com.mini.model.User;

public interface IUserDao {
    User selectUser(long id);
}
