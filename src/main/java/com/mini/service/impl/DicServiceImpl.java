package com.mini.service.impl;

import com.mini.dao.dic.IDicDepart;
import com.mini.dao.dic.IDicProduct;
import com.mini.dao.dic.IDicRepository;
import com.mini.dao.dic.IDicRole;
import com.mini.model.dic.DIC_DEPART;
import com.mini.model.dic.DIC_PRODUCT;
import com.mini.model.dic.DIC_REPOSITORY;
import com.mini.model.dic.DIC_ROLE;
import com.mini.service.IDicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service("DicService")
public class DicServiceImpl implements IDicService {

    @Resource
    private IDicRole mDicRole;

    @Resource
    private IDicDepart mDicDepart;

    @Resource
    private IDicProduct mDicProduct;

    @Resource
    private IDicRepository mDicRepository;

    @Override
    public boolean SaveRole(ArrayList<DIC_ROLE> role) {
        mDicRole.DeleteRole();
        mDicRole.InsertRole(role);
        return true;
    }

    @Override
    public DIC_ROLE GetRole(int role_id) {
        return mDicRole.SelectRole(role_id);
    }

    @Override
    public ArrayList<DIC_ROLE> GetAllRole() {
        return mDicRole.SelectAllRole();
    }

    @Override
    public boolean SaveDepart(ArrayList<DIC_DEPART> depart) {
        mDicDepart.DeleteDepart();
        mDicDepart.InsertDepart(depart);
        return true;
    }

    @Override
    public DIC_DEPART GetDepart(int depart_id) {
        return mDicDepart.SelectDepart(depart_id);
    }

    @Override
    public ArrayList<DIC_DEPART> GetAllDepart() {
        return mDicDepart.SelectAllDepart();
    }

    @Override
    public boolean SaveProduct(ArrayList<DIC_PRODUCT> product) {
        mDicProduct.DeleteProduct();
        mDicProduct.InsertProduct(product);
        return true;
    }

    @Override
    public DIC_PRODUCT GetProduct(int productType) {
        return mDicProduct.SelectProduct(productType);
    }

    @Override
    public ArrayList<DIC_PRODUCT> GetAllProduct() {
        return mDicProduct.SelectAllProduct();
    }

    @Override
    public boolean SaveRepository(ArrayList<DIC_REPOSITORY> repository) {
        mDicRepository.DeleteRepository();
        mDicRepository.InsertRepository(repository);
        return true;
    }

    @Override
    public DIC_REPOSITORY GetRepository(int repositoryType) {
        return mDicRepository.SelectRepository(repositoryType);
    }

    @Override
    public ArrayList<DIC_REPOSITORY> GetAllRepository() {
        return mDicRepository.SelectAllRepository();
    }
}
