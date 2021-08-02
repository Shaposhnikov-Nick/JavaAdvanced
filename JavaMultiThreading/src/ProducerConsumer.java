package JavaMultiThreading;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class ProducerConsumer {
    private static ArrayBlockingQueue queue = new ArrayBlockingQueue<>(10); //потокобезопасная очередь. Установили объем в 10 объектов

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static void produce() throws InterruptedException { // добавляем элементы в очередь (10 чисел)
        Random random = new Random();

        while (true) {
            queue.put(random.nextInt(100));
        }
    }

    private static void consumer() throws InterruptedException { // забираем элементы из очереди при случайном числе равным 5
        Random random = new Random();
        while (true) {
            Thread.sleep(100);
            if (random.nextInt(10) == 5) {
                System.out.println(queue.take());
                System.out.println("Queue size: " + queue.size());
            }
        }
    }
}
