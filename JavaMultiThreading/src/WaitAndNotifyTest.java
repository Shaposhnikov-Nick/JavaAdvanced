package JavaMultiThreading;

import java.util.Scanner;

public class WaitAndNotifyTest {
    public static void main(String[] args) {
        ProducerConsumerClass wn = new ProducerConsumerClass();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.consume();
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

class WaitAndNotify {

    public void produce() throws InterruptedException {
        synchronized (this) {
            System.out.println("Producer thread started...");
            wait(); // 1 - отдаем Intrinsic lock (монитор), 2 - ждем, когда будет вызван notify() на этом объекте (тогда поток продолжит работать)
            System.out.println("Producer thread resumed...");
        }
    }

    public void consume() throws InterruptedException {
        Thread.sleep(2000);
        Scanner scanner = new Scanner(System.in);

        synchronized (this) {
            System.out.println("Wait for return key pressed ");
            scanner.nextLine();
            notify(); // пробуждает только один поток. notifyAll() - пробуждает все потоки. Не отдает монитор
        }

    }

}
