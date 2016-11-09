package ru.savochkindv.shildt.semaphore.example2;

/**
 * Created by chuwi-pc on 09.11.2016.
 */
public class SecondThread extends AbstractThread {

    public SecondThread(Resourse resourse) {
        super(resourse);
    }

    @Override
    protected void process(int i) {
        resourse.putDouble(i);
    }
}
