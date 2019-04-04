package com.mini.service;

import com.mini.model.db.xs.XS001;
import com.mini.model.db.xs.XS002;
import com.mini.model.request.ReqFormGrid;
import com.mini.model.request.ReqSalesNote;

import java.util.ArrayList;
import java.util.HashMap;

public interface IXsService {
    ArrayList<String> GetSalesOrderNoteApprovaling();
    XS001 GetSalesOrderNote(String salesOrderNoteId);
    XS002[] GetSalesOrderNoteProduct(String salesOrderNoteId);
    boolean SaveSalesOrderNote(ReqFormGrid<XS001, XS002> reqSalesOrderNote);
    boolean SaveSalesNote(ReqSalesNote salesNote);
    int UpdateSalesOrderStatus(HashMap<String, Object> param);
    int countTodayItems(String id_prefix);
}
