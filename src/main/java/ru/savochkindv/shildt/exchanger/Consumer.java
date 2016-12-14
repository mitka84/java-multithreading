package ru.savochkindv.shildt.exchanger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * Created by chuwi-pc on 14.12.2016.
 */
public class Consumer extends Thread {

    private Exchanger<StringBuilder> exchanger;

    private List<String> collector;

    public Consumer(Exchanger<StringBuilder> exchanger, List<String> collector) {
        this.exchanger = exchanger;
        this.collector = collector;
        start();
    }

    @Override
    public void run() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            try {
                collector.add(exchanger.exchange(builder).toString());
                builder = new StringBuilder();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}
