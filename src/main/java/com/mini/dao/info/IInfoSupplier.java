package com.mini.dao.info;

import com.mini.model.info.INFO_SUPPLIER;

public interface IInfoSupplier {
    public INFO_SUPPLIER SelectAll();
    public INFO_SUPPLIER SelectSupplierInfo(String supplierId);
}
