package ru.savochkindv.shildt.phaser;

import org.junit.Test;

import java.util.concurrent.Phaser;

import static org.junit.Assert.*;

/**
 * Created by chuwi-pc on 14.12.2016.
 */
public class PhaserTest {

    @Test
    public void test() throws Exception {
        Phaser phaser = new Phaser();
        phaser.register();
        ReacherThread thread1 = new ReacherThread(phaser, 2, -3);
        ReacherThread thread2 = new ReacherThread(phaser, 16, -35);
        ReacherThread thread3 = new ReacherThread(phaser, 200, -80);
        ReacherThread thread4 = new ReacherThread(phaser, 100, -29);
        ReacherThread thread5 = new ReacherThread(phaser, 1, -1);

        // На первой фазе счетчик стремится к максимальному значению
        phaser.arriveAndAwaitAdvance();
        assertTrue("Максимальная граница не достигнута", thread1.isMaxReached());
        assertTrue("Максимальная граница не достигнута", thread2.isMaxReached());
        assertTrue("Максимальная граница не достигнута", thread3.isMaxReached());
        assertTrue("Максимальная граница не достигнута", thread4.isMaxReached());
        assertTrue("Максимальная граница не достигнута", thread5.isMaxReached());
        // Недостижение нуля не проверяется, т.к. фаза достижения нуля в этот
        // момент уже выполняется
        assertFalse("Минимальная граница достигнута", thread1.isMinReached());
        assertFalse("Минимальная граница достигнута", thread2.isMinReached());
        assertFalse("Минимальная граница достигнута", thread3.isMinReached());
        assertFalse("Минимальная граница достигнута", thread4.isMinReached());
        assertFalse("Минимальная граница достигнута", thread5.isMinReached());

        // На второй фазе счетчик стремится к нулю
        phaser.arriveAndAwaitAdvance();
        assertTrue("Нулевое значение не достигнуто", thread1.isZeroReached());
        assertTrue("Нулевое значение не достигнуто", thread2.isZeroReached());
        assertTrue("Нулевое значение не достигнуто", thread3.isZeroReached());
        assertTrue("Нулевое значение не достигнуто", thread4.isZeroReached());
        assertTrue("Нулевое значение не достигнуто", thread5.isZeroReached());

        // На третьей фазе счетчик стремится к минимальному значению
        phaser.arriveAndAwaitAdvance();
        assertTrue("Минимальная граница не достигнута", thread1.isMinReached());
        assertTrue("Минимальная граница не достигнута", thread2.isMinReached());
        assertTrue("Минимальная граница не достигнута", thread3.isMinReached());
        assertTrue("Минимальная граница не достигнута", thread4.isMinReached());
        assertTrue("Минимальная граница не достигнута", thread5.isMinReached());

        phaser.arriveAndDeregister();
    }
}