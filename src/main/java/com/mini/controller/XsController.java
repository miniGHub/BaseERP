package com.mini.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mini.model.ResponseCode;
import com.mini.model.SalesOrderNote;
import com.mini.model.UnsolvedSalesOrder;
import com.mini.model.xs.XS001;
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

@Controller
@RequestMapping("/xs")
public class XsController {

    @Resource
    private IXsService mXsService;

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

    @RequestMapping("/UnsolvedSalesOrder")
    public void UnsolvedSalesOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        System.out.println("UnsolvedSalesOrder() come in");
        UnsolvedSalesOrder[] ids = mXsService.GetUnsolvedSalesOrder();
        System.out.println("get size: " + ids.length);
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(ids));
        response.getWriter().close();
    }

    @RequestMapping(value = "/SubmitSalesOrderNote", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseCode SubmitSalesOrderNote(@RequestBody SalesOrderNote salesOrderNote){
        System.out.println("SubmitSalesOrderNote");
        System.out.println("entry_date:" + salesOrderNote.getForm().getEntry_date()
                + ",Sales_order_note_id:" + salesOrderNote.getForm().getSales_order_note_id()
                + ",getClient_id:" + salesOrderNote.getForm().getClient_id()
                + ",getRepository_id:" + salesOrderNote.getForm().getRepository_id()
                + ",getOperator_id:" + salesOrderNote.getForm().getOperator_id()
                + ",getDelivery_date:" + salesOrderNote.getForm().getDelivery_date()
                + ",getRemark:" + salesOrderNote.getForm().getRemark()
                + ",getAddition:" + salesOrderNote.getForm().getAddition()
        );
        System.out.println("array:" + salesOrderNote.getGrid().size());

        for(int i = 0; i < salesOrderNote.getGrid().size(); i++) {
            System.out.println("getBatch_id:" + salesOrderNote.getGrid().get(i).getBatch_id());
            System.out.println("getProduct_id:" + salesOrderNote.getGrid().get(i).getProduct_id());
            System.out.println("getClient_id:" + salesOrderNote.getGrid().get(i).getClient_id());
            System.out.println("getAmount:" + salesOrderNote.getGrid().get(i).getAmount());
            System.out.println("getUnit_price:" + salesOrderNote.getGrid().get(i).getUnit_price());
            System.out.println("getBalance:" + salesOrderNote.getGrid().get(i).getBalance());
            System.out.println("getDiscount:" + salesOrderNote.getGrid().get(i).getDiscount());
            System.out.println("getDiscount_unit_price:" + salesOrderNote.getGrid().get(i).getDiscount_unit_price());
            System.out.println("getDiscount_balance:" + salesOrderNote.getGrid().get(i).getDiscount_balance());
            System.out.println("getRate:" + salesOrderNote.getGrid().get(i).getRate());
            System.out.println("getRate_balance:" + salesOrderNote.getGrid().get(i).getRate_balance());
            System.out.println("getBarcode:" + salesOrderNote.getGrid().get(i).getBarcode());
            System.out.println("getState:" + salesOrderNote.getGrid().get(i).getState());
            System.out.println("getComment:" + salesOrderNote.getGrid().get(i).getComment());
        }

        mXsService.SaveSalesOrderNote(salesOrderNote);

        ResponseCode code = new ResponseCode();
        code.setCode(1);

        return code;
    }
}
