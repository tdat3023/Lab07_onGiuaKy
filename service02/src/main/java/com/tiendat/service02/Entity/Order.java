package com.tiendat.service02.Entity;

import java.util.List;

public class Order {
    private int id;
    private List<Object> products;

    public Order() {
    }

    public Order(int orderId) {
        this.id = orderId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Object> getProductss() {
        return products;
    }

    public void setProducts(List<Object> products) {
        this.products = products;
    }
}
