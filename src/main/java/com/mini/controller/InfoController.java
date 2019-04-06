package com.mini.controller;

import com.mini.common.Constant;
import com.mini.model.code.OperationResultCode;
import com.mini.model.code.ProductCode;
import com.mini.model.code.SupplierCode;
import com.mini.model.code.UserCode;
import com.mini.model.db.dic.DIC_ROLE;
import com.mini.model.db.info.*;
import com.mini.model.page.ProductInfoPage;
import com.mini.model.page.RepositoryInfoPage;
import com.mini.model.page.UserInfoPage;
import com.mini.model.page.UserPasswordPage;
import com.mini.model.request.ReqChangePassword;
import com.mini.model.request.ReqGrid;
import com.mini.model.response.RespCode;
import com.mini.model.response.RespPage;
import com.mini.service.IDicService;
import com.mini.service.IInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;

@Controller
@RequestMapping("/info")
public class InfoController {

    @Resource
    private IInfoService mInfoService;

    @Resource
    private IDicService mDicService;

    @RequestMapping(value = "/Login", method = {RequestMethod.POST})
    @ResponseBody
    public RespCode Login(@RequestBody INFO_USER reqInfoUser){
        System.out.println("Login id:" + reqInfoUser.getId() + ",password:" + reqInfoUser.getPassword());

        RespCode code = new RespCode();

        if (null == reqInfoUser.getId() || null == reqInfoUser.getPassword()) {
            code.setCode(Constant.DATA_ERROR);
            return code;
        }

        UserCode userCode = mInfoService.Login(reqInfoUser.getId(), reqInfoUser.getPassword());
        code.setCode(userCode.getCode());
        return code;
    }

    @RequestMapping(value = "/GetUserInfo", method = {RequestMethod.POST})
    @ResponseBody
    public UserInfoPage GetUserInfo(@RequestBody INFO_USER reqInfoUser) {
        System.out.println("GetUserInfo id:" + reqInfoUser.getId());

        UserInfoPage userInfoPage = new UserInfoPage();
        INFO_USER infoUser;
        DIC_ROLE dicRole;

        infoUser = mInfoService.GetUserInfo(reqInfoUser.getId());
        if (infoUser != null) {
            userInfoPage.setId(infoUser.getId());
            userInfoPage.setName(infoUser.getName());

            dicRole = mDicService.GetRole(infoUser.getRole_id());
            if (dicRole != null) {
                userInfoPage.setRole_id(dicRole.getRole_id());
                userInfoPage.setRole_name(dicRole.getRole_name());
            } else {
                System.out.println("GetUserInfo DicRole is null!!!");
            }
        } else {
            System.out.println("GetUserInfo UserInfo is null!!!");
        }

        return userInfoPage;
    }

    @RequestMapping(value = "/GetAllUserInfoPage", method = {RequestMethod.GET})
    @ResponseBody
    public RespPage<UserInfoPage> GetAllUserInfoPage(@RequestParam(defaultValue = "0") int page,
                                                     @RequestParam(defaultValue = "0") int start,
                                                     @RequestParam(defaultValue = "0") int limit,
                                                     @RequestParam(defaultValue = "false") boolean isReqDB) {
        System.out.println("GetAllUserInfoPage entry");
        System.out.println("GetAllUserInfoPage page:" + page + ",start:" + start + ",limit:" + limit + ",isReqDB" + isReqDB);

        RespPage<UserInfoPage> respUserInfoPage = new RespPage();

        if (isReqDB) {
            mInfoService.GetAllUserInfo();
        }

        respUserInfoPage.setItems(mInfoService.GetAllUserInfoPage(page, start, limit));
        respUserInfoPage.setTotal(mInfoService.GetAllUserInfoSize());

        return respUserInfoPage;
    }

    @RequestMapping(value = "/GetUserInfoNewId", method = {RequestMethod.POST})
    @ResponseBody
    public INFO_USER GetUserInfoNewId() {
        System.out.println("GetUserInfoNewId entry");

        INFO_USER userInfo = new INFO_USER();
        userInfo.setId(mInfoService.GetUserInfoNewId());

        return userInfo;
    }

