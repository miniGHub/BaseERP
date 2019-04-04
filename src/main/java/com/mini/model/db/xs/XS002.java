package com.mini.model.db.xs;

import java.util.Date;

public class XS002 {
    private String sales_order_note_id;
    private String batch_id;
    private String product_id;
    private String client_id;
    private int amount;
    private double unit_price;
    private double balance;
    private double discount;
    private double discount_unit_price;
    private double discount_balance;
    private double rate;
    private double rate_balance;
    private String barcode;
    private int state;
    private String comment;
    private int freeuse1;
    private String freeuse2;
    private Date freeuse3;

    public String getSales_order_note_id() {
        return sales_order_note_id;
    }

    public void setSales_order_note_id(String sales_order_note_id) {
        this.sales_order_note_id = sales_order_note_id;
    }

    public String getBatch_id() {
        return batch_id;
    }

    public void setBatch_id(String batch_id) {
        this.batch_id = batch_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
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

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getDiscount_unit_price() {
        return discount_unit_price;
    }

    public void setDiscount_unit_price(double discount_unit_price) {
        this.discount_unit_price = discount_unit_price;
    }

    public double getDiscount_balance() {
        return discount_balance;
    }

    public void setDiscount_balance(double discount_balance) {
        this.discount_balance = discount_balance;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getRate_balance() {
        return rate_balance;
    }

    public void setRate_balance(double rate_balance) {
        this.rate_balance = rate_balance;
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
