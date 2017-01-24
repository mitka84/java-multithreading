package ru.savochkindv.shildt.callable;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.Assert.*;

/**
 * Created by chuwi-pc on 24.01.2017.
 */
public class CallableThreadTest {

    @Test
    public void testCallable() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> f1 = executorService.submit(new CallableThread(350));
        Future<Integer> f2 = executorService.submit(new CallableThread(150));
        Future<Integer> f3 = executorService.submit(new CallableThread(450));
        Future<Integer> f4 = executorService.submit(new CallableThread(50));

        assertEquals("Сумма отличается от ожидаемой", 1000, f1.get() + f2.get() + f3.get() + f4.get());
        executorService.shutdown();
    }

}