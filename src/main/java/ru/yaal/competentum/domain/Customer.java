package ru.yaal.competentum.domain;

import java.util.List;

public abstract class Customer {
    private int products;

    public Customer(int products) {
        if (products < 0) {
            throw new IllegalArgumentException("Negative product count: " + products);
        }
        this.products = products;
    }

    public abstract Cash chooseCash(List<Cash> cashes);

    public abstract String getCode();

    public int getProducts() {
        return products;
    }

    public void setProducts(int products) {
        this.products = products;
    }
}