package com.mini.dao.info;

import com.mini.model.info.INFO_CLIENT;

public interface IInfoClient {
    public INFO_CLIENT SelectAll();
    public INFO_CLIENT SelectClientInfo(String clientId);
}