    @RequestMapping(value = "/AddUserInfo", method = {RequestMethod.POST})
    @ResponseBody
    public RespCode AddUserInfo(@RequestBody INFO_USER reqInfoUser) {
        System.out.println("AddUserInfo id=" + reqInfoUser.getId() + ", name=" + reqInfoUser.getName()
                            + ",phone=" + reqInfoUser.getPhone() + ",role_id" + reqInfoUser.getRole_id()
                            + ",depart_id=" + reqInfoUser.getDepart_id());

        RespCode code = new RespCode();

        if (null == reqInfoUser.getId()) {
            code.setCode(Constant.DATA_ERROR);
            return code;
        }

        UserCode userCode;
        userCode = mInfoService.AddUserInfo(reqInfoUser);
        code.setCode(userCode.getCode());

        return code;
    }

    @RequestMapping(value = "/UpdateUserInfo", method = {RequestMethod.POST})
    @ResponseBody
    public RespCode UpdateUserInfo(@RequestBody INFO_USER reqInfoUser) {
        System.out.println("UpdateUserInfo id=" + reqInfoUser.getId() + ", name=" + reqInfoUser.getName()
                + ",phone=" + reqInfoUser.getPhone() + ",role_id" + reqInfoUser.getRole_id()
                + ",depart_id=" + reqInfoUser.getDepart_id());

        RespCode code = new RespCode();

        if (null == reqInfoUser.getId()) {
            code.setCode(Constant.DATA_ERROR);
            return code;
        }

        UserCode userCode;
        userCode = mInfoService.UpdateUserInfo(reqInfoUser);
        code.setCode(userCode.getCode());

        return code;
    }

    @RequestMapping(value = "/DeleteUserInfo", method = {RequestMethod.POST})
    @ResponseBody
    public RespCode DeleteUserInfo(@RequestBody ReqGrid<INFO_USER> reqArrayUserInfo) {
        System.out.println("DeleteUserInfo size=" + reqArrayUserInfo.getGrid().size());

        RespCode code = new RespCode();

        if (0 == reqArrayUserInfo.getGrid().size()) {
            code.setCode(Constant.DATA_ERROR);
            return code;
        }

        ArrayList<String> listId = new ArrayList<String>();
        for (int i = 0; i < reqArrayUserInfo.getGrid().size(); i++) {
            listId.add(i, reqArrayUserInfo.getGrid().get(i).getId());
        }

        UserCode userCode;
        userCode = mInfoService.DeleteUserInfo(listId);
        code.setCode(userCode.getCode());

        return code;
    }

    @RequestMapping(value = "/SubmitSupplierManager", method = {RequestMethod.POST})
    @ResponseBody
    public RespCode SubmitSupplierManager(@RequestBody ReqGrid<INFO_SUPPLIER> reqInfoSupplier){
        System.out.println("SubmitSupplierManager size:" + reqInfoSupplier.getGrid().size());

        RespCode code = new RespCode();
        if (reqInfoSupplier.getGrid().size() == 0) {
            code.setCode(Constant.DATA_ERROR);
            return code;
        }

        if (SupplierCode.SaveSuccess == mInfoService.SaveSupplier(reqInfoSupplier.getGrid())) {
            code.setCode(Constant.REQUEST_SUCCESS);
        } else {
            code.setCode(Constant.REQUEST_FAIL);
        }

        return code;
    }

    @RequestMapping(value = "/GetSupplier", method = {RequestMethod.POST})
    @ResponseBody
    public INFO_SUPPLIER GetSupplier(@RequestBody INFO_SUPPLIER reqInfoSupplier) {
        System.out.println("GetSupplier supplier_id:" + reqInfoSupplier.getSupplier_id());
        return mInfoService.GetSupplier(reqInfoSupplier.getSupplier_id());
    }

