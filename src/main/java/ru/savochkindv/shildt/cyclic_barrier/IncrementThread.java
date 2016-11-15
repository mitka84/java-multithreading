package ru.savochkindv.shildt.cyclic_barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by chuwi-pc on 15.11.2016.
 */
public class IncrementThread implements Runnable{

    private int value;

    private int rule;

    private boolean topReached;

    private CyclicBarrier cb;

    public IncrementThread(CyclicBarrier cb, int rule) {
        this.cb = cb;
        this.rule = rule;
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < rule; i++) {
                value++;
            }
            topReached = true;
            cb.await();
            for (int i = 0; i < rule; i++) {
                value--;
            }
            cb.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public int getValue() {
        return value;
    }

    public boolean isTopReached() {
        return topReached;
    }
}
