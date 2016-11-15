package ru.savochkindv.shildt.count_down_latch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by chuwi-pc on 15.11.2016.
 */
public class IncrementThread  implements Runnable{

    private int value;

    private int rule;

    private int incrementer;

    private CountDownLatch cdl;

    public IncrementThread(CountDownLatch cdl, int rule, int incrementer) {
        this.cdl = cdl;
        this.rule = rule;
        this.incrementer = incrementer;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < rule; i++) {
            value += incrementer;
        }
        cdl.countDown();
    }

    public int getValue() {
        return value;
    }
}
