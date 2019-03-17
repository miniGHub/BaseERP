package com.mini.controller;

import com.mini.common.Constant;
import com.mini.model.UserCode;
import com.mini.model.dic.DIC_ROLE;
import com.mini.model.info.INFO_USER;
import com.mini.model.request.ReqUserInfo;
import com.mini.model.response.RespUserInfoPage;
import com.mini.model.UserInfoPage;
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
}
