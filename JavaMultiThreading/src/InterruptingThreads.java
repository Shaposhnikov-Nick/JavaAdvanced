package JavaMultiThreading;
/*
 Прерывание потоков
 */

import java.util.Random;

public class InterruptingThreads {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                for (int i = 0; i < 1_000_000_000; i++) {
                    if (Thread.currentThread().isInterrupted()) {     // проверяем, был ли вызван в другом потоке метод
                        System.out.println("Thread was interrupted"); // interrupt()
                        break;
                    }

                    Math.sin(random.nextInt());
                }
            }
        });

        System.out.println("Starting thread... ");
        thread.start();

        Thread.sleep(1000);
        thread.interrupt();

        thread.join();
        System.out.println("Thread has been finished...");
    }
}
