package com.mini.dao.info;

import com.mini.model.info.INFO_SUPPLIER;

import java.util.ArrayList;

public interface IInfoSupplier {
    ArrayList<INFO_SUPPLIER> SelectAllSupplier();
    INFO_SUPPLIER SelectSupplier(String supplierId);
    void InsertSupplier(ArrayList<INFO_SUPPLIER> supplier);
    void DeleteSupplier();
}
