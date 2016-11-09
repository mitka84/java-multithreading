package ru.savochkindv.shildt.semaphore.example2;

/**
 * Created by chuwi-pc on 09.11.2016.
 */
public abstract class AbstractThread extends Thread {

    protected Resourse resourse;

    public AbstractThread(Resourse resourse) {
        this.resourse = resourse;
        start();
    }

    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            process(i);
        }
    }

    protected abstract void process(int i);
}
