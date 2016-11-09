package ru.savochkindv.shildt.semaphore.example2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by chuwi-pc on 09.11.2016.
 */
public class Example2Test {

    @Test
    public void test() throws Exception {
        Resourse resourse = new Resourse();
        FirstThread firstThread = new FirstThread(resourse);
        SecondThread secondThread = new SecondThread(resourse);
        firstThread.join();
        secondThread.join();
        assertEquals("Списки не идентичны", makeExpectedList(), resourse.getList());
    }

    private List<Integer> makeExpectedList() {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            result.add(i);
            result.add(2 * i);
        }
        return result;
    }

}