package com.mini.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mini.HttpBody;
import com.mini.model.KC002;
import com.mini.model.KC002;
import com.mini.service.IKC002Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/kc002")
public class KC002Controller {
    @Resource
    private IKC002Service KC002Service;

    @RequestMapping("/showKC002.do")
    public void selectKC002(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        JSONObject jsondata = HttpBody.getRequestJson(request);
        System.out.println("showKC002(): receive request "+jsondata.toJSONString());
        Map param = jsondata.getInnerMap();
        KC002[] ones = this.KC002Service.selectKC002(param);
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(ones));
        response.getWriter().close();
    }

    @RequestMapping("/deleteKC002.do")
    public void deleteKC002(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        JSONObject jsondata = HttpBody.getRequestJson(request);
        System.out.println("deleteKC002(): receive request "+jsondata.toJSONString());
        Map param = jsondata.getInnerMap();
        this.KC002Service.deleteKC002(param);
        response.getWriter().close();
    }

    @RequestMapping("/updateKC002.do")
    public void updateKC002(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        JSONObject jsondata = HttpBody.getRequestJson(request);
        System.out.println("updateKC002(): receive request "+jsondata.toJSONString());
        KC002 one = new KC002(jsondata);
        this.KC002Service.updateKC002(one);
        response.getWriter().close();
    }

    @RequestMapping("/insertKC002.do")
    public void insertKC002(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        JSONArray jsonarray = HttpBody.getRequestJsons(request);
        System.out.println("updateKC002(): receive request "+jsonarray.toJSONString());
        List<KC002> params = new ArrayList<>();
        for (int i=0; i<jsonarray.size();i++) {
            params.add(new KC002(jsonarray.getJSONObject(i)));
        }
        this.KC002Service.insertKC002(params);
        response.getWriter().close();
    }
}
