package com.mini.dao.xs;

import com.mini.model.xs.XS001;

import java.util.ArrayList;
import java.util.HashMap;

public interface IXs001 {
    public XS001 SelectSalesOrderNoteDetail(String salesOrderNoteId);
    public ArrayList<String> SelectSalesOrderNoteApprovaling();
    public void InsertSalesOrderNoteDetail(XS001 xs001);
    public int UpdateSalesOrderStatus(HashMap<String, Object> param);
}
