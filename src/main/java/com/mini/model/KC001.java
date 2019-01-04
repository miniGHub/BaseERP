package com.mini.model;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Field;
import java.util.Date;

public class KC001 {
    private String  product_id;
    private String  repository_id;
    private Integer amount;
    private Integer freeuse1;
    private String  freeuse2;
    private Date    freeuse3;

    public KC001() {

    }

    public KC001(JSONObject json) {
        Field[] members = this.getClass().getDeclaredFields();
        for (Field item : members) {
            if (json.containsKey(item.getName())){
                item.setAccessible(true);
                try {
                    if (item.getType() == java.lang.String.class) {
                        item.set(this, json.getString(item.getName()));
                    }
                    else if (item.getType() == java.util.Date.class) {
                        item.set(this, json.getDate(item.getName()));
                    }
                    else if (item.getType() == java.lang.Integer.class) {
                        item.set(this, json.getInteger(item.getName()));
                    }
                    else if (item.getType() == java.lang.Double.class) {
                        item.set(this, json.getDouble(item.getName()));
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                item.setAccessible(false);
            }
        }
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getRepository_id() {
        return repository_id;
    }

    public void setRepository_id(String repository_id) {
        this.repository_id = repository_id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getFreeuse1() {
        return freeuse1;
    }

    public void setFreeuse1(Integer freeuse1) {
        this.freeuse1 = freeuse1;
    }

    public String getFreeuse2() {
        return freeuse2;
    }

    public void setFreeuse2(String freeuse2) {
        this.freeuse2 = freeuse2;
    }

    public Date getFreeuse3() {
        return freeuse3;
    }

    public void setFreeuse3(Date freeuse3) {
        this.freeuse3 = freeuse3;
    }
}
