package ru.savochkindv.shildt.fork_join;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * Created by chuwi-pc on 07.02.2017.
 */
public class MyRecursiveTask extends RecursiveTask<Double> {

    private double[] array;

    private int start;

    private int end;

    private static final int THRESHOLD = 1000;

    MyRecursiveTask(double[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Double compute() {
        double sum = 0;
        if (end - start > THRESHOLD) {
            for (int i = start; i < end; i++) {
                sum += Math.sqrt(i);
            }
        } else {
            int mid = (start + end) / 2;
            MyRecursiveTask myRecursiveTask1 = new MyRecursiveTask(array, start, mid);
            MyRecursiveTask myRecursiveTask2 = new MyRecursiveTask(array, mid, end);

            myRecursiveTask1.fork();

            sum = myRecursiveTask1.join() + myRecursiveTask2.invoke();
        }
        return sum;
    }
}
