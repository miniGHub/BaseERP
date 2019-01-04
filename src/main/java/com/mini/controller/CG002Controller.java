package com.mini.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mini.HttpBody;
import com.mini.model.CG002;
import com.mini.service.ICG002Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cg002")
public class CG002Controller {

    @Resource
    private ICG002Service CG002Service;

    @RequestMapping("/showCG002.do")
    public void selectCG002(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        JSONObject jsondata = HttpBody.getRequestJson(request);
        System.out.println("showCG002(): receive request "+jsondata.toJSONString());
        CG002[] cg002 = this.CG002Service.selectCG002(jsondata.getString("purchase_note_id"));
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(cg002));
        response.getWriter().close();
    }

    @RequestMapping("/deleteCG002.do")
    public void deleteCG002(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        JSONObject jsondata = HttpBody.getRequestJson(request);
        System.out.println("deleteCG002(): receive request "+jsondata.toJSONString());
        if (jsondata.containsKey("purchase_note_id")) {
            this.CG002Service.deleteCG002(jsondata.getString("purchase_note_id"));
        }
        response.getWriter().close();
    }

    @RequestMapping("/updateCG002.do")
    public void updateCG002(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        JSONObject jsondata = HttpBody.getRequestJson(request);
        System.out.println("updateCG002(): receive request "+jsondata.toJSONString());
        CG002 one = new CG002(jsondata);
        this.CG002Service.updateCG002(one);
        response.getWriter().close();
    }

    @RequestMapping("/insertCG002.do")
    public void insertCG002(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        JSONArray jsonarray = HttpBody.getRequestJsons(request);
        System.out.println("insertCG002(): receive request "+jsonarray.toString());
        List<CG002> params = new ArrayList<>();
        for (int i=0; i<jsonarray.size();i++) {
            params.add(new CG002(jsonarray.getJSONObject(i)));
        }
        this.CG002Service.insertCG002(params);
        response.getWriter().close();
    }
}
