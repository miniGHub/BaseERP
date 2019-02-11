package com.mini.service.impl;

import com.mini.dao.xs.IXs001;
import com.mini.dao.xs.IXs002;
import com.mini.model.SalesOrderNote;
import com.mini.model.xs.XS001;
import com.mini.service.IXsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("XsService")
public class XsServiceImpl implements IXsService {

    @Resource
    private IXs001 mXs001;

    @Resource
    private IXs002 mXs002;

    @Override
    public XS001 GetSalesOrderNote(String salesOrderNoteId) {
        return mXs001.SelectSalesOrderNoteDetail(salesOrderNoteId);
    }

    @Override
    public List GetSalesOrderNoteProduct(String salesOrderNoteId) {
        return null;
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


}
