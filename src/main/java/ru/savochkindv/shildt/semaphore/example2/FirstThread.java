package ru.savochkindv.shildt.semaphore.example2;

/**
 * Created by chuwi-pc on 09.11.2016.
 */
public class FirstThread extends AbstractThread {

    public FirstThread(Resourse resourse) {
        super(resourse);
    }

    @Override
    protected void process(int i) {
        resourse.put(i);
    }
}
