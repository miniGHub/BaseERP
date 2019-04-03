package com.mini.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mini.model.db.cg.CG002;
import com.mini.model.db.kc.KC002;
import com.mini.model.request.ReqGrid;
import com.mini.model.response.RespCode;
import com.mini.service.ICgService;
import com.mini.service.IKcService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

@Controller
@RequestMapping("/kc")
public class KcController {
    @Resource
    private ICgService mCgService;

    @Resource
    private IKcService mKcService;

    @RequestMapping("/LoadFromPurchaseNote")
    public void LoadFromPurchaseNote(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String id = request.getParameter("purchase_note_id");
        System.out.println("LoadFromPurchaseNote(): " + id);
        ArrayList<CG002> cg002s = mCgService.getPurchaseNoteDetail(id);
        System.out.println("LoadFromPurchaseNote(): find " + cg002s.size());
        ObjectMapper mapper = new ObjectMapper();
        if (cg002s.size()>0) {
            KC002[] kc002s = new KC002[cg002s.size()];
            for (int i=0; i<cg002s.size(); i++) {
                CG002 cg002 = cg002s.get(i);
                kc002s[i] = new KC002();
                kc002s[i].setPurchase_note_id(id);
                kc002s[i].setProduct_id(cg002.getProduct_id());
                kc002s[i].setRepository_id(cg002.getRepository_id());
                kc002s[i].setIn_date(new Date());
                kc002s[i].setAmount(cg002.getAmount());
            }
            response.getWriter().write(mapper.writeValueAsString(kc002s));
        }
        response.getWriter().close();
    }

    @RequestMapping(value = "/SubmitStorageIn", method = {RequestMethod.POST})
    @ResponseBody
    public RespCode SubmitStorageIn(@RequestBody ReqGrid<KC002> reqParam) {
        System.out.println("SubmitStorageIn(): saving " + reqParam.getGrid().size());
        RespCode code = new RespCode();
        code.setCode(0);
        if (mKcService.saveStorageIn(reqParam.getGrid())) {
            HashMap<String, Object> param = new HashMap<>();
            KC002 kc002 = reqParam.getGrid().get(0);
            String purchase_note_id = kc002.getPurchase_note_id();
            String sales_return_note_id = kc002.getSales_return_note_id();
            String sales_exchange_note_id = kc002.getSales_exchange_note_id();
            String purchase_exchange_note_id = kc002.getPurchase_exchange_note_id();
            param.put("note_status", 1);
            boolean ret = false;
            if (purchase_note_id != null) {
                param.put("purchase_note_id", purchase_note_id);
                ret = mCgService.updatePurchaseNoteStatus(param);
            }
            else if (sales_return_note_id != null) {
                param.put("sales_return_note_id", sales_return_note_id);
            }
            else if (sales_exchange_note_id != null) {
                param.put("sales_exchange_note_id", sales_exchange_note_id);
            }
            else if (purchase_exchange_note_id != null) {
                param.put("purchase_exchange_note_id", purchase_exchange_note_id);
            }
            System.out.println("SubmitStorageIn(): update note_status param: "+param.toString());
            if (ret) {
                code.setCode(1);
            }
        }
        else {
            System.out.println("SubmitStorageIn(): failed");
        }
        return code;
    }
}
