package ru.savochkindv.shildt.count_down_latch;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.*;

/**
 * Created by chuwi-pc on 15.11.2016.
 */
public class CountDouwnLatchTest {

    @Test
    public void test() throws Exception {
        CountDownLatch cdl = new CountDownLatch(5);
        IncrementThread thread1 = new IncrementThread(cdl, 20, 1);
        IncrementThread thread2 = new IncrementThread(cdl, 40, 2);
        IncrementThread thread3 = new IncrementThread(cdl, 60, 3);
        IncrementThread thread4 = new IncrementThread(cdl, 90, 4);
        IncrementThread thread5 = new IncrementThread(cdl, 120, 20);

        cdl.await();

        assertEquals("Значение в потоке отличается от ожидаемого", 20, thread1.getValue());
        assertEquals("Значение в потоке отличается от ожидаемого", 40 * 2, thread2.getValue());
        assertEquals("Значение в потоке отличается от ожидаемого", 60 * 3, thread3.getValue());
        assertEquals("Значение в потоке отличается от ожидаемого", 90 * 4, thread4.getValue());
        assertEquals("Значение в потоке отличается от ожидаемого", 120 * 20, thread5.getValue());
    }

}