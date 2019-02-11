package com.mini.dao.info;

import com.mini.model.info.INFO_PRODUCT;

public interface IInfoProduct {
    public INFO_PRODUCT SelectAll();
    public INFO_PRODUCT SelectProductInfo(String productId);
}
