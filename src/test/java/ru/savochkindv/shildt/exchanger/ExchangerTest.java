package ru.savochkindv.shildt.exchanger;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

import static org.junit.Assert.*;

/**
 * Created by chuwi-pc on 14.12.2016.
 */
public class ExchangerTest {

    @Test
    public void test() throws Exception {
        Exchanger<StringBuilder> exchanger = new Exchanger<>();
        List<String> result = new ArrayList<>();
        Thread producer = new Producer(exchanger);
        Thread consumer = new Consumer(exchanger, result);
        consumer.join();
        assertEquals(20, result.size());
        for (String item : result) {
            assertEquals("0123456789", item);
        }
    }

}