package com.mini.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mini.HttpBody;
import com.mini.model.CG002;
import com.mini.model.KC002;
import com.mini.service.ICG002Service;
import com.mini.service.IKC001Service;
import com.mini.service.IKC002Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/conversion")
public class ConversionController {
    @Resource
    private IKC002Service KC002Service;

    @Resource
    private IKC001Service KC001Service;

    @Resource
    private ICG002Service CG002Service;

    @RequestMapping("/CGtoKC.do")
    public void CGtoKC(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        JSONObject jsondata = HttpBody.getRequestJson(request);
        System.out.println("CGtoKC(): receive request "+jsondata.toJSONString());
        String id = jsondata.getString("purchase_note_id");
        CG002[] cg002s = CG002Service.selectCG002(id);
        List<KC002> kc002s = new ArrayList<>();
        KC002 kc002 = null;
        for (CG002 item : cg002s) {
            kc002 = new KC002();
            kc002.setProduct_id(item.getProduct_id());
            kc002.setRepository_id(item.getRepository_id());
            kc002.setIn_date(new Date());
            kc002.setAmount(item.getAmount());
            kc002.setPurchase_note_id(id);
            kc002s.add(kc002);
            Map param = new HashMap();
            param.put("repository_id", item.getRepository_id());
            param.put("product_id", item.getProduct_id());
            param.put("amount", item.getAmount());
            KC001Service.addKC001Amount(param);
        }
        KC002Service.insertKC002(kc002s);
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(cg002s.length));
        response.getWriter().close();
    }
}
