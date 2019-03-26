package com.mini.dao.info;

import com.mini.model.ProductInfoPage;
import com.mini.model.info.INFO_PRODUCT;

import java.util.ArrayList;

public interface IInfoProduct {
    public INFO_PRODUCT SelectAll();
    public INFO_PRODUCT SelectProductInfo(String productId);
    ArrayList<ProductInfoPage> SelectAllProductInfo();
    void InsertProductInfo(INFO_PRODUCT productInfo);
    void UpdateProductInfo(INFO_PRODUCT productInfo);
    void DeleteProductInfo(ArrayList<String> listId);
    int CountProductInfo(String id);
    String SelectMaxId();
}
