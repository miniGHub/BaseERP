package com.mini.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mini.model.request.ReqSalesNote;
import com.mini.model.request.ReqSalesOrderNote;
import com.mini.model.response.RespSalesOrderNote;
import com.mini.model.response.ResponseCode;
import com.mini.model.xs.XS001;
import com.mini.model.xs.XS002;
import com.mini.model.xs.XS003;
import com.mini.model.xs.XS004;
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

@Controller
@RequestMapping("/xs")
public class XsController {

    @Resource
    private IXsService mXsService;
    @Resource
    private ICgService mCgService;

    @RequestMapping("/SalesOrderNote")
    public void GetSaleOrderNote(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String id = request.getParameter("Sales_order_note_id");
        XS001 xs001 = mXsService.GetSalesOrderNote(id);
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(xs001));
        response.getWriter().close();
    }

    @RequestMapping(value = "/GetSalesOrderNoteApprovaling", method = {RequestMethod.POST})
    @ResponseBody
    public ArrayList<RespSalesOrderNote> GetSalesOrderNoteApprovaling() {
        System.out.println("GetSalesOrderNoteApprovaling come in");

        ArrayList<String> arraySalesOrderNote = mXsService.GetSalesOrderNoteApprovaling();
        ArrayList<RespSalesOrderNote> arrayRespSalesOrderNote = new ArrayList<RespSalesOrderNote>();

        for (int i = 0; i < arraySalesOrderNote.size(); i++) {
            RespSalesOrderNote respSalesOrderNote = new RespSalesOrderNote();
            respSalesOrderNote.setSales_order_note_id(arraySalesOrderNote.get(i));
            arrayRespSalesOrderNote.add(respSalesOrderNote);
        }

        return arrayRespSalesOrderNote;
    }

    @RequestMapping(value = "/SubmitSalesNote", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseCode SubmitSalesNote(@RequestBody ReqSalesNote salesNote){
        System.out.println("SubmitSalesNote");
        System.out.println("entry_date:" + salesNote.getForm().getEntry_date()
                + ",Sales_order_note_id:" + salesNote.getForm().getSales_order_note_id()
                + ",getClient_id:" + salesNote.getForm().getClient_id()
                + ",getCollect_id:" + salesNote.getForm().getCollect_id()
                + ",getOperator_id:" + salesNote.getForm().getOperator_id()
                + ",getDiscount_balance:" + salesNote.getForm().getDiscount_balance()
                + ",getRemark:" + salesNote.getForm().getRemark()
                + ",getLend_sales_note_id:" + salesNote.getForm().getLend_sales_note_id()
                + ",getSupplier_note_id:" + salesNote.getForm().getSupplier_note_id()
                + ",getSales_note_id:" + salesNote.getForm().getSales_note_id()
                + ",getNote_status:" + salesNote.getForm().getNote_status()
                + ",getCollect_date:" + salesNote.getForm().getCollect_date()
                + ",getRespority_id:" + salesNote.getForm().getRespority_id()
                + ",getDepart_id:" + salesNote.getForm().getDepart_id()
                + ",getCollect_balance:" + salesNote.getForm().getCollect_balance()
                + ",getAddition:" + salesNote.getForm().getAddition()
        );
        System.out.println("array:" + salesNote.getGrid().size());

        for(int i = 0; i < salesNote.getGrid().size(); i++) {
            System.out.println("getSales_note_id:" + salesNote.getGrid().get(i).getSales_note_id());
            System.out.println("getBarcode:" + salesNote.getGrid().get(i).getBarcode());
            System.out.println("getAmount:" + salesNote.getGrid().get(i).getAmount());
            System.out.println("getRespority_id:" + salesNote.getGrid().get(i).getRespority_id());
            System.out.println("getAmount:" + salesNote.getGrid().get(i).getAmount());
            System.out.println("getUnit_price:" + salesNote.getGrid().get(i).getUnit_price());
            System.out.println("getBalance:" + salesNote.getGrid().get(i).getBalance());
            System.out.println("getDiscount_unit_price:" + salesNote.getGrid().get(i).getDiscount_unit_price());
            System.out.println("getDiscount_balance:" + salesNote.getGrid().get(i).getDiscount_balance());
            System.out.println("getState:" + salesNote.getGrid().get(i).getState());
            System.out.println("getComment:" + salesNote.getGrid().get(i).getComment());
            System.out.println("getInvoice_balance:" + salesNote.getGrid().get(i).getInvoice_balance());
        }

        mXsService.SaveSalesNote(salesNote);

        ResponseCode code = new ResponseCode();
        code.setCode(1);

        return code;
    }

    @RequestMapping(value = "/SubmitSalesOrderNote", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseCode SubmitSalesOrderNote(@RequestBody ReqSalesOrderNote reqSalesOrderNote){
        System.out.println("SubmitSalesOrderNote");
        System.out.println("entry_date:" + reqSalesOrderNote.getForm().getEntry_date()
                + ",Sales_order_note_id:" + reqSalesOrderNote.getForm().getSales_order_note_id()
                + ",getClient_id:" + reqSalesOrderNote.getForm().getClient_id()
                + ",getRepository_id:" + reqSalesOrderNote.getForm().getRepository_id()
                + ",getOperator_id:" + reqSalesOrderNote.getForm().getOperator_id()
                + ",getDelivery_date:" + reqSalesOrderNote.getForm().getDelivery_date()
                + ",getRemark:" + reqSalesOrderNote.getForm().getRemark()
                + ",getAddition:" + reqSalesOrderNote.getForm().getAddition()
        );
        System.out.println("array:" + reqSalesOrderNote.getGrid().size());

        for(int i = 0; i < reqSalesOrderNote.getGrid().size(); i++) {
            System.out.println("getBatch_id:" + reqSalesOrderNote.getGrid().get(i).getBatch_id());
            System.out.println("getProduct_id:" + reqSalesOrderNote.getGrid().get(i).getProduct_id());
            System.out.println("getClient_id:" + reqSalesOrderNote.getGrid().get(i).getClient_id());
            System.out.println("getAmount:" + reqSalesOrderNote.getGrid().get(i).getAmount());
            System.out.println("getUnit_price:" + reqSalesOrderNote.getGrid().get(i).getUnit_price());
            System.out.println("getBalance:" + reqSalesOrderNote.getGrid().get(i).getBalance());
            System.out.println("getDiscount:" + reqSalesOrderNote.getGrid().get(i).getDiscount());
            System.out.println("getDiscount_unit_price:" + reqSalesOrderNote.getGrid().get(i).getDiscount_unit_price());
            System.out.println("getDiscount_balance:" + reqSalesOrderNote.getGrid().get(i).getDiscount_balance());
            System.out.println("getRate:" + reqSalesOrderNote.getGrid().get(i).getRate());
            System.out.println("getRate_balance:" + reqSalesOrderNote.getGrid().get(i).getRate_balance());
            System.out.println("getBarcode:" + reqSalesOrderNote.getGrid().get(i).getBarcode());
            System.out.println("getState:" + reqSalesOrderNote.getGrid().get(i).getState());
            System.out.println("getComment:" + reqSalesOrderNote.getGrid().get(i).getComment());
        }

        mXsService.SaveSalesOrderNote(reqSalesOrderNote);

        ResponseCode code = new ResponseCode();
        code.setCode(1);

        return code;
    }
    private String generateSalesNoteId() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String id_prefix = "XS-"+df.format(new Date())+"-";
        int amount = mXsService.countTodayItems(id_prefix+"%");
        return String.format("%s%04d", id_prefix, amount+1);
    }

    @RequestMapping("/LoadBaseFromSalesOrderandPurchaseNote")
    public void LoadBaseFromSalesOrderandPurchaseNote(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String sales_note_id = generateSalesNoteId();
        String id = request.getParameter("Sales_order_note_id");
        String purchaseid = request.getParameter("Purchase_note_id");
        System.out.println("LoadBaseFromSalesOrderandPurchaseNote(): " + id +",purchaseid ="+purchaseid);
        XS001 xs001 = mXsService.GetSalesOrderNote(id);
        //CG001 cg001 = mCgService.getPurchaseNote(purchaseid);
        XS003 xs003 = new XS003();
        xs003.setSales_note_id(sales_note_id);
        xs003.setSales_order_note_id(xs001.getSales_order_note_id());
        xs003.setRespority_id(xs001.getRepository_id());
        xs003.setEntry_date(xs001.getEntry_date());

        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(xs003));
        response.getWriter().close();
    }
    @RequestMapping("/LoadDetailFromSalesOrderandPurchaseNote")
    public void LoadDetailFromSalesOrderandPurchaseNote(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String sales_note_id = generateSalesNoteId();
        String id = request.getParameter("Sales_order_note_id");
        String purchaseid = request.getParameter("Purchase_note_id");
        System.out.println("LoadDetailFromSalesOrderandPurchaseNote(): " + id +",purchaseid ="+purchaseid);
        XS002[] xs002s = mXsService.GetSalesOrderNoteProduct(id);
        //CG002[] cg002s = mCgService.GetPurchaseNoteProduct(purchaseid);
        ObjectMapper mapper = new ObjectMapper();
        if (xs002s.length > 0) {
            System.out.println("LoadDetailFromSalesOrderandPurchaseNote(): amount = " + xs002s.length);
            XS004[] xs004s = new XS004[xs002s.length];
            for (int i=0;i<xs002s.length;i++) {
                xs004s[i] = new XS004();
                xs004s[i].setSales_note_id(sales_note_id);
                xs004s[i].setProduct_id(xs002s[i].getProduct_id());
                xs004s[i].setAmount(xs002s[i].getAmount());
                xs004s[i].setUnit_price(xs002s[i].getUnit_price());
                xs004s[i].setBalance(xs002s[i].getBalance());
                xs004s[i].setDiscount_balance(xs002s[i].getDiscount_balance());
                xs004s[i].setDiscount_unit_price(xs002s[i].getDiscount_unit_price());
            }
            response.getWriter().write(mapper.writeValueAsString(xs004s));
        }
        response.getWriter().close();
    }
}
