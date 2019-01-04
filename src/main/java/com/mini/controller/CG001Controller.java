package com.mini.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mini.HttpBody;
import com.mini.model.CG001;
import com.mini.service.ICG001Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/cg001")
public class CG001Controller {

    @Resource
    private ICG001Service CG001Service;

    @RequestMapping("/showCG001.do")
    public void selectCG001(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        JSONObject jsondata = HttpBody.getRequestJson(request);
        System.out.println("showCG001(): receive request "+jsondata.toJSONString());
        Map param = jsondata.getInnerMap();
        CG001[] cg001 = this.CG001Service.selectCG001(param);
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(cg001));
        response.getWriter().close();
    }

    @RequestMapping("/deleteCG001.do")
    public void deleteCG001(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        JSONObject jsondata = HttpBody.getRequestJson(request);
        System.out.println("deleteCG001(): receive request "+jsondata.toJSONString());
        if (jsondata.containsKey("purchase_note_id")) {
            this.CG001Service.deleteCG001(jsondata.getString("purchase_note_id"));
        }
        response.getWriter().close();
    }

    @RequestMapping("/updateCG001.do")
    public void updateCG001(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        JSONObject jsondata = HttpBody.getRequestJson(request);
        System.out.println("updateCG001(): receive request "+jsondata.toJSONString());
        CG001 one = new CG001(jsondata);
        this.CG001Service.updateCG001(one);
        response.getWriter().close();
    }

    @RequestMapping("/insertCG001.do")
    public void insertCG001(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        JSONObject jsondata = HttpBody.getRequestJson(request);
        System.out.println("insertCG001(): receive request "+jsondata.toJSONString());
        CG001 one = new CG001(jsondata);
        this.CG001Service.insertCG001(one);
        response.getWriter().close();
    }
}