    @RequestMapping(value = "/GetProductInfoNewId", method = {RequestMethod.POST})
    @ResponseBody
    public INFO_PRODUCT GetProductInfoNewId() {
        System.out.println("GetProductInfoNewId entry");

        INFO_PRODUCT productInfo = new INFO_PRODUCT();
        productInfo.setProduct_id(mInfoService.GetProductInfoNewId());

        return productInfo;
    }
    @RequestMapping(value = "/GetAllSupplier", method = {RequestMethod.POST})
    @ResponseBody
    public ArrayList<INFO_SUPPLIER> GetAllSupplier() {
        System.out.println("GetAllSupplier come in");
        return mInfoService.GetAllSupplier();
    }

    @RequestMapping(value = "/GetAllProductInfoPage", method = {RequestMethod.GET})
    @ResponseBody
    public RespPage<ProductInfoPage> GetAllProductInfoPage(@RequestParam(defaultValue = "0") int page,
                                                                              @RequestParam(defaultValue = "0") int start,
                                                                              @RequestParam(defaultValue = "0") int limit,
                                                                              @RequestParam(defaultValue = "false") boolean isReqDB) {
        System.out.println("GetAllProductInfoPage entry");
        System.out.println("GetAllProductInfoPage page:" + page + ",start:" + start + ",limit:" + limit + ",isReqDB" + isReqDB);

        RespPage<ProductInfoPage> respProductInfoPage = new RespPage();

        if (isReqDB) {
            mInfoService.GetAllProductInfo();
        }

        respProductInfoPage.setItems(mInfoService.GetAllProductInfoPage(page, start, limit));
        respProductInfoPage.setTotal(mInfoService.GetAllProductInfoSize());

        return respProductInfoPage;
    }

    @RequestMapping(value = "/AddProductInfo", method = {RequestMethod.POST})
    @ResponseBody
    public RespCode AddProductInfo(@RequestBody INFO_PRODUCT reqInfoProduct) {
        System.out.println("AddProductInfo product_id=" + reqInfoProduct.getProduct_id()
                + ",product_type=" + reqInfoProduct.getProduct_type()
                + ",product_name=" + reqInfoProduct.getProduct_name()
                + ",product_barcode=" + reqInfoProduct.getBarcode()
                + ",product_state=" + reqInfoProduct.getState());

        RespCode code = new RespCode();

        if (null == reqInfoProduct.getProduct_id()) {
            code.setCode(Constant.DATA_ERROR);
            return code;
        }

        ProductCode productCode;
        productCode = mInfoService.AddProductInfo(reqInfoProduct);
        code.setCode(productCode.getCode());

        return code;
    }

    @RequestMapping(value = "/UpdateProductInfo", method = {RequestMethod.POST})
    @ResponseBody
    public RespCode UpdateProductInfo(@RequestBody INFO_PRODUCT reqInfoProduct) {
        System.out.println("UpdateProductInfo product_id=" + reqInfoProduct.getProduct_id()
                + ",product_type=" + reqInfoProduct.getProduct_type()
                + ",product_name=" + reqInfoProduct.getProduct_name()
                + ",product_barcode=" + reqInfoProduct.getBarcode()
                + ",product_state=" + reqInfoProduct.getState());

        RespCode code = new RespCode();

        if (null == reqInfoProduct.getProduct_id()) {
            code.setCode(Constant.DATA_ERROR);
            return code;
        }

        ProductCode productCode;
        productCode = mInfoService.UpdateProductInfo(reqInfoProduct);
        code.setCode(productCode.getCode());

        return code;
    }

    @RequestMapping(value = "/DeleteProductInfo", method = {RequestMethod.POST})
    @ResponseBody
    public RespCode DeleteProductInfo(@RequestBody ReqGrid<INFO_PRODUCT> reqArrayProductInfo) {
        System.out.println("DeleteProductInfo size=" + reqArrayProductInfo.getGrid().size());

        RespCode code = new RespCode();

        if (0 == reqArrayProductInfo.getGrid().size()) {
            code.setCode(Constant.DATA_ERROR);
            return code;
        }

        ArrayList<String> listId = new ArrayList<String>();
        for (int i = 0; i < reqArrayProductInfo.getGrid().size(); i++) {
            listId.add(i, reqArrayProductInfo.getGrid().get(i).getProduct_id());
        }

        ProductCode productCode;
        productCode = mInfoService.DeleteProductInfo(listId);
        code.setCode(productCode.getCode());

        return code;
    }

