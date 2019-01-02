package com.mini.model;

import java.util.Date;

public class KC003 {
    private String  product_id;
    private String  respority_id;
    private Date    out_date;
    private int     amount;
    private String  sales_note_id;
    private String  purchase_return_note_id;
    private String  sales_exchange_note_id;
    private String  purchase_exchange_note_id;
    private int     freeuse1;
    private String  freeuse2;
    private Date    freeuse3;

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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
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

    public int getFreeuse1() {
        return freeuse1;
    }

    public void setFreeuse1(int freeuse1) {
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
