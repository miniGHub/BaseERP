package com.mini.dao.xs;

import com.mini.model.UnsolvedSalesOrder;
import com.mini.model.xs.XS001;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.Map;

public interface IXs001 {
    public UnsolvedSalesOrder[] SelectUnsolvedSalesOrder();
    public XS001 SelectSalesOrderNoteDetail(String salesOrderNoteId);
    public void InsertSalesOrderNoteDetail(@Param("xs001")XS001 xs001);
    public int UpdateSalesOrderStatus(HashMap<String, Object> param);
}