    @RequestMapping(value = "/ChangePassword", method = {RequestMethod.POST})
    @ResponseBody
    public RespCode ChangePassword(@RequestBody ReqChangePassword reqChangePassword) {
        System.out.println("ChangePassword id:" + reqChangePassword.getId());

        RespCode code = new RespCode();
        UserCode userCode;
        userCode = mInfoService.UpdatePassword(reqChangePassword.getId(), reqChangePassword.getOld_password(), reqChangePassword.getNew_password());

        code.setCode(userCode.getCode());

        return code;
    }

    @RequestMapping(value = "/GetAllUserPasswordPage", method = {RequestMethod.GET})
    @ResponseBody
    public RespPage<UserPasswordPage> GetAllUserPasswordPage(@RequestParam(defaultValue = "0") int page,
                                                             @RequestParam(defaultValue = "0") int start,
                                                             @RequestParam(defaultValue = "0") int limit,
                                                             @RequestParam(defaultValue = "false") boolean isReqDB) {
        System.out.println("GetAllUserPasswordPage entry");
        System.out.println("GetAllUserPasswordPage page:" + page + ",start:" + start + ",limit:" + limit + ",isReqDB" + isReqDB);

        RespPage<UserPasswordPage> respUserPasswordPage = new RespPage<>();

        if (isReqDB) {
            mInfoService.GetAllUserPassword();
        }

        respUserPasswordPage.setItems(mInfoService.GetAllUserPasswordPage(page, start, limit));
        respUserPasswordPage.setTotal(mInfoService.GetAllUserPasswordSize());

        return respUserPasswordPage;
    }

    @RequestMapping(value = "/ResetPassword", method = {RequestMethod.POST})
    @ResponseBody
    public RespCode ResetPassword(@RequestBody ReqGrid<INFO_USER> reqArrayUserInfo) {
        System.out.println("ResetPassword size:" + reqArrayUserInfo.getGrid().size());

        RespCode code = new RespCode();

        if (0 == reqArrayUserInfo.getGrid().size()) {
            code.setCode(Constant.DATA_ERROR);
            return code;
        }

        ArrayList<String> listId = new ArrayList<String>();
        for (int i = 0; i < reqArrayUserInfo.getGrid().size(); i++) {
            listId.add(i, reqArrayUserInfo.getGrid().get(i).getId());
        }

        UserCode userCode;
        userCode = mInfoService.ResetPassword(listId);
        code.setCode(userCode.getCode());

        return code;
    }

    @RequestMapping(value = "/GetAllRepositoryPage", method = {RequestMethod.GET})
    @ResponseBody
    public RespPage<RepositoryInfoPage> GetAllRepositoryPage(@RequestParam(defaultValue = "0") int page,
                                                             @RequestParam(defaultValue = "0") int start,
                                                             @RequestParam(defaultValue = "0") int limit,
                                                             @RequestParam(defaultValue = "false") boolean isReqDB) {
        System.out.println("GetAllRepositoryPage entry");
        System.out.println("GetAllRepositoryPage page:" + page + ",start:" + start + ",limit:" + limit + ",isReqDB:" + isReqDB);

        RespPage<RepositoryInfoPage> respUserInfoPage = new RespPage<>();

        if (isReqDB) {
            mInfoService.GetAllRepository();
        }

        respUserInfoPage.setItems(mInfoService.GetAllRepositoryPage(page, start, limit));
        respUserInfoPage.setTotal(mInfoService.GetAllRepositorySize());

        return respUserInfoPage;
    }

