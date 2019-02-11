package com.mini.service;

import com.mini.model.SalesOrderNote;
import com.mini.model.xs.XS001;
import com.mini.model.xs.XS002;

import java.util.List;

public interface IXsService {
    XS001 GetSalesOrderNote(String salesOrderNoteId);
    List<XS002> GetSalesOrderNoteProduct(String salesOrderNoteId);
    boolean SaveSalesOrderNote(SalesOrderNote salesOrderNote);
}
