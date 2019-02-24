package com.mini.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mini.model.PurchaseOrderNote;
import com.mini.model.ResponseCode;
import com.mini.model.cg.CG001;
import com.mini.model.cg.CG002;
import com.mini.model.xs.XS001;
import com.mini.model.xs.XS002;
import com.mini.service.*;
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
import java.util.*;

@Controller
@RequestMapping("/cg")
public class CgController {
    @Resource
    private ICG001Service mCG001Service;

    @Resource
    private ICG002Service mCG002Service;

    @Resource
    private IXsService mXsService;

    private String generatePurchaseNoteId() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String id_prefix = "JH-"+df.format(new Date())+"-";
        int amount = mCG001Service.countTodayItems(id_prefix+"%");
        return String.format("%s%04d", id_prefix, amount+1);
    }

    @RequestMapping("/LoadBaseFromSalesOrder")
    public void LoadBaseFromSalesOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String purchase_note_id = generatePurchaseNoteId();
        String id = request.getParameter("Sales_order_note_id");
        System.out.println("LoadBaseFromSalesOrder(): " + id);
        XS001 xs001 = mXsService.GetSalesOrderNote(id);
        CG001 cg001 = new CG001();
        cg001.setPurchase_note_id(purchase_note_id);
        cg001.setEntry_date(new Date());
        cg001.setSales_order_note_id(xs001.getSales_order_note_id());
        cg001.setRepository_id(xs001.getRepository_id());
        cg001.setDepart_id(xs001.getDepart_id());
        cg001.setRemark(xs001.getRemark());
        cg001.setAddition(xs001.getAddition());
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(cg001));
        response.getWriter().close();
    }

    @RequestMapping("/LoadDetailFromSalesOrder")
    public void LoadDetailFromSalesOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String purchase_note_id = generatePurchaseNoteId();
        String id = request.getParameter("Sales_order_note_id");
        System.out.println("LoadDetailFromSalesOrder(): " + id);
        XS002[] xs002s = mXsService.GetSalesOrderNoteProduct(id);
        ObjectMapper mapper = new ObjectMapper();
        if (xs002s.length > 0) {
            System.out.println("LoadDetailFromSalesOrder(): amount = " + xs002s.length);
            CG002[] cg002s = new CG002[xs002s.length];
            for (int i=0;i<xs002s.length;i++) {
                cg002s[i] = new CG002();
                cg002s[i].setPurchase_note_id(purchase_note_id);
                cg002s[i].setProduct_id(xs002s[i].getProduct_id());
                cg002s[i].setAmount(xs002s[i].getAmount());
                cg002s[i].setUnit_price(xs002s[i].getUnit_price());
                cg002s[i].setBalance(xs002s[i].getBalance());
                cg002s[i].setBarcode(xs002s[i].getBarcode());
                cg002s[i].setState(xs002s[i].getState());
                cg002s[i].setComment(xs002s[i].getComment());
            }
            response.getWriter().write(mapper.writeValueAsString(cg002s));
        }
        response.getWriter().close();
    }

    @RequestMapping(value = "/SubmitPurchaseNote", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseCode SubmitPurchaseNote(@RequestBody PurchaseOrderNote purchaseOrderNote) {
        CG001 cg001 = purchaseOrderNote.getForm();
        List<CG002> cg002s = purchaseOrderNote.getGrid();
        System.out.println("SubmitPurchaseNote(): save cg001");
        if (mCG001Service.insertCG001(cg001) == 1) {
            System.out.println("SubmitPurchaseNote(): save cg002 amount "+cg002s.size());
            if (mCG002Service.insertCG002(cg002s) == cg002s.size()) {
                String sales_order_note_id = cg001.getSales_order_note_id();
                HashMap<String, Object> param = new HashMap<>();
                param.put("sales_order_note_id", sales_order_note_id);
                param.put("note_status", 1);
                System.out.println("SubmitPurchaseNote(): update xs001 with " + param);
                if (mXsService.UpdateSalesOrderStatus(param) <= 0) {
                    System.out.println("SubmitPurchaseNote(): update sales order's status failed.");
                }
            }
            else {
                System.out.println("SubmitPurchaseNote(): CG002 insert failed");
            }
        }
        else {
            System.out.println("SubmitPurchaseNote(): CG001 insert failed ");
        }
        ResponseCode code = new ResponseCode();
        code.setCode(1);
        return code;
    }
}