    @RequestMapping(value = "/AddRepositoryInfo", method = {RequestMethod.POST})
    @ResponseBody
    public RespCode AddRepositoryInfo(@RequestBody INFO_REPOSITORY repositoryInfo) {
        repositoryInfo.setRepository_id(mInfoService.GetNewRepositoryId());
        System.out.println(repositoryInfo.toString());

        RespCode code = new RespCode();
        OperationResultCode opCode;
        opCode = mInfoService.AddRepositoryInfo(repositoryInfo);
        code.setCode(opCode.getCode());

        return code;
    }

    @RequestMapping(value = "/UpdateRepositoryInfo", method = {RequestMethod.POST})
    @ResponseBody
    public RespCode UpdateRepositoryInfo(@RequestBody INFO_REPOSITORY repositoryInfo) {
        System.out.println(repositoryInfo.toString());

        RespCode code = new RespCode();
        OperationResultCode opCode;
        opCode = mInfoService.UpdateRepositoryInfo(repositoryInfo);
        code.setCode(opCode.getCode());

        return code;
    }

    @RequestMapping(value = "/DeleteRepositoryInfo", method = {RequestMethod.POST})
    @ResponseBody
    public RespCode DeleteRepositoryInfo(@RequestBody ReqGrid<String> reqStringList) {
        System.out.println("DeleteRepositoryInfo size=" + reqStringList.getGrid().size());

        RespCode code = new RespCode();
        OperationResultCode opCode;
        opCode = mInfoService.DeleteRepositoryInfo(reqStringList.getGrid());
        code.setCode(opCode.getCode());

        return code;
    }

    @RequestMapping(value = "/GetAllClientInfo", method = {RequestMethod.POST})
    @ResponseBody
    public ArrayList<INFO_CLIENT> GetAllClientInfo() {
        System.out.println("GetAllClientInfo entry");
        ArrayList<INFO_CLIENT> ret = mInfoService.GetAllClientInfo();
        System.out.println("size: " + ret.size());
        return ret;
    }

    @RequestMapping(value = "/SaveClientInfo", method = {RequestMethod.POST})
    @ResponseBody
    public RespCode SaveClientInfo(@RequestBody ReqGrid<INFO_CLIENT> clientInfoList) {
        System.out.println("SaveClientInfo() size: "+clientInfoList.getGrid().size());
        for (INFO_CLIENT client: clientInfoList.getGrid()) {
            System.out.println("SaveClientInfo(): client_name " + client.getClient_name());
        }
        RespCode code = new RespCode();
        OperationResultCode opCode;
        ArrayList<INFO_CLIENT> infoList = clientInfoList.getGrid();
        for (int index=0; index<infoList.size(); index++) {
            infoList.get(index).setClient_id(String.format("%03d", index));
        }
        opCode = mInfoService.SaveClientInfo(clientInfoList.getGrid());
        code.setCode(opCode.getCode());

        return code;
    }

    @RequestMapping(value = "/AddClientInfo", method = {RequestMethod.POST})
    @ResponseBody
    public RespCode AddClientInfo(@RequestBody INFO_CLIENT clientInfo) {
        System.out.println(clientInfo.toString());

        RespCode code = new RespCode();
        OperationResultCode opCode;
        opCode = mInfoService.AddClientInfo(clientInfo);
        code.setCode(opCode.getCode());

        return code;
    }

    @RequestMapping(value = "/UpdateClientInfo", method = {RequestMethod.POST})
    @ResponseBody
    public RespCode UpdateClientInfo(@RequestBody INFO_CLIENT clientInfo) {
        System.out.println(clientInfo.toString());

        RespCode code = new RespCode();
        OperationResultCode opCode;
        opCode = mInfoService.UpdateClientInfo(clientInfo);
        code.setCode(opCode.getCode());

        return code;
    }

    @RequestMapping(value = "/DeleteClientInfo", method = {RequestMethod.POST})
    @ResponseBody
    public RespCode DeleteClientInfo(@RequestBody ReqGrid<String> reqStringList) {
        System.out.println("DeleteRepositoryInfo size=" + reqStringList.getGrid().size());

        RespCode code = new RespCode();
        OperationResultCode opCode;
        opCode = mInfoService.DeleteClientInfo(reqStringList.getGrid());
        code.setCode(opCode.getCode());

        return code;
    }
}
