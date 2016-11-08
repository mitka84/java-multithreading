package ru.savochkindv.shildt.semaphore.example1;

import java.util.concurrent.Semaphore;

/**
 * Created by chuwi-pc on 08.11.2016.
 */
public class IncrementThread extends AbstractThread {

    public IncrementThread(Semaphore semaphore, Resource resource) {
        super(semaphore, resource);
    }

    protected void doWork() {
        resource.incrementVariable();
    }
}
