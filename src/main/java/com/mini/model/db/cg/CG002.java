package com.mini.model.db.cg;

import java.util.Date;

public class CG002 {
    private int     purchase_detail_id;
    private String  purchase_note_id;
    private String  product_id;
    private String  repository_id;
    private int     amount;
    private double  unit_price;
    private double  balance;
    private double  invoice_balance;
    private String  barcode;
    private int     state;
    private String  comment;
    private int     freeuse1;
    private String  freeuse2;
    private Date    freeuse3;

    public CG002() {

    }

    public int getPurchase_detail_id() {
        return purchase_detail_id;
    }

    public void setPurchase_detail_id(int purchase_detail_id) {
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getInvoice_balance() {
        return invoice_balance;
    }

    public void setInvoice_balance(double invoice_balance) {
        this.invoice_balance = invoice_balance;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
