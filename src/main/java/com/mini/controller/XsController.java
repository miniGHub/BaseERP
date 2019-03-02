package com.mini.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mini.model.request.ReqSalesOrderNote;
import com.mini.model.response.RespSalesOrderNote;
import com.mini.model.response.ResponseCode;
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
import java.util.ArrayList;

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
}
