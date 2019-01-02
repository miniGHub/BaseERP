package com.mini.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mini.model.KC002;
import com.mini.service.IKC002Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/kc002")
public class KC002Controller {
    @Resource
    private IKC002Service KC002Service;

    @RequestMapping("/showKC002.do")
    public void selectKC002(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String product_id = request.getParameter("product_id");
        KC002 KC002 = this.KC002Service.selectKC002(product_id);
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(KC002));
        response.getWriter().close();
    }

    @RequestMapping("/deleteKC002.do")
    public void deleteCG002(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String product_id = request.getParameter("product_id");
        this.KC002Service.deleteKC002(product_id);
//        ObjectMapper mapper = new ObjectMapper();
//        response.getWriter().write(mapper.writeValueAsString(cg001));
        response.getWriter().close();
    }

    @RequestMapping("/updateKC002.do")
    public void updateKC002(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        KC002 one = new KC002();
        one.setProduct_id(request.getParameter("product_id"));
        this.KC002Service.updateKC002(one);
//        ...
//        ObjectMapper mapper = new ObjectMapper();
//        response.getWriter().write(mapper.writeValueAsString(cg001));
        response.getWriter().close();
    }

    @RequestMapping("/insertKC002.do")
    public void insertCG002(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        int amount = 3;
        KC002[] ones = new KC002[amount];
        for (KC002 item: ones) {
            item.setProduct_id(request.getParameter("product_id"));
        }
        this.KC002Service.insertKC002(ones);
//        ObjectMapper mapper = new ObjectMapper();
//        response.getWriter().write(mapper.writeValueAsString(cg001));
        response.getWriter().close();
    }
}
