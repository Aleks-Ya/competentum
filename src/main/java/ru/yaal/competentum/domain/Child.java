package ru.yaal.competentum.domain;

import java.util.List;
import java.util.Random;

public class Child extends Customer {
    private Random random = new Random();

    public Child(int products) {
        super(products);
    }

    @Override
    public Cash chooseCash(List<Cash> cashes) {
        int number = random.nextInt(cashes.size());
        return cashes.get(number);
    }

    @Override
    public String getCode() {
        return "child";
    }
}
