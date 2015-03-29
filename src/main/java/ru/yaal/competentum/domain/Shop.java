package ru.yaal.competentum.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Shop {
    private List<Cash> cashes;

    public Shop(int cashCount) {
        cashes = new ArrayList<>(cashCount);
        Random random = new Random();
        int minProductivity = 3;
        int maxProductivity = 15;
        for (int i = 0; i < cashCount; i++) {
            cashes.add(new Cash(random.nextInt(maxProductivity - minProductivity) + minProductivity));
        }
    }

    public void process() {
        for (Cash cash : cashes) {
            Customer customer = cash.getQueue().peek();
            if (customer != null) {
                int products = customer.getProducts();
                if (cash.getProductivity() >= products) {
                    cash.getQueue().poll();
                } else {
                    customer.setProducts(products - cash.getProductivity());
                }
            }
        }
    }

    public List<Cash> getCashes() {
        return cashes;
    }

    public void setCashes(List<Cash> cashes) {
        this.cashes = cashes;
    }
}