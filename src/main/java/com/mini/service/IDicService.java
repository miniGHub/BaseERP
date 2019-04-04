package com.mini.service;

import com.mini.model.db.dic.DIC_DEPART;
import com.mini.model.db.dic.DIC_PRODUCT;
import com.mini.model.db.dic.DIC_REPOSITORY;
import com.mini.model.db.dic.DIC_ROLE;

import java.util.ArrayList;

public interface IDicService {
    boolean SaveRole(ArrayList<DIC_ROLE> role);
    DIC_ROLE GetRole(int role_id);
    ArrayList<DIC_ROLE> GetAllRole();

    boolean SaveDepart(ArrayList<DIC_DEPART> depart);
    DIC_DEPART GetDepart(int depart_id);
    ArrayList<DIC_DEPART> GetAllDepart();

    boolean SaveProduct(ArrayList<DIC_PRODUCT> product);
    DIC_PRODUCT GetProduct(int productType);
    ArrayList<DIC_PRODUCT> GetAllProduct();

    boolean SaveRepository(ArrayList<DIC_REPOSITORY> repository);
    DIC_REPOSITORY GetRepository(int repositoryType);
    ArrayList<DIC_REPOSITORY> GetAllRepository();
}
