package com.mini.service;

import com.mini.model.code.OperationResultCode;
import com.mini.model.code.ProductCode;
import com.mini.model.code.UserCode;
import com.mini.model.db.info.*;
import com.mini.model.page.ProductInfoPage;
import com.mini.model.page.RepositoryInfoPage;
import com.mini.model.page.UserInfoPage;
import com.mini.model.page.UserPasswordPage;

import java.util.ArrayList;

public interface IInfoService {
    UserCode Login(String id, String password);
    INFO_USER GetUserInfo(String id);
    ArrayList<UserInfoPage> GetAllUserInfo();
    ArrayList<UserInfoPage> GetAllUserInfoPage(int page, int start, int limit);
    int GetAllUserInfoSize();
    String GetUserInfoNewId();
    UserCode AddUserInfo(INFO_USER userInfo);
    UserCode UpdateUserInfo(INFO_USER userInfo);
    UserCode DeleteUserInfo(ArrayList<String> listId);
    UserCode UpdatePassword(String id, String oldPassword, String newPassword);
    ArrayList<UserPasswordPage> GetAllUserPassword();
    ArrayList<UserPasswordPage> GetAllUserPasswordPage(int page, int start, int limit);
    int GetAllUserPasswordSize();
	
    UserCode ResetPassword(ArrayList<String> listId);
    boolean SaveSupplier(ArrayList<INFO_SUPPLIER> supplier);
    INFO_SUPPLIER GetSupplier(String supplier_id);
    ArrayList<INFO_SUPPLIER> GetAllSupplier();

    String GetProductInfoNewId();
    INFO_PRODUCT GetProductInfo(String product_id);
    ArrayList<ProductInfoPage> GetAllProductInfo();
    ArrayList<ProductInfoPage> GetAllProductInfoPage(int page, int start, int limit);
    int GetAllProductInfoSize();
    ProductCode AddProductInfo(INFO_PRODUCT productInfo);
    ProductCode UpdateProductInfo(INFO_PRODUCT productInfo);
    ProductCode DeleteProductInfo(ArrayList<String> listId);
	ArrayList<RepositoryInfoPage> GetAllRepository();
    ArrayList<RepositoryInfoPage> GetAllRepositoryPage(int page, int start, int limit);
    int GetAllRepositorySize();
    OperationResultCode AddRepositoryInfo(INFO_REPOSITORY repositoryInfo);
    OperationResultCode UpdateRepositoryInfo(INFO_REPOSITORY repositoryInfo);
    OperationResultCode DeleteRepositoryInfo(ArrayList<String> idList);
    RepositoryInfoPage GetRepositoryInfo(String repository_id);
    String GetNewRepositoryId();
    ArrayList<INFO_CLIENT> GetAllClientInfo();
    OperationResultCode AddClientInfo(INFO_CLIENT clientInfo);
    OperationResultCode SaveClientInfo(ArrayList<INFO_CLIENT> clientInfoList);
    OperationResultCode UpdateClientInfo(INFO_CLIENT clientInfo);
    OperationResultCode DeleteClientInfo(ArrayList<String> idList);
}
