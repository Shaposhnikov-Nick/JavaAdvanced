package JavaMultiThreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ProducerConsumer2 {

    public static void main(String[] args) {
        ProducerConsumerClass pcc = new ProducerConsumerClass();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pcc.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pcc.consume();
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
}

class ProducerConsumerClass {
    private Queue<Integer> queue = new LinkedList<>();
    private final int LIMIT = 10;
    private final Object lock = new Object(); // на этом объекте будет проходить синхронизация (объект должен быть final)

    public void produce() throws InterruptedException { // добавляем элементы в очередь

        int value = 0;
        while (true) {
            synchronized (lock) {

                while (queue.size() == LIMIT) { // если очередь полна, приостанавливаем поток
                    lock.wait();
                }
                queue.offer(value++);
                lock.notify();
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (lock){
                while (queue.size() == 0) { // если очередь пуста, приостанавливаем поток
                    lock.wait();
                }
                int value = queue.poll();  // убираем элементы из очереди
                System.out.println(value);
                System.out.println("Queue size: " + queue.size());
                lock.notify();
            }
            Thread.sleep(1000); // усыпляем consume() на 1 с, чтобы produce() успевал заполнить очередь
        }

    }
}


