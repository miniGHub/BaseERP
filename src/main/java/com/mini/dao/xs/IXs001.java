package com.mini.dao.xs;

import com.mini.model.db.xs.XS001;

import java.util.ArrayList;
import java.util.HashMap;

public interface IXs001 {
    XS001 SelectSalesOrderNoteDetail(String salesOrderNoteId);
    ArrayList<String> SelectSalesOrderNoteApprovaling();
    void InsertSalesOrderNoteDetail(XS001 xs001);
    int UpdateSalesOrderStatus(HashMap<String, Object> param);
}
