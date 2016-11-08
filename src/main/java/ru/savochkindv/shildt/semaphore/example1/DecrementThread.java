package ru.savochkindv.shildt.semaphore.example1;

import java.util.concurrent.Semaphore;

/**
 * Created by chuwi-pc on 08.11.2016.
 */
public class DecrementThread extends AbstractThread {

    public DecrementThread(Semaphore semaphore, Resource resource) {
        super(semaphore, resource);
    }

    protected void doWork() {
        resource.decrementVariable();
    }
}
