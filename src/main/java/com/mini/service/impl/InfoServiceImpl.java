package com.mini.service.impl;

import com.mini.common.Constant;
import com.mini.dao.info.*;
import com.mini.model.code.ProductCode;
import com.mini.model.code.OperationResultCode;
import com.mini.model.code.UserCode;
import com.mini.model.db.info.*;
import com.mini.model.page.ProductInfoPage;
import com.mini.model.page.RepositoryInfoPage;
import com.mini.model.page.UserInfoPage;
import com.mini.model.page.UserPasswordPage;
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
	@Resource
    private IInfoRepository mInfoRepository;
    @Resource
    private IInfoClient mInfoClient;

    private ArrayList<UserInfoPage> mArrayUserInfo = new ArrayList<>();
    private ArrayList<ProductInfoPage> mArrayProductInfo = new ArrayList<>();
	private ArrayList<UserPasswordPage> mArrayUserPassword = new ArrayList<>();
	private ArrayList<RepositoryInfoPage> mArrayRepository = new ArrayList<>();
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
    public String GetUserInfoNewId() {
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
    public boolean SaveSupplier(ArrayList<INFO_SUPPLIER> supplier) {
        mInfoSupplier.DeleteSupplier();
        mInfoSupplier.InsertSupplier(supplier);
        return true;
    }

    @Override
    public INFO_SUPPLIER GetSupplier(String supplier_id) {
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
    public String GetProductInfoNewId() {
        String newId = mInfoProduct.SelectMaxId();

        if (null == newId) {
            newId = Constant.DEFAULT_ID;
        } else {
            newId = String.format("%03d", Integer.parseInt(newId) + 1);
        }

        return newId;
    }
    @Override
    public ProductCode AddProductInfo(INFO_PRODUCT productInfo) {
        ProductCode ret = ProductCode.AddSuccess;
        int cnt = 0;

        cnt = mInfoProduct.CountProductInfo(productInfo.getProduct_id());
        if (1 == cnt) {
            ret = ProductCode.Exist;
        } else if (cnt > 1 ) {
            ret = ProductCode.AddError;
        } else {
            mInfoProduct.InsertProductInfo(productInfo);
        }

        return ret;
    }

    @Override
    public ProductCode UpdateProductInfo(INFO_PRODUCT productInfo) {
        ProductCode ret = ProductCode.UpdateSuccess;
        int cnt = 0;

        cnt = mInfoProduct.CountProductInfo(productInfo.getProduct_id());
        if (0 == cnt) {
            ret = ProductCode.NotExist;
        } else if (cnt > 1){
            ret = ProductCode.UpdateError;
        } else {
            mInfoProduct.UpdateProductInfo(productInfo);
        }

        return ret;
    }

    @Override
    public ProductCode DeleteProductInfo(ArrayList<String> listId) {
        ProductCode ret = ProductCode.DeleteSuccess;

        mInfoProduct.DeleteProductInfo(listId);

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

    @Override
    public ArrayList<RepositoryInfoPage> GetAllRepository() {
        mArrayRepository.clear();
        mArrayRepository = mInfoRepository.SelectAllRepositoryInfo();
        return mArrayRepository;
    }

    @Override
    public ArrayList<RepositoryInfoPage> GetAllRepositoryPage(int page, int start, int limit) {
        if (mArrayRepository.size() == 0) {
            mArrayRepository = mInfoRepository.SelectAllRepositoryInfo();
        }
        ArrayList<RepositoryInfoPage> repositoryInfoList = new ArrayList<>();
        for(int index = start, cnt = 0; index < mArrayRepository.size() && cnt < limit; index++, cnt++) {
            repositoryInfoList.add(mArrayRepository.get(index));
        }
        return repositoryInfoList;
    }

    @Override
    public int GetAllRepositorySize() {
        return mArrayRepository.size();
    }

    @Override
    public OperationResultCode AddRepositoryInfo(INFO_REPOSITORY repositoryInfo) {
        if (mInfoRepository.AddRepositoryInfo(repositoryInfo) == 0) {
            return OperationResultCode.AddFailed;
        }
        return OperationResultCode.Success;
    }

    @Override
    public OperationResultCode UpdateRepositoryInfo(INFO_REPOSITORY repositoryInfo) {
        if (mInfoRepository.UpdateRepositoryInfo(repositoryInfo) == 0) {
            return OperationResultCode.UpdateFailed;
        }
        return OperationResultCode.Success;
    }

    @Override
    public OperationResultCode DeleteRepositoryInfo(ArrayList<String> idList) {
        if (mInfoRepository.DeleteRepositoryInfo(idList) != idList.size()) {
            return OperationResultCode.DeleteFailed;
        }
        return OperationResultCode.Success;
    }

    @Override
    public RepositoryInfoPage GetRepositoryInfo(String repository_id) {
        if (mArrayRepository.size() == 0) {
            mArrayRepository = mInfoRepository.SelectAllRepositoryInfo();
        }
        for (RepositoryInfoPage info: mArrayRepository) {
            if (info.getRepository_id().equals(repository_id)) {
                return info;
            }
        }
        return null;
    }

    @Override
    public ArrayList<INFO_CLIENT> GetAllClientInfo() {
        return mInfoClient.SelectAll();
    }

    @Override
    public String GetNewRepositoryId() {
        String maxId = mInfoRepository.GetMaxId();
        if (maxId == null) {
            return "000";
        }
        else {
            return String.format("%03d", Integer.valueOf(maxId)+1);
        }
    }

    @Override
    public OperationResultCode SaveClientInfo(ArrayList<INFO_CLIENT> clientInfoList) {
        mInfoClient.DeleteAll();
        if (mInfoClient.SaveClientInfoList(clientInfoList) != clientInfoList.size()) {
            return OperationResultCode.SaveFailed;
        }
        return OperationResultCode.Success;
    }

    @Override
    public OperationResultCode AddClientInfo(INFO_CLIENT clientInfo) {
        if (mInfoClient.AddClientInfo(clientInfo) == 0) {
            return OperationResultCode.AddFailed;
        }
        return OperationResultCode.Success;
    }

    @Override
    public OperationResultCode UpdateClientInfo(INFO_CLIENT clientInfo) {
        if (mInfoClient.UpdateClientInfo(clientInfo) == 0) {
            return OperationResultCode.UpdateFailed;
        }
        return OperationResultCode.Success;
    }

    @Override
    public OperationResultCode DeleteClientInfo(ArrayList<String> idList) {
        if (mInfoClient.DeleteClientInfo(idList) == 0) {
            return OperationResultCode.DeleteFailed;
        }
        return OperationResultCode.Success;
    }
}
