package com.mini.dao.xs;

import com.mini.model.xs.XS002;

import java.util.ArrayList;

public interface IXs002 {
    XS002[] SelectSalesOrderNoteProductDetail(String salesOrderNoteId);
    void InsertSalesOrderNoteProductDetail(ArrayList<XS002> xs002);
}
