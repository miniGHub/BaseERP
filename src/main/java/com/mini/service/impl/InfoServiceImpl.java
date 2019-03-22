package com.mini.service.impl;

import com.mini.common.Constant;
import com.mini.dao.info.IInfoProduct;
import com.mini.dao.info.IInfoSupplier;
import com.mini.dao.info.IInfoUser;
import com.mini.model.ProductInfoPage;
import com.mini.model.UserCode;
import com.mini.model.UserInfoPage;
import com.mini.model.info.INFO_PRODUCT;
import com.mini.model.info.INFO_SUPPLIER;
import com.mini.model.info.INFO_USER;
import com.mini.service.IInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service("InfoService")
public class InfoServiceImpl implements IInfoService {

    @Resource
    private IInfoUser mInfoUser;
    @Resource
    private IInfoSupplier mInfoSupplier;
    @Resource
    private IInfoProduct mInfoProduct;

    private ArrayList<UserInfoPage> mArrayUserInfo = new ArrayList<>();
    private ArrayList<ProductInfoPage> mArrayProductInfo = new ArrayList<>();

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

    @Override
    public boolean SaveSupplier(ArrayList<INFO_SUPPLIER> supplier) {
        mInfoSupplier.DeleteSupplier();
        mInfoSupplier.InsertSupplier(supplier);
        return true;
    }

    @Override
    public INFO_SUPPLIER GetSupplier(int supplier_id) {
        return mInfoSupplier.SelectSupplier(supplier_id);
    }

    @Override
    public ArrayList<INFO_SUPPLIER> GetAllSupplier() {
        System.out.println("service GetAllSupplier come in");
        return mInfoSupplier.SelectAllSupplier();
    }

    @Override
    public INFO_PRODUCT GetProductInfo(String product_id) {
        return mInfoProduct.SelectProductInfo(product_id);
    }

    @Override
    public ArrayList<ProductInfoPage> GetAllProductInfo() {
        // clear array list
        mArrayProductInfo.clear();
        mArrayProductInfo = mInfoProduct.SelectAllProductInfo();
        return mArrayProductInfo;
    }

    @Override
    public ArrayList<ProductInfoPage> GetAllProductInfoPage(int page, int start, int limit) {
        ArrayList<ProductInfoPage> arrayProductInfo = new ArrayList<>();

        if (mArrayProductInfo.size() == 0) {
            mArrayProductInfo = mInfoProduct.SelectAllProductInfo();
        }

        for(int index = start, cnt = 0; index < mArrayProductInfo.size() && cnt < limit; index++, cnt++) {
            arrayProductInfo.add(mArrayProductInfo.get(index));
        }

        return arrayProductInfo;
    }

    @Override
    public int GetAllProductInfoSize() {
        return mArrayProductInfo.size();
    }

    @Override
    public UserCode AddProductInfo(INFO_PRODUCT productInfo) {
        UserCode ret = UserCode.AddSuccess;
        int cnt = 0;

        cnt = mInfoProduct.CountProductInfo(productInfo.getProduct_id());
        if (1 == cnt) {
            ret = UserCode.Exist;
        } else if (cnt > 1 ) {
            ret = UserCode.AddError;
        } else {
            mInfoProduct.InsertProductInfo(productInfo);
        }

        return ret;
    }

    @Override
    public UserCode UpdateProductInfo(INFO_PRODUCT productInfo) {
        UserCode ret = UserCode.UpdateSuccess;
        int cnt = 0;

        cnt = mInfoProduct.CountProductInfo(productInfo.getProduct_id());
        if (0 == cnt) {
            ret = UserCode.NotExist;
        } else if (cnt > 1){
            ret = UserCode.UpdateError;
        } else {
            mInfoProduct.UpdateProductInfo(productInfo);
        }

        return ret;
    }

    @Override
    public UserCode DeleteProductInfo(ArrayList<String> listId) {
        UserCode ret = UserCode.DeleteSuccess;

        mInfoProduct.DeleteProductInfo(listId);

        return ret;
    }



}
