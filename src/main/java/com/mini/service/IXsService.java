package com.mini.service;

import com.mini.model.request.ReqSalesOrderNote;
import com.mini.model.xs.XS001;
import com.mini.model.xs.XS002;

import java.util.ArrayList;
import java.util.HashMap;

public interface IXsService {
    ArrayList<String> GetSalesOrderNoteApprovaling();
    XS001 GetSalesOrderNote(String salesOrderNoteId);
    XS002[] GetSalesOrderNoteProduct(String salesOrderNoteId);
    boolean SaveSalesOrderNote(ReqSalesOrderNote reqSalesOrderNote);
    int UpdateSalesOrderStatus(HashMap<String, Object> param);
}
