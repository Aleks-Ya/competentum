package ru.yaal.competentum.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class WomanTest {

    @Test
    public void testChooseCash() throws Exception {
        List<Cash> cashes = new ArrayList<>();
        cashes.add(makeCash(2));
        cashes.add(makeCash(1));
        cashes.add(makeCash(0));

        Woman man = new Woman(10);
        Cash bestCash = man.chooseCash(cashes);
        assertEquals(0, bestCash.getQueue().size());
    }

    private Cash makeCash(int size) {
        Cash cash = new Cash(1);
        for (int i = 0; i < size; i++) {
            cash.getQueue().add(new Man(20));
        }
        return cash;
    }
}