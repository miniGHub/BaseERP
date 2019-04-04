package com.mini.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mini.model.db.cg.CG001;
import com.mini.model.db.cg.CG002;
import com.mini.model.request.ReqFormGrid;
import com.mini.model.response.RespPurchaseNoteId;
import com.mini.model.response.RespCode;
import com.mini.model.db.xs.XS001;
import com.mini.model.db.xs.XS002;
import com.mini.service.ICgService;
import com.mini.service.IXsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

@Controller
@RequestMapping("/cg")
public class CgController {

    @Resource
    private ICgService mCgService;

    @Resource
    private IXsService mXsService;

    private String generatePurchaseNoteId() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String id_prefix = "JH-"+df.format(new Date())+"-";
        int amount = mCgService.countTodayItems(id_prefix+"%");
        return String.format("%s%04d", id_prefix, amount+1);
    }
    
    @RequestMapping("/LoadBaseFromSalesOrder")
    public void LoadBaseFromSalesOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String id = request.getParameter("Sales_order_note_id");
        System.out.println("LoadBaseFromSalesOrder(): " + id);
        XS001 xs001 = mXsService.GetSalesOrderNote(id);
        CG001 cg001 = new CG001();
        cg001.setEntry_date(new Date());
        cg001.setSales_order_note_id(xs001.getSales_order_note_id());
        cg001.setRepository_id(xs001.getRepository_id());
        cg001.setDepart_id(xs001.getDepart_id());
        cg001.setRemark(xs001.getRemark());
        cg001.setAddition(xs001.getAddition());
        cg001.setEntry_date(new Date());
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(cg001));
        response.getWriter().close();
    }

    @RequestMapping("/LoadDetailFromSalesOrder")
    public void LoadDetailFromSalesOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String id = request.getParameter("Sales_order_note_id");
        System.out.println("LoadDetailFromSalesOrder(): " + id);
        XS001 xs001 = mXsService.GetSalesOrderNote(id);
        XS002[] xs002s = mXsService.GetSalesOrderNoteProduct(id);
        ObjectMapper mapper = new ObjectMapper();
        if (xs002s.length > 0) {
            System.out.println("LoadDetailFromSalesOrder(): amount = " + xs002s.length);
            CG002[] cg002s = new CG002[xs002s.length];
            for (int i=0;i<xs002s.length;i++) {
                cg002s[i] = new CG002();
                cg002s[i].setProduct_id(xs002s[i].getProduct_id());
                cg002s[i].setAmount(xs002s[i].getAmount());
                cg002s[i].setUnit_price(xs002s[i].getUnit_price());
                cg002s[i].setBalance(xs002s[i].getBalance());
                cg002s[i].setBarcode(xs002s[i].getBarcode());
                cg002s[i].setState(xs002s[i].getState());
                cg002s[i].setComment(xs002s[i].getComment());
                cg002s[i].setRepository_id(xs001.getRepository_id());
            }
            response.getWriter().write(mapper.writeValueAsString(cg002s));
        }
        response.getWriter().close();
    }

    @RequestMapping(value = "/SubmitPurchaseNote", method = {RequestMethod.POST})
    @ResponseBody
    public RespCode SubmitPurchaseNote(@RequestBody ReqFormGrid<CG001, CG002> purchaseOrderNote) {
        CG001 cg001 = purchaseOrderNote.getForm();
        ArrayList<CG002> cg002s = purchaseOrderNote.getGrid();
        RespCode code = new RespCode();
        cg001.setNote_status(0);
        boolean ret;
        String purchase_note_id = cg001.getPurchase_note_id();
        if (purchase_note_id == null || purchase_note_id.equals("")) {
            purchase_note_id = generatePurchaseNoteId();
            cg001.setPurchase_note_id(purchase_note_id);
            for (CG002 one:cg002s) {
                one.setPurchase_note_id(purchase_note_id);
            }
            System.out.println("SubmitPurchaseNote(): to save");
            ret = mCgService.savePurchaseNote(cg001, cg002s);
        }
        else {
            System.out.println("SubmitPurchaseNote(): to update");
            ret = mCgService.updatePurchaseNote(cg001, cg002s);
        }
        if (ret) {
            String sales_order_note_id = cg001.getSales_order_note_id();
            HashMap<String, Object> param = new HashMap<>();
            param.put("sales_order_note_id", sales_order_note_id);
            param.put("note_status", 1);
            System.out.println("SubmitPurchaseNote(): update xs001 with " + param);
            if (mXsService.UpdateSalesOrderStatus(param) <= 0) {
                System.out.println("SubmitPurchaseNote(): update sales order's status failed.");
            }
            code.setCode(1);
        }
        else {
            System.out.println("SubmitPurchaseNote(): saving failed ");
            code.setCode(0);
        }
        return code;
    }

    @RequestMapping(value = "/UpdatePurchaseNote", method = {RequestMethod.POST})
    @ResponseBody
    public RespCode UpdatePurchaseNote(@RequestBody ReqFormGrid<CG001, CG002> purchaseOrderNote) {
        CG001 cg001 = purchaseOrderNote.getForm();
        ArrayList<CG002> cg002s = purchaseOrderNote.getGrid();
        System.out.println("UpdatePurchaseNote(): save cg001");
        RespCode code = new RespCode();
        if (mCgService.updatePurchaseNote(cg001, cg002s)) {
            code.setCode(1);
        }
        else {
            System.out.println("UpdatePurchaseNote(): CG001 insert failed ");
            code.setCode(0);
        }
        return code;
    }

    @RequestMapping(value = "/GetPurchaseNoteInApproval", method = {RequestMethod.POST})
    @ResponseBody
    public ArrayList<RespPurchaseNoteId> GetPurchaseNoteInApproval() {
        System.out.println("GetPurchaseNoteInApproval come in");

        ArrayList<String> results = mCgService.GetPurchaseNoteInApproval();
        System.out.println(results);
        ArrayList<RespPurchaseNoteId> NoteIdList = new ArrayList<>();

        for (String result : results) {
            RespPurchaseNoteId respSalesOrderNote = new RespPurchaseNoteId();
            respSalesOrderNote.setPurchase_note_id(result);
            NoteIdList.add(respSalesOrderNote);
        }

        return NoteIdList;
    }
}
