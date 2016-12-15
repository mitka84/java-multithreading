package ru.savochkindv.shildt.phaser;

import java.util.concurrent.Phaser;

/**
 * Created by chuwi-pc on 14.12.2016.
 */
public class ReacherThread extends Thread {

    private Phaser phaser;

    private int maxValue;

    private int minValue;

    private boolean maxReached;

    private boolean zeroReached;

    private boolean minReached;

    public ReacherThread(Phaser phaser, int maxValue, int minValue) {
        this.phaser = phaser;
        phaser.register();
        this.maxValue = maxValue;
        this.minValue = minValue;
        start();
    }

    @Override
    public void run() {
        int i = 0;
        while (i != maxValue) {
            i++;
        }
        maxReached = true;
        phaser.arriveAndAwaitAdvance();

        while (i != 0) {
            i--;
        }
        zeroReached = true;
        phaser.arriveAndAwaitAdvance();

        while (i != minValue) {
            i--;
        }
        minReached = true;
        phaser.arriveAndAwaitAdvance();
    }

    public boolean isMaxReached() {
        return maxReached;
    }

    public boolean isMinReached() {
        return minReached;
    }

    public boolean isZeroReached() {
        return zeroReached;
    }
}
