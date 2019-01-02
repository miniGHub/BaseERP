package com.mini.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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
        String product_id = request.getParameter("product_id");
        Map param = new HashMap();
        if (product_id != null) {
            param.put("product_id", product_id);
        }
        KC001[] kc001 = this.KC001Service.selectKC001(param);
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(kc001));
        response.getWriter().close();
    }

    @RequestMapping("/deleteKC001.do")
    public void deleteCG002(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String product_id = request.getParameter("product_id");
        this.KC001Service.deleteKC001(product_id);
//        ObjectMapper mapper = new ObjectMapper();
//        response.getWriter().write(mapper.writeValueAsString(cg001));
        response.getWriter().close();
    }

    @RequestMapping("/updateKC001.do")
    public void updateKC001(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        KC001 one = new KC001();
        one.setProduct_id(request.getParameter("product_id"));
        this.KC001Service.updateKC001(one);
//        ...
//        ObjectMapper mapper = new ObjectMapper();
//        response.getWriter().write(mapper.writeValueAsString(cg001));
        response.getWriter().close();
    }

    @RequestMapping("/insertKC001.do")
    public void insertCG002(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        KC001 one = new KC001();
        one.setProduct_id(request.getParameter("product_id"));
        this.KC001Service.insertKC001(one);
//        ObjectMapper mapper = new ObjectMapper();
//        response.getWriter().write(mapper.writeValueAsString(cg001));
        response.getWriter().close();
    }
}
