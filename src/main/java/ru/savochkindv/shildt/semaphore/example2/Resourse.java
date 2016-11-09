package ru.savochkindv.shildt.semaphore.example2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * Created by chuwi-pc on 09.11.2016.
 */
public class Resourse {

    private List<Integer> list = new ArrayList<>();

    private Semaphore firstSemaphore = new Semaphore(1);
    // Начать с недоступного второго семафора потребителя
    private Semaphore secondSemaphore = new Semaphore(0);

    void put(int n) {
        try {
            firstSemaphore.acquire();
            list.add(n);
            secondSemaphore.release();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    void putDouble(int n) {
        try {
            secondSemaphore.acquire();
            list.add(2 * n);
            firstSemaphore.release();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    /**
     * Возвращает копию листа
     * @return копию листа
     */
    public List<Integer> getList() {
        return new ArrayList<>(list);
    }
}