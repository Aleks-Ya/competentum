package ru.yaal.competentum.domain;

import java.util.List;

public class Woman extends Customer {
    public Woman(int products) {
        super(products);
    }

    /**
     * Выбор кассы с наименьшей длиной очереди.
     */
    @Override
    public Cash chooseCash(List<Cash> cashes) {
        if (cashes.isEmpty()) {
            throw new IllegalArgumentException("No cashes");
        }
        Cash bestCash = cashes.get(0);
        for (int i = 1; i < cashes.size(); i++) {
            Cash cash2 = cashes.get(i);
            int wait1 = bestCash.getQueue().size();
            int wait2 = cash2.getQueue().size();
            if (wait2 < wait1) {
                bestCash = cash2;
            }
        }
        return bestCash;
    }

    @Override
    public String getCode() {
        return "woman";
    }
}
