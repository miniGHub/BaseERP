package com.mini.model;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Field;
import java.util.Date;

public class KC003 {
    private String  product_id;
    private String  respority_id;
    private Date    out_date;
    private Integer amount;
    private String  sales_note_id;
    private String  purchase_return_note_id;
    private String  sales_exchange_note_id;
    private String  purchase_exchange_note_id;
    private Integer freeuse1;
    private String  freeuse2;
    private Date    freeuse3;

    public KC003() {

    }
    public KC003(JSONObject json) {
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

    public String getRespority_id() {
        return respority_id;
    }

    public void setRespority_id(String respority_id) {
        this.respority_id = respority_id;
    }

    public Date getOut_date() {
        return out_date;
    }

    public void setOut_date(Date out_date) {
        this.out_date = out_date;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getSales_note_id() {
        return sales_note_id;
    }

    public void setSales_note_id(String sales_note_id) {
        this.sales_note_id = sales_note_id;
    }

    public String getPurchase_return_note_id() {
        return purchase_return_note_id;
    }

    public void setPurchase_return_note_id(String purchase_return_note_id) {
        this.purchase_return_note_id = purchase_return_note_id;
    }

    public String getSales_exchange_note_id() {
        return sales_exchange_note_id;
    }

    public void setSales_exchange_note_id(String sales_exchange_note_id) {
        this.sales_exchange_note_id = sales_exchange_note_id;
    }

    public String getPurchase_exchange_note_id() {
        return purchase_exchange_note_id;
    }

    public void setPurchase_exchange_note_id(String purchase_exchange_note_id) {
        this.purchase_exchange_note_id = purchase_exchange_note_id;
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
