package com.mini.service;

import com.mini.model.SalesOrderNote;
import com.mini.model.UnsolvedSalesOrder;
import com.mini.model.xs.XS001;
import com.mini.model.xs.XS002;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IXsService {
    UnsolvedSalesOrder[] GetUnsolvedSalesOrder();
    XS001 GetSalesOrderNote(String salesOrderNoteId);
    XS002[] GetSalesOrderNoteProduct(String salesOrderNoteId);
    boolean SaveSalesOrderNote(SalesOrderNote salesOrderNote);
    int UpdateSalesOrderStatus(HashMap<String, Object> param);
}
