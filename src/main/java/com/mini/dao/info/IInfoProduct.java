package com.mini.dao.info;

import com.mini.model.page.ProductInfoPage;
import com.mini.model.db.info.INFO_PRODUCT;

import java.util.ArrayList;

public interface IInfoProduct {
    ArrayList<ProductInfoPage> SelectAllProductInfo();
    void InsertProductInfo(INFO_PRODUCT productInfo);
    void UpdateProductInfo(INFO_PRODUCT productInfo);
    void DeleteProductInfo(ArrayList<String> listId);
    int CountProductInfo(String id);
    String SelectMaxId();
}
