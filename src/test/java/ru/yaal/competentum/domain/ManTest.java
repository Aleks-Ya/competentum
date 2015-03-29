package ru.yaal.competentum.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ManTest {
    private List<Cash> cashes = new ArrayList<>();
    private Cash cash1 = new Cash(5);
    private Cash cash2 = new Cash(10);

    @Test
    public void testChooseCash() throws Exception {
        cash1.getQueue().add(new Man(20));
        cash1.getQueue().add(new Man(30));

        cash2.getQueue().add(new Man(15));

        cashes.add(cash1);
        cashes.add(cash2);

        Man man = new Man(10);
        Cash bestCash = man.chooseCash(cashes);
        assertEquals(cash2, bestCash);
    }

    @Test(expected = IllegalArgumentException.class)
    public void noCash() throws Exception {
        List<Cash> cashes = new ArrayList<>();
        assertNull(new Man(1).chooseCash(cashes));
    }

    @Test
    public void zeroProducts() throws Exception {
        cashes.add(cash1);
        cashes.add(cash2);
        assertEquals(cash1, new Man(0).chooseCash(cashes));
    }
}