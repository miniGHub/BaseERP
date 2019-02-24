package com.mini.dao.xs;

import com.mini.model.xs.XS002;

import java.util.List;

public interface IXs002 {
    public XS002[] SelectSalesOrderNoteProductDetail(String salesOrderNoteId);
    public void InsertSalesOrderNoteProductDetail(List<XS002> arrayXS002);
}
