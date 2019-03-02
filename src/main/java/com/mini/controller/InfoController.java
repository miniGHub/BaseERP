package com.mini.controller;

import com.mini.common.Constant;
import com.mini.model.UserCode;
import com.mini.model.info.INFO_USER;
import com.mini.model.response.ResponseCode;
import com.mini.service.IInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/info")
public class InfoController {

    @Resource
    private IInfoService mInfoService;

    @RequestMapping(value = "/login", method = {RequestMethod.POST})
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

    @RequestMapping(value = "/getUserInfo", method = {RequestMethod.POST})
    @ResponseBody
    public INFO_USER GetUserInfo(@RequestBody INFO_USER reqInfoUser) {
        System.out.println("GetUserInfo id:" + reqInfoUser.getId());

        return mInfoService.GetUserInfo(reqInfoUser.getId());
    }

}
