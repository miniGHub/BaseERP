package com.mini.controller;

import com.mini.common.Constant;
import com.mini.model.dic.DIC_DEPART;
import com.mini.model.dic.DIC_PRODUCT;
import com.mini.model.dic.DIC_REPOSITORY;
import com.mini.model.dic.DIC_ROLE;
import com.mini.model.request.ReqDepart;
import com.mini.model.request.ReqProduct;
import com.mini.model.request.ReqRepository;
import com.mini.model.request.ReqRole;
import com.mini.model.response.ResponseCode;
import com.mini.service.IDicService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;

@Controller
@RequestMapping("/dic")
public class DicController {

    @Resource
    private IDicService mDicService;

    @RequestMapping(value = "/SubmitRoleManager", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseCode SubmitRoleManager(@RequestBody ReqRole reqDicRole){
        System.out.println("SubmitRoleManager size:" + reqDicRole.getGrid().size());

        ResponseCode code = new ResponseCode();
        if (reqDicRole.getGrid().size() == 0) {
            code.setCode(Constant.DATA_ERROR);
            return code;
        }

        if (mDicService.SaveRole(reqDicRole.getGrid())) {
            code.setCode(Constant.REQUEST_SUCCESS);
        } else {
            code.setCode(Constant.REQUEST_FAIL);
        }

        return code;
    }

    @RequestMapping(value = "/GetRole", method = {RequestMethod.POST})
    @ResponseBody
    public DIC_ROLE GetRole(@RequestBody DIC_ROLE reqDicRole) {
        System.out.println("GetRole role_id:" + reqDicRole.getRole_id());
        return mDicService.GetRole(reqDicRole.getRole_id());
    }

    @RequestMapping(value = "/GetAllRole", method = {RequestMethod.POST})
    @ResponseBody
    public ArrayList<DIC_ROLE> GetAllRole() {
        return mDicService.GetAllRole();
    }

    @RequestMapping(value = "/SubmitDepartManager", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseCode SubmitDepartManager(@RequestBody ReqDepart reqDicDepart){
        System.out.println("SubmitDepartManager size:" + reqDicDepart.getGrid().size());

        ResponseCode code = new ResponseCode();
        if (reqDicDepart.getGrid().size() == 0) {
            code.setCode(Constant.DATA_ERROR);
            return code;
        }

        if (mDicService.SaveDepart(reqDicDepart.getGrid())) {
            code.setCode(Constant.REQUEST_SUCCESS);
        } else {
            code.setCode(Constant.REQUEST_FAIL);
        }

        return code;
    }

    @RequestMapping(value = "/GetDepart", method = {RequestMethod.POST})
    @ResponseBody
    public DIC_DEPART GetDepart(@RequestBody DIC_DEPART reqDicDepart) {
        System.out.println("GetDepart depart_id:" + reqDicDepart.getDepart_id());
        return mDicService.GetDepart(reqDicDepart.getDepart_id());
    }

    @RequestMapping(value = "/GetAllDepart", method = {RequestMethod.POST})
    @ResponseBody
    public ArrayList<DIC_DEPART> GetAllDepart() {
        System.out.println("GetAllDepart come in");
        return mDicService.GetAllDepart();
    }

    @RequestMapping(value = "/SubmitProductInfo", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseCode SubmitProductInfo(@RequestBody ReqProduct reqDicProduct){
        System.out.println("SubmitProductInfo size:" + reqDicProduct.getGrid().size());

        ResponseCode code = new ResponseCode();
        if (reqDicProduct.getGrid().size() == 0) {
            code.setCode(Constant.DATA_ERROR);
            return code;
        }

        if (mDicService.SaveProduct(reqDicProduct.getGrid())) {
            code.setCode(Constant.REQUEST_SUCCESS);
        } else {
            code.setCode(Constant.REQUEST_FAIL);
        }

        return code;
    }

    @RequestMapping(value = "/GetProduct", method = {RequestMethod.POST})
    @ResponseBody
    public DIC_PRODUCT GetProduct(@RequestBody DIC_PRODUCT reqDicProduct) {
        System.out.println("GetProduct productType:" + reqDicProduct.getProduct_type());
        return mDicService.GetProduct(reqDicProduct.getProduct_type());
    }

    @RequestMapping(value = "/GetAllProduct", method = {RequestMethod.POST})
    @ResponseBody
    public ArrayList<DIC_PRODUCT> GetAllProduct() {
        System.out.println("GetAllProduct come in");
        return mDicService.GetAllProduct();
    }

    @RequestMapping(value = "/SubmitRepositoryInfo", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseCode SubmitRepositoryInfo(@RequestBody ReqRepository reqDicRepository){
        System.out.println("SubmitRepositoryInfo size:" + reqDicRepository.getGrid().size());

        ResponseCode code = new ResponseCode();
        if (reqDicRepository.getGrid().size() == 0) {
            code.setCode(Constant.DATA_ERROR);
            return code;
        }

        if (mDicService.SaveRepository(reqDicRepository.getGrid())) {
            code.setCode(Constant.REQUEST_SUCCESS);
        } else {
            code.setCode(Constant.REQUEST_FAIL);
        }

        return code;
    }

    @RequestMapping(value = "/GetRepository", method = {RequestMethod.POST})
    @ResponseBody
    public DIC_REPOSITORY GetRepository(@RequestBody DIC_REPOSITORY reqDicRepository) {
        System.out.println("GetRepository repositoryType:" + reqDicRepository.getRepository_type());
        return mDicService.GetRepository(reqDicRepository.getRepository_type());
    }

    @RequestMapping(value = "/GetAllRepository", method = {RequestMethod.POST})
    @ResponseBody
    public ArrayList<DIC_REPOSITORY> GetAllRepository() {
        System.out.println("GetAllRepository come in");
        return mDicService.GetAllRepository();
    }
}
