package ru.savochkindv.shildt.callable;

import java.util.concurrent.Callable;

/**
 * Created by chuwi-pc on 24.01.2017.
 */
public class CallableThread implements Callable<Integer> {

    private Integer value;

    public CallableThread(Integer value) {
        this.value = value;
    }

    @Override
    public Integer call() throws Exception {
        try {
            // Имитируем долгую работу
            Thread.sleep(value);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        return value;
    }
}
