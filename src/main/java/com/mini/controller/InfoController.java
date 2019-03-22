package com.mini.controller;

import com.mini.common.Constant;
import com.mini.model.ProductInfoPage;
import com.mini.model.UserCode;
import com.mini.model.UserInfoPage;
import com.mini.model.dic.DIC_PRODUCT;
import com.mini.model.dic.DIC_ROLE;
import com.mini.model.info.INFO_PRODUCT;
import com.mini.model.info.INFO_SUPPLIER;
import com.mini.model.info.INFO_USER;
import com.mini.model.request.ReqProductInfo;
import com.mini.model.request.ReqSupplier;
import com.mini.model.request.ReqUserInfo;
import com.mini.model.response.RespProductInfoPage;
import com.mini.model.response.RespUserInfoPage;
import com.mini.model.response.ResponseCode;
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
    public ResponseCode Login(@RequestBody INFO_USER reqInfoUser){
        System.out.println("Login id:" + reqInfoUser.getId() + ",password:" + reqInfoUser.getPassword());

        ResponseCode code = new ResponseCode();

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
    public RespUserInfoPage GetAllUserInfoPage(@RequestParam(defaultValue = "0") int page,
                                               @RequestParam(defaultValue = "0") int start,
                                               @RequestParam(defaultValue = "0") int limit,
                                               @RequestParam(defaultValue = "false") boolean isReqDB) {
        System.out.println("GetAllUserInfoPage entry");
        System.out.println("GetAllUserInfoPage page:" + page + ",start:" + start + ",limit:" + limit + ",isReqDB" + isReqDB);

        RespUserInfoPage respUserInfoPage = new RespUserInfoPage();

        if (isReqDB) {
            mInfoService.GetAllUserInfo();
        }

        respUserInfoPage.setItems(mInfoService.GetAllUserInfoPage(page, start, limit));
        respUserInfoPage.setTotal(mInfoService.GetAllUserInfoSize());

        return respUserInfoPage;
    }

    @RequestMapping(value = "/AddUserInfo", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseCode AddUserInfo(@RequestBody INFO_USER reqInfoUser) {
        System.out.println("AddUserInfo id=" + reqInfoUser.getId() + ", name=" + reqInfoUser.getName()
                            + ",phone=" + reqInfoUser.getPhone() + ",role_id" + reqInfoUser.getRole_id()
                            + ",depart_id=" + reqInfoUser.getDepart_id());

        ResponseCode code = new ResponseCode();

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
    public ResponseCode UpdateUserInfo(@RequestBody INFO_USER reqInfoUser) {
        System.out.println("UpdateUserInfo id=" + reqInfoUser.getId() + ", name=" + reqInfoUser.getName()
                + ",phone=" + reqInfoUser.getPhone() + ",role_id" + reqInfoUser.getRole_id()
                + ",depart_id=" + reqInfoUser.getDepart_id());

        ResponseCode code = new ResponseCode();

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
    public ResponseCode DeleteUserInfo(@RequestBody ReqUserInfo reqArrayUserInfo) {
        System.out.println("DeleteUserInfo size=" + reqArrayUserInfo.getGrid().size());

        ResponseCode code = new ResponseCode();

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
    public ResponseCode SubmitSupplierManager(@RequestBody ReqSupplier reqInfoSupplier){
        System.out.println("SubmitSupplierManager size:" + reqInfoSupplier.getGrid().size());

        ResponseCode code = new ResponseCode();
        if (reqInfoSupplier.getGrid().size() == 0) {
            code.setCode(Constant.DATA_ERROR);
            return code;
        }

        if (mInfoService.SaveSupplier(reqInfoSupplier.getGrid())) {
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

    @RequestMapping(value = "/GetAllSupplier", method = {RequestMethod.POST})
    @ResponseBody
    public ArrayList<INFO_SUPPLIER> GetAllSupplier() {
        System.out.println("GetAllSupplier come in");
        return mInfoService.GetAllSupplier();
    }

    @RequestMapping(value = "/GetProductInfo", method = {RequestMethod.POST})
    @ResponseBody
    public ProductInfoPage GetProductInfo(@RequestBody INFO_PRODUCT reqInfoProduct) {
        System.out.println("GetProductInfo id:" + reqInfoProduct.getProduct_id());

        ProductInfoPage productInfoPage = new ProductInfoPage();
        INFO_PRODUCT infoProduct;
        DIC_PRODUCT dicProduct;

        infoProduct = mInfoService.GetProductInfo(reqInfoProduct.getProduct_id());
        if (infoProduct != null) {
            productInfoPage.setProduct_id(infoProduct.getProduct_id());
            productInfoPage.setProduct_specific_name(infoProduct.getProduct_specific_namename());

            dicProduct = mDicService.GetProduct(infoProduct.getProduct_type());
            if (dicProduct != null) {
                productInfoPage.setProduct_type(dicProduct.getProduct_type());
                productInfoPage.setProduct_name(dicProduct.getProduct_name());
            } else {
                System.out.println("GetProductInfo dicProduct is null!!!");
            }
        } else {
            System.out.println("GetProductInfo infoProduct is null!!!");
        }

        return productInfoPage;
    }

    @RequestMapping(value = "/GetAllProductInfoPage", method = {RequestMethod.GET})
    @ResponseBody
    public RespProductInfoPage GetAllProductInfoPage(@RequestParam(defaultValue = "0") int page,
                                               @RequestParam(defaultValue = "0") int start,
                                               @RequestParam(defaultValue = "0") int limit,
                                               @RequestParam(defaultValue = "false") boolean isReqDB) {
        System.out.println("GetAllProductInfoPage entry");
        System.out.println("GetAllProductInfoPage page:" + page + ",start:" + start + ",limit:" + limit + ",isReqDB" + isReqDB);

        RespProductInfoPage respProductInfoPage = new RespProductInfoPage();

        if (isReqDB) {
            mInfoService.GetAllProductInfo();
        }

        respProductInfoPage.setItems(mInfoService.GetAllProductInfoPage(page, start, limit));
        respProductInfoPage.setTotal(mInfoService.GetAllProductInfoSize());

        return respProductInfoPage;
    }

    @RequestMapping(value = "/AddProductInfo", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseCode AddProductInfo(@RequestBody INFO_PRODUCT reqInfoProduct) {
        System.out.println("AddProductInfo product_id=" + reqInfoProduct.getProduct_id()
                + ", product_type=" + reqInfoProduct.getProduct_type()
                + ",product_specific_name=" + reqInfoProduct.getProduct_specific_namename()
                + ",product_barcode" + reqInfoProduct.getBarcode()
                + ",product_state=" + reqInfoProduct.getState());

        ResponseCode code = new ResponseCode();

        if (null == reqInfoProduct.getProduct_id()) {
            code.setCode(Constant.DATA_ERROR);
            return code;
        }

        UserCode userCode;
        userCode = mInfoService.AddProductInfo(reqInfoProduct);
        code.setCode(userCode.getCode());

        return code;
    }

    @RequestMapping(value = "/UpdateProductInfo", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseCode UpdateProductInfo(@RequestBody INFO_PRODUCT reqInfoProduct) {
        System.out.println("UpdateProductInfo product_id=" + reqInfoProduct.getProduct_id()
                + ", product_type=" + reqInfoProduct.getProduct_type()
                + ",product_specific_name=" + reqInfoProduct.getProduct_specific_namename()
                + ",product_barcode" + reqInfoProduct.getBarcode()
                + ",product_state=" + reqInfoProduct.getState());

        ResponseCode code = new ResponseCode();

        if (null == reqInfoProduct.getProduct_id()) {
            code.setCode(Constant.DATA_ERROR);
            return code;
        }

        UserCode userCode;
        userCode = mInfoService.UpdateProductInfo(reqInfoProduct);
        code.setCode(userCode.getCode());

        return code;
    }

    @RequestMapping(value = "/DeleteProductInfo", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseCode DeleteProductInfo(@RequestBody ReqProductInfo reqArrayProductInfo) {
        System.out.println("DeleteProductInfo size=" + reqArrayProductInfo.getGrid().size());

        ResponseCode code = new ResponseCode();

        if (0 == reqArrayProductInfo.getGrid().size()) {
            code.setCode(Constant.DATA_ERROR);
            return code;
        }

        ArrayList<String> listId = new ArrayList<String>();
        for (int i = 0; i < reqArrayProductInfo.getGrid().size(); i++) {
            listId.add(i, reqArrayProductInfo.getGrid().get(i).getProduct_id());
        }

        UserCode userCode;
        userCode = mInfoService.DeleteProductInfo(listId);
        code.setCode(userCode.getCode());

        return code;
    }


}
