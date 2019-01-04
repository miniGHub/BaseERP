package com.mini.model;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Field;
import java.util.Date;

public class CG002 {
    private String  purchase_detail_id;
    private String  purchase_note_id;
    private String  product_id;
    private String  repository_id;
    private Integer amount;
    private Double  unit_price;
    private Double  balance;
    private Double  invoice_balance;
    private String  barcode;
    private Integer state;
    private String  comment;
    private Integer freeuse1;
    private String  freeuse2;
    private Date    freeuse3;

    public CG002() {

    }

    public CG002(JSONObject json) {
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

    public String getPurchase_detail_id() {
        return purchase_detail_id;
    }

    public void setPurchase_detail_id(String purchase_detail_id) {
        this.purchase_detail_id = purchase_detail_id;
    }

    public String getPurchase_note_id() {
        return purchase_note_id;
    }

    public void setPurchase_note_id(String purchase_note_id) {
        this.purchase_note_id = purchase_note_id;
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

    public Double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(Double unit_price) {
        this.unit_price = unit_price;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getInvoice_balance() {
        return invoice_balance;
    }

    public void setInvoice_balance(Double invoice_balance) {
        this.invoice_balance = invoice_balance;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
