package com.mini.service.impl;

import com.mini.common.Constant;
import com.mini.dao.info.IInfoUser;
import com.mini.model.UserCode;
import com.mini.model.UserPasswordPage;
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
    private ArrayList<UserPasswordPage> mArrayUserPassword = new ArrayList<>();

    @Override
    public UserCode Login(String id, String password) {
        System.out.println("id " + id + ",password" + password);

        UserCode userCode;
        INFO_USER infoUser = mInfoUser.SelectUserInfo(id);

        if (null == infoUser) {
            userCode = UserCode.NotExist;
        } else {
            if (infoUser.getPassword().equals(password)) {
                userCode = UserCode.Exist;
            } else {
                userCode = UserCode.PasswordError;
            }
        }

        return  userCode;
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
    public String GetNewId() {
        String newId = mInfoUser.SelectMaxId();

        if (null == newId) {
            newId = Constant.DEFAULT_ID;
        } else {
            newId = String.format("%04d", Integer.parseInt(newId) + 1);
        }

        return newId;
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

    @Override
    public UserCode UpdatePassword(String id, String oldPassword, String newPassword) {
        UserCode userCode = UserCode.ChangePasswordSuccess;

        int cnt = mInfoUser.CountUserInfo(id);
        if (0 == cnt) {
            userCode = UserCode.NotExist;
            return userCode;
        }

        INFO_USER userInfo = mInfoUser.SelectUserInfo(id);
        if (!userInfo.getPassword().equals(oldPassword)) {
            userCode = UserCode.PasswordError;
            return userCode;
        }

        if (userInfo.getPassword().equals(newPassword)) {
            userCode = UserCode.PasswordExist;
            return userCode;
        }

        int line = mInfoUser.UpdatePassword(id, newPassword);
        if (1 == line) {
            userCode = UserCode.ChangePasswordSuccess;
        } else {
            System.out.println("UpdatePassword error! line:" + line);
            userCode = UserCode.ChangePasswordError;
        }

        return userCode;
    }

    @Override
    public ArrayList<UserPasswordPage> GetAllUserPassword() {
        // clear array list
        mArrayUserPassword.clear();
        mArrayUserPassword = mInfoUser.SelectAllUserPassword();
        for (int i = 0; i < mArrayUserPassword.size(); i++) {
            if (mArrayUserPassword.get(i).getPassword().equals(Constant.DEFAULT_PASSWORD)) {
                mArrayUserPassword.get(i).setPassword_state(Constant.RESET_PASSWORD_DONE);
            } else {
                mArrayUserPassword.get(i).setPassword_state(Constant.RESET_PASSWORD_NONE);
            }
        }
        return mArrayUserPassword;
    }

    @Override
    public ArrayList<UserPasswordPage> GetAllUserPasswordPage(int page, int start, int limit) {
        ArrayList<UserPasswordPage> arrayUserPassword = new ArrayList<>();

        if (mArrayUserPassword.size() == 0) {
            mArrayUserPassword = mInfoUser.SelectAllUserPassword();
            for (int i = 0; i < mArrayUserPassword.size(); i++) {
                if (mArrayUserPassword.get(i).getPassword().equals(Constant.DEFAULT_PASSWORD)) {
                    mArrayUserPassword.get(i).setPassword_state(Constant.RESET_PASSWORD_DONE);
                } else {
                    mArrayUserPassword.get(i).setPassword_state(Constant.RESET_PASSWORD_NONE);
                }
            }
        }

        for(int index = start, cnt = 0; index < mArrayUserPassword.size() && cnt < limit; index++, cnt++) {
            arrayUserPassword.add(mArrayUserPassword.get(index));
        }

        return arrayUserPassword;
    }

    @Override
    public int GetAllUserPasswordSize() {
        return mArrayUserPassword.size();
    }

    @Override
    public UserCode ResetPassword(ArrayList<String> listId) {
        UserCode userCode = UserCode.ResetPasswordError;

        for (int i = 0; i < listId.size(); i++) {
            String id = listId.get(i);

            int cnt = mInfoUser.CountUserInfo(id);
            if (0 == cnt) {
                System.out.println("id[" + id + "] No Exists!");
                continue;
            }

            int line = mInfoUser.UpdatePassword(id, Constant.DEFAULT_PASSWORD);
            if (1 == line) {
                userCode = UserCode.ResetPasswordSuccess;
            } else {
                System.out.println("id[" + id + "] UpdatePassword error! line:" + line);
            }
        }

        return userCode;
    }
}
