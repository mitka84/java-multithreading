package ru.savochkindv.shildt.semaphore.example1;

import java.util.concurrent.Semaphore;

/**
 * Created by chuwi-pc on 08.11.2016.
 */
public abstract class AbstractThread extends Thread {

    protected Semaphore semaphore;

    protected Resource resource;

    public AbstractThread(Semaphore semaphore, Resource resource) {
        this.semaphore = semaphore;
        this.resource = resource;
        start();
    }

    public void run() {
        try {
            semaphore.acquire();
            for (int i = 0; i < resource.getRule(); i++) {
                doWork();
            }
            sleep(10); //Что бы другой поток успел поработать
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected abstract void doWork();
}
