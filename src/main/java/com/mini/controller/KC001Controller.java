package com.mini.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mini.HttpBody;
import com.mini.model.KC001;
import com.mini.service.IKC001Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/kc001")
public class KC001Controller {

    @Resource
    private IKC001Service KC001Service;

    @RequestMapping("/showKC001.do")
    public void selectKC001(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        JSONObject jsondata = HttpBody.getRequestJson(request);
        System.out.println("showKC001(): receive request "+jsondata.toJSONString());
        Map param = jsondata.getInnerMap();
        KC001[] kc001 = this.KC001Service.selectKC001(param);
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(kc001));
        response.getWriter().close();
    }

    @RequestMapping("/deleteKC001.do")
    public void deleteKC001(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        JSONObject jsondata = HttpBody.getRequestJson(request);
        System.out.println("deleteKC001(): receive request "+jsondata.toJSONString());
        Map param = jsondata.getInnerMap();
        this.KC001Service.deleteKC001(param);
        response.getWriter().close();
    }

    @RequestMapping("/updateKC001.do")
    public void updateKC001(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        JSONObject jsondata = HttpBody.getRequestJson(request);
        System.out.println("updateKC001(): receive request "+jsondata.toJSONString());
        KC001 one = new KC001(jsondata);
        this.KC001Service.updateKC001(one);
        response.getWriter().close();
    }

    @RequestMapping("/insertKC001.do")
    public void insertKC001(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        JSONObject jsondata = HttpBody.getRequestJson(request);
        System.out.println("insertKC001(): receive request "+jsondata.toJSONString());
        KC001 one = new KC001(jsondata);
        this.KC001Service.insertKC001(one);
        response.getWriter().close();
    }
}
