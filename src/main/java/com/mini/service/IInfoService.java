package com.mini.service;

import com.mini.model.*;
import com.mini.model.info.*;

import java.util.ArrayList;

public interface IInfoService {
    UserCode Login(String id, String password);
    INFO_USER GetUserInfo(String id);
    ArrayList<UserInfoPage> GetAllUserInfo();
    ArrayList<UserInfoPage> GetAllUserInfoPage(int page, int start, int limit);
    int GetAllUserInfoSize();
    String GetNewId();
    UserCode AddUserInfo(INFO_USER userInfo);
    UserCode UpdateUserInfo(INFO_USER userInfo);
    UserCode DeleteUserInfo(ArrayList<String> listId);
    UserCode UpdatePassword(String id, String oldPassword, String newPassword);
    ArrayList<UserPasswordPage> GetAllUserPassword();
    ArrayList<UserPasswordPage> GetAllUserPasswordPage(int page, int start, int limit);
    int GetAllUserPasswordSize();
	
    UserCode ResetPassword(ArrayList<String> listId);
    boolean SaveSupplier(ArrayList<INFO_SUPPLIER> supplier);
    INFO_SUPPLIER GetSupplier(int supplier_id);
    ArrayList<INFO_SUPPLIER> GetAllSupplier();

    INFO_PRODUCT GetProductInfo(String product_id);
    ArrayList<ProductInfoPage> GetAllProductInfo();
    ArrayList<ProductInfoPage> GetAllProductInfoPage(int page, int start, int limit);
    int GetAllProductInfoSize();
    UserCode AddProductInfo(INFO_PRODUCT productInfo);
    UserCode UpdateProductInfo(INFO_PRODUCT productInfo);
    UserCode DeleteProductInfo(ArrayList<String> listId);
	ArrayList<RepositoryInfoPage> GetAllRepository();
    ArrayList<RepositoryInfoPage> GetAllRepositoryPage(int page, int start, int limit);
    int GetAllRepositorySize();
    UserCode AddRepositoryInfo(INFO_REPOSITORY repositoryInfo);
    UserCode UpdateRepositoryInfo(INFO_REPOSITORY repositoryInfo);
    UserCode DeleteRepositoryInfo(ArrayList<String> idList);
    RepositoryInfoPage GetRepositoryInfo(String repository_id);
    ArrayList<INFO_CLIENT> GetAllClientInfo();
    UserCode AddClientInfo(INFO_CLIENT clientInfo);
    UserCode SaveClientInfo(ArrayList<INFO_CLIENT> clientInfoList);
    UserCode UpdateClientInfo(INFO_CLIENT clientInfo);
    UserCode DeleteClientInfo(ArrayList<String> idList);
}
