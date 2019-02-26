package com.mini.service.impl;

import com.mini.dao.xs.IXs001;
import com.mini.dao.xs.IXs002;
import com.mini.model.SalesOrderNote;
import com.mini.model.UnsolvedSalesOrder;
import com.mini.model.xs.XS001;
import com.mini.model.xs.XS002;
import com.mini.service.IXsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("XsService")
public class XsServiceImpl implements IXsService {

    @Resource
    private IXs001 mXs001;

    @Resource
    private IXs002 mXs002;

    @Override
    public UnsolvedSalesOrder[] GetUnsolvedSalesOrder() {
        return mXs001.SelectUnsolvedSalesOrder();
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
    public boolean SaveSalesOrderNote(SalesOrderNote salesOrderNote) {
        mXs001.InsertSalesOrderNoteDetail(salesOrderNote.getForm());
        if (salesOrderNote.getGrid().size() != 0) {
            for(int i = 0; i < salesOrderNote.getGrid().size(); i++) {
                salesOrderNote.getGrid().get(i).setSales_order_note_id(salesOrderNote.getForm().getSales_order_note_id());
            }
            mXs002.InsertSalesOrderNoteProductDetail(salesOrderNote.getGrid());
        } else {
            System.out.println("SalesOrderNote Grid is null!");
        }
        return true;
    }

    @Override
    public int UpdateSalesOrderStatus(HashMap<String, Object> param) {
        return mXs001.UpdateSalesOrderStatus(param);
    }
}
