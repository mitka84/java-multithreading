package ru.savochkindv.shildt.cyclic_barrier;

import org.junit.Test;

import java.util.concurrent.CyclicBarrier;

import static org.junit.Assert.*;

/**
 * Created by chuwi-pc on 15.11.2016.
 */
public class CyclicBarrierTest {

    @Test
    public void test() throws Exception {
        CyclicBarrier cb = new CyclicBarrier(5);
        IncrementThread thread1 = new IncrementThread(cb, 30);
        IncrementThread thread2 = new IncrementThread(cb, 45);
        IncrementThread thread3 = new IncrementThread(cb, 60);
        IncrementThread thread4 = new IncrementThread(cb, 130);

        cb.await();
        assertTrue("Верхняя граница не достигнута", thread1.isTopReached());
        assertTrue("Верхняя граница не достигнута", thread2.isTopReached());
        assertTrue("Верхняя граница не достигнута", thread3.isTopReached());
        assertTrue("Верхняя граница не достигнута", thread4.isTopReached());

        cb.await();
        assertEquals("Значение в потоке отличается от ожидаемого", 0, thread1.getValue());
        assertEquals("Значение в потоке отличается от ожидаемого", 0, thread2.getValue());
        assertEquals("Значение в потоке отличается от ожидаемого", 0, thread3.getValue());
        assertEquals("Значение в потоке отличается от ожидаемого", 0, thread4.getValue());
    }
}