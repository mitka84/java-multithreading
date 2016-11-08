package ru.savochkindv.shildt.semaphore.example1;

/**
 * Created by chuwi-pc on 08.11.2016.
 */
public class Resource {

    private int intVariable = 0;

    private boolean topReached = false;

    private boolean bottomReached = false;

    private int rule;

    public Resource(int rule) {
        this.rule = rule;
    }

    public void incrementVariable() {
        intVariable++;
        if (intVariable == rule) {
            topReached = true;
            intVariable = 0;
        }
    }

    public void decrementVariable() {
        intVariable--;
        if (intVariable == -rule) {
            bottomReached = true;
            intVariable = 0;
        }
    }

    public boolean isTopReached() {
        return topReached;
    }

    public boolean isBottomReached() {
        return bottomReached;
    }

    public int getRule() {
        return rule;
    }
}
