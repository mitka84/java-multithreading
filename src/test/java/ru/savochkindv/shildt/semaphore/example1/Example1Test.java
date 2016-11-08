package ru.savochkindv.shildt.semaphore.example1;

import org.junit.Test;

import java.util.concurrent.Semaphore;

import static org.junit.Assert.*;

/**
 * Created by chuwi-pc on 08.11.2016.
 */
public class Example1Test {

    @Test
    public void test() throws Exception {
        Semaphore semaphore = new Semaphore(1);
        Resource resource = new Resource(5);
        IncrementThread incrementThread = new IncrementThread(semaphore, resource);
        DecrementThread decrementThread = new DecrementThread(semaphore, resource);
        incrementThread.join();
        decrementThread.join();
        assertTrue(resource.isTopReached());
        assertTrue(resource.isBottomReached());
    }

}