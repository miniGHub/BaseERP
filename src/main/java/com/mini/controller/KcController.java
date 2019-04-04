package com.mini.controller;

import com.mini.model.db.cg.CG002;
import com.mini.model.db.kc.KC002;
import com.mini.model.request.ReqGrid;
import com.mini.model.request.ReqId;
import com.mini.model.response.RespCode;
import com.mini.service.ICgService;
import com.mini.service.IKcService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;

@Controller
@RequestMapping("/kc")
public class KcController {
    @Resource
    private ICgService mCgService;

    @Resource
    private IKcService mKcService;

    @RequestMapping(value = "/LoadFromPurchaseNote", method = {RequestMethod.POST})
    @ResponseBody
    public ArrayList<KC002> LoadFromPurchaseNote(@RequestBody ReqId reqId) {
        String id = reqId.getId();
        System.out.println("LoadFromPurchaseNote(): " + id);
        ArrayList<CG002> cg002s = mCgService.getPurchaseNoteDetail(id);
        System.out.println("LoadFromPurchaseNote(): find " + cg002s.size());
        ArrayList<KC002> kc002s = new ArrayList<>();
        if (cg002s.size()>0) {
            for (CG002 cg002 : cg002s) {
                KC002 kc002 = new KC002();
                kc002.setPurchase_note_id(id);
                kc002.setProduct_id(cg002.getProduct_id());
                kc002.setRepository_id(cg002.getRepository_id());
                kc002.setIn_date(new Date());
                kc002.setAmount(cg002.getAmount());
                kc002s.add(kc002);
            }
        }
        return kc002s;
    }

    @RequestMapping(value = "/SubmitStorageIn", method = {RequestMethod.POST})
    @ResponseBody
    public RespCode SubmitStorageIn(@RequestBody ReqGrid<KC002> reqParam) {
        System.out.println("SubmitStorageIn(): saving " + reqParam.getGrid().size());
        RespCode code = new RespCode();
        code.setCode(0);
        if (mKcService.saveStorageIn(reqParam.getGrid())) {
            KC002 kc002 = reqParam.getGrid().get(0);
            String purchase_note_id = kc002.getPurchase_note_id();
            String sales_return_note_id = kc002.getSales_return_note_id();
            String sales_exchange_note_id = kc002.getSales_exchange_note_id();
            String purchase_exchange_note_id = kc002.getPurchase_exchange_note_id();
            boolean ret = false;
            if (purchase_note_id != null) {
                ret = mCgService.updatePurchaseNoteStatus(purchase_note_id, 1);
            }
            else if (sales_return_note_id != null) {

            }
            else if (sales_exchange_note_id != null) {

            }
            else if (purchase_exchange_note_id != null) {

            }
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
