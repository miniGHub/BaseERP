package com.mini.service.impl;

import com.mini.common.Constant;
import com.mini.dao.info.IInfoUser;
import com.mini.model.UserCode;
import com.mini.model.info.INFO_USER;
import com.mini.model.UserInfoPage;
import com.mini.service.IInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service("InfoService")
public class InfoServiceImpl implements IInfoService {

    @Resource
    private IInfoUser mInfoUser;

    private ArrayList<UserInfoPage> mArrayUserInfo = new ArrayList<>();

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
                ret = UserCode.PasswordError;
            }
        }

        return  ret;
    }

    @Override
    public INFO_USER GetUserInfo(String id) {
        return mInfoUser.SelectUserInfo(id);
    }

    @Override
    public ArrayList<UserInfoPage> GetAllUserInfo() {
        // clear array list
        mArrayUserInfo.clear();
        mArrayUserInfo = mInfoUser.SelectAllUserInfo();
        return mArrayUserInfo;
    }

    @Override
    public ArrayList<UserInfoPage> GetAllUserInfoPage(int page, int start, int limit) {
        ArrayList<UserInfoPage> arrayUserInfo = new ArrayList<>();

        if (mArrayUserInfo.size() == 0) {
            mArrayUserInfo = mInfoUser.SelectAllUserInfo();
        }

        for(int index = start, cnt = 0; index < mArrayUserInfo.size() && cnt < limit; index++, cnt++) {
            arrayUserInfo.add(mArrayUserInfo.get(index));
        }

        return arrayUserInfo;
    }

    @Override
    public int GetAllUserInfoSize() {
        return mArrayUserInfo.size();
    }

    @Override
    public UserCode AddUserInfo(INFO_USER userInfo) {
        UserCode ret = UserCode.AddSuccess;
        int cnt = 0;

        userInfo.setPassword(Constant.DEFAULT_PASSWORD);
        cnt = mInfoUser.CountUserInfo(userInfo.getId());
        if (1 == cnt) {
            ret = UserCode.Exist;
        } else if (cnt > 1 ) {
            ret = UserCode.AddError;
        } else {
            mInfoUser.InsertUserInfo(userInfo);
        }

        return ret;
    }

    @Override
    public UserCode UpdateUserInfo(INFO_USER userInfo) {
        UserCode ret = UserCode.UpdateSuccess;
        int cnt = 0;

        cnt = mInfoUser.CountUserInfo(userInfo.getId());
        if (0 == cnt) {
            ret = UserCode.NotExist;
        } else if (cnt > 1){
            ret = UserCode.UpdateError;
        } else {
            mInfoUser.UpdateUserInfo(userInfo);
        }

        return ret;
    }

    @Override
    public UserCode DeleteUserInfo(ArrayList<String> listId) {
        UserCode ret = UserCode.DeleteSuccess;

        mInfoUser.DeleteUserInfo(listId);

        return ret;
    }
}
