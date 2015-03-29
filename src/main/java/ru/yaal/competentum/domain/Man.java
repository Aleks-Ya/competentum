package ru.yaal.competentum.domain;

import java.util.List;

public class Man extends Customer {

    public Man(int products) {
        super(products);
    }

    @Override
    public Cash chooseCash(List<Cash> cashes) {
        if (cashes.isEmpty()) {
            throw new IllegalArgumentException("No cashes");
        }
        Cash bestCash = cashes.get(0);
        for (int i = 1; i < cashes.size(); i++) {
            Cash cash2 = cashes.get(i);
            int wait1 = (bestCash.calcValue() + getProducts()) / bestCash.getProductivity();
            int wait2 = (cash2.calcValue() + getProducts()) / cash2.getProductivity();
            if (wait2 < wait1) {
                bestCash = cash2;
            }
        }
        return bestCash;
    }

    @Override
    public String getCode() {
        return "man";
    }
}