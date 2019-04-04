package com.mini.dao.dic;

import com.mini.model.db.dic.DIC_PRODUCT;

import java.util.ArrayList;

public interface IDicProduct {
    ArrayList<DIC_PRODUCT> SelectAllProduct();
    DIC_PRODUCT SelectProduct(int productType);
    void InsertProduct(ArrayList<DIC_PRODUCT> product);
    void DeleteProduct();
}
