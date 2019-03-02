package com.mini.service.impl;

import com.mini.dao.info.IInfoUser;
import com.mini.model.UserCode;
import com.mini.model.info.INFO_USER;
import com.mini.service.IInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("InfoService")
public class InfoServiceImpl implements IInfoService {

    @Resource
    private IInfoUser mInfoUser;

    @Override
    public UserCode Login(String id, String password) {
        UserCode ret;

        System.out.println("id " + id + ",password" + password);
        INFO_USER infoUser = mInfoUser.SelectUserInfo(id);
        System.out.println("infoUser" + infoUser);
        if (null == infoUser) {
            ret = UserCode.NotExist;
        } else {
            if (infoUser.getPassword().equals(password)) {
                ret = UserCode.Exist;
            } else {
                ret = UserCode.PasswordErr;
            }
        }

        return  ret;
    }

    @Override
    public INFO_USER GetUserInfo(String id) {
        return mInfoUser.SelectUserInfo(id);
    }
}
