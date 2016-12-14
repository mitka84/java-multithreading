package ru.savochkindv.shildt.exchanger;

import java.util.concurrent.Exchanger;

/**
 * Created by chuwi-pc on 14.12.2016.
 */
public class Producer extends Thread {

    private Exchanger<StringBuilder> exchanger;

    public Producer(Exchanger<StringBuilder> exchanger) {
        this.exchanger = exchanger;
        start();
    }

    @Override
    public void run() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                builder.append(j);
            }
            try {
                builder = exchanger.exchange(builder);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}
