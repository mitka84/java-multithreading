package ru.savochkindv.shildt.fork_join;

import org.junit.Test;

import java.util.concurrent.ForkJoinPool;

import static org.junit.Assert.*;

/**
 * Created by chuwi-pc on 07.02.2017.
 */
public class ForkJoinTest {

    @Test
    public void testAction() throws Exception {
        System.out.println("Тестирование MyRecursiveAction");
        double[] array = prepareArray();

        System.out.println("Получение результата в один поток...");
        long start = System.nanoTime();
        double[] etalon = getEtalonResultForAction(array);
        System.out.println("Время выполнения: " + (System.nanoTime() - start) + " нс");

        System.out.println("Получение результата с помощью Fork/Join");
        start = System.nanoTime();
        ForkJoinPool.commonPool().invoke(new MyRecursiveAction(array, 0, array.length));
        System.out.println("Время выполнения: " + (System.nanoTime() - start) + " нс");

        assertArrayEquals(etalon, array, 0d);
    }

    @Test
    public void testTask() throws Exception {
        System.out.println("Тестирование MyRecursiveTask");
        double[] array = prepareArray();

        System.out.println("Получение результата в один поток...");
        long start = System.nanoTime();
        double etalon = getEtalonResultForTask(array);
        System.out.println("Время выполнения: " + (System.nanoTime() - start) + " нс");

        System.out.println("Получение результата с помощью Fork/Join");
        start = System.nanoTime();
        Double result = ForkJoinPool.commonPool().invoke(new MyRecursiveTask(array, 0, array.length));
        System.out.println("Время выполнения: " + (System.nanoTime() - start) + " нс");

        assertEquals(etalon, result, 0d);
    }

    private double[] prepareArray() {
        double[] array = new double[5000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        return array;
    }

    private double[] getEtalonResultForAction(double[] array) {
        double[] etalon = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            etalon[i] = Math.sqrt(array[i]);
        }
        return etalon;
    }

    private double getEtalonResultForTask(double[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += Math.sqrt(array[i]);
        }
        return sum;
    }
}