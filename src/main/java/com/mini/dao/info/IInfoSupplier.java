package com.mini.dao.info;

import com.mini.model.info.INFO_SUPPLIER;

public interface IInfoSupplier {
    INFO_SUPPLIER SelectAll();
    INFO_SUPPLIER SelectSupplierInfo(String supplierId);
}
