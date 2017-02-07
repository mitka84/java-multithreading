package ru.savochkindv.shildt.fork_join;

import java.util.concurrent.RecursiveAction;

/**
 * Created by chuwi-pc on 07.02.2017.
 */
public class MyRecursiveAction extends RecursiveAction {

    private double[] array;

    private int start;

    private int end;

    private static final int THRESHOLD = 1000;

    MyRecursiveAction(double[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if (end - start > THRESHOLD) {
            for (int i = start; i < end; i++) {
                array[i] = Math.sqrt(i);
            }
        } else {
            int mid = (start + end) / 2;
            invokeAll(new MyRecursiveAction(array, start, mid),
                      new MyRecursiveAction(array, mid, end));
        }
    }
}
