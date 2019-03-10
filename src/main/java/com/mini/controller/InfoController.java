package com.mini.controller;

import com.mini.common.Constant;
import com.mini.model.UserCode;
import com.mini.model.dic.DIC_ROLE;
import com.mini.model.info.INFO_USER;
import com.mini.model.response.RespUserInfo;
import com.mini.model.response.ResponseCode;
import com.mini.service.IDicService;
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

    @Resource
    private IDicService mDicService;

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
    public RespUserInfo GetUserInfo(@RequestBody INFO_USER reqInfoUser) {
        System.out.println("GetUserInfo id:" + reqInfoUser.getId());

        RespUserInfo respUserInfo = new RespUserInfo();
        INFO_USER infoUser;
        DIC_ROLE dicRole;

        infoUser = mInfoService.GetUserInfo(reqInfoUser.getId());
        if (infoUser != null) {
            respUserInfo.setId(infoUser.getId());
            respUserInfo.setName(infoUser.getName());

            dicRole = mDicService.GetRole(infoUser.getRole_id());
            if (dicRole != null) {
                respUserInfo.setRole_id(dicRole.getRole_id());
                respUserInfo.setRole_name(dicRole.getRole_name());
            } else {
                System.out.println("GetUserInfo DicRole is null!!!");
            }
        } else {
            System.out.println("GetUserInfo UserInfo is null!!!");
        }

        return respUserInfo;
    }
}
