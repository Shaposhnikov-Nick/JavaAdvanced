package JavaMultiThreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3); //3 - указываем, сколько раз должны вызвать countDownLatch
                                                                //чтобы countDownLatch.await() больше не ждал

        ExecutorService executorService = Executors.newFixedThreadPool(3); // задаем число потоков в пул
        for (int i = 0; i < 3; i++) {
            executorService.submit(new Processor(countDownLatch));
        }

        executorService.shutdown(); // прекращаем прием новых заданий

        countDownLatch.await();
        System.out.println("Latch has been opened, main thread is processing...");
    }
}

class Processor implements Runnable {
    private CountDownLatch countDownLatch;

    Processor(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDownLatch.countDown(); // отсчитаем назад
    }
}