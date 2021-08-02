package JavaMultiThreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentRankLockTest {
    public static void main(String[] args) {
        Task task = new Task();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                task.firstThreat();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                task.secondThreat();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        task.showCounter();

    }
}

class Task {
    private int counter = 0;
    private Lock lock = new ReentrantLock();

    private void increment() {
        for (int i = 0; i < 10000; i++) {
            counter++;
        }
    }
    public void firstThreat(){
        lock.lock(); // первый поток, который вызывает метод lock(), выполняется, пока не будет вызван метод unlock()
                     // после этого начинает работать другой поток
        increment();
        lock.unlock();
    }

    public void secondThreat() {
        lock.lock();
        increment();
        lock.unlock();
    }

    public void showCounter() {
        System.out.println(counter);
    }
}
