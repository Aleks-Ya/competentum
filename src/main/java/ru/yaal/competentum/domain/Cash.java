package ru.yaal.competentum.domain;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Cash {
    private Queue<Customer> queue = new ArrayDeque<>();

    /**
     * Производительность кассы (товаров за шаг).
     */
    private int productivity;

    public Cash(int productivity) {
        this.productivity = productivity;
    }

    /**
     * Объем очереди (количество товаров у всех поукпателей).
     */
    public int calcValue() {
        int value = 0;
        for (Customer customer : queue) {
            value += customer.getProducts();
        }
        return value;
    }

    public Queue<Customer> getQueue() {
        return queue;
    }

    public void setQueue(Queue<Customer> queue) {
        this.queue = queue;
    }

    public int getProductivity() {
        return productivity;
    }

    public void setProductivity(int productivity) {
        this.productivity = productivity;
    }
}
