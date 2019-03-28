package com.mini.dao.info;

import com.mini.model.info.INFO_CLIENT;

import java.util.ArrayList;

public interface IInfoClient {
    ArrayList<INFO_CLIENT> SelectAll();
    int AddClientInfo(INFO_CLIENT clientInfo);
    int UpdateClientInfo(INFO_CLIENT clientInfo);
    int DeleteClientInfo(ArrayList<String> idList);
    int DeleteAll();
    int SaveClientInfoList(ArrayList<INFO_CLIENT> clientList);
    INFO_CLIENT SelectClientInfo(String clientId);
}
