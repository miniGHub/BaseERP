package com.mini.service.impl;

import com.mini.dao.xs.IXs001;
import com.mini.dao.xs.IXs002;
import com.mini.dao.xs.IXs003;
import com.mini.dao.xs.IXs004;
import com.mini.model.request.ReqSalesNote;
import com.mini.model.request.ReqSalesOrderNote;
import com.mini.model.xs.XS001;
import com.mini.model.xs.XS002;
import com.mini.service.IXsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;

@Service("XsService")
public class XsServiceImpl implements IXsService {

    @Resource
    private IXs001 mXs001;

    @Resource
    private IXs002 mXs002;

    @Resource
    private IXs003 mXs003;

    @Resource
    private IXs004 mXs004;

    @Override
    public ArrayList<String> GetSalesOrderNoteApprovaling() {
        return mXs001.SelectSalesOrderNoteApprovaling();
    }
    @Override
    public XS001 GetSalesOrderNote(String salesOrderNoteId) {
        return mXs001.SelectSalesOrderNoteDetail(salesOrderNoteId);
    }

    @Override
    public XS002[] GetSalesOrderNoteProduct(String salesOrderNoteId) {
        return mXs002.SelectSalesOrderNoteProductDetail(salesOrderNoteId);
    }

    @Override
    public boolean SaveSalesOrderNote(ReqSalesOrderNote reqSalesOrderNote) {
        mXs001.InsertSalesOrderNoteDetail(reqSalesOrderNote.getForm());
        if (reqSalesOrderNote.getGrid().size() != 0) {
            for(int i = 0; i < reqSalesOrderNote.getGrid().size(); i++) {
                reqSalesOrderNote.getGrid().get(i).setSales_order_note_id(reqSalesOrderNote.getForm().getSales_order_note_id());
            }
            mXs002.InsertSalesOrderNoteProductDetail(reqSalesOrderNote.getGrid());
        } else {
            System.out.println("ReqSalesOrderNote Grid is null!");
        }
        return true;
    }
    @Override
    public boolean SaveSalesNote(ReqSalesNote salesNote){
        mXs003.InsertSalesNoteDetail(salesNote.getForm());
        if (salesNote.getGrid().size() != 0) {
            for(int i = 0; i < salesNote.getGrid().size(); i++) {
                salesNote.getGrid().get(i).setSales_note_id(salesNote.getForm().getSales_note_id());
            }
            mXs004.InsertSalesNoteProductDetail(salesNote.getGrid());
        } else {
            System.out.println("SalesNote Grid is null!");
        }
        return true;
    }
    @Override
    public int UpdateSalesOrderStatus(HashMap<String, Object> param) {
        return mXs001.UpdateSalesOrderStatus(param);
    }
    @Override
    public int countTodayItems(String id_prefix) {
        return mXs003.countSalesNoteIdLike(id_prefix);
    }
}
