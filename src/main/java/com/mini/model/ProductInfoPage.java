package com.mini.model;

public class ProductInfoPage {
    private String product_id;
    private int product_type;
    private String product_dic_name;
    private String product_name;
    private String barcode;
    private int state;

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public int getProduct_type() {
        return product_type;
    }

    public void setProduct_type(int product_type) {
        this.product_type = product_type;
    }

    public String getProduct_dic_name() {
        return product_dic_name;
    }

    public void setProduct_dic_name(String product_dic_name) {
        this.product_dic_name = product_dic_name;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
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

}
