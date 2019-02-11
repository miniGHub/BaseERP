package com.mini.dao.xs;

import com.mini.model.xs.XS001;
import org.apache.ibatis.annotations.Param;

public interface IXs001 {
    public XS001 SelectSalesOrderNoteDetail(String salesOrderNoteId);
    public void InsertSalesOrderNoteDetail(@Param("xs001")XS001 xs001);
}
