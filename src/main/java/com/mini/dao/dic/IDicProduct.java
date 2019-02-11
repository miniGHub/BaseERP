package com.mini.dao.dic;

import com.mini.model.dic.DIC_PRODUCT;

public interface IDicProduct {
    public DIC_PRODUCT SelectAll();
    public String SelectName(int produtcType);
}
