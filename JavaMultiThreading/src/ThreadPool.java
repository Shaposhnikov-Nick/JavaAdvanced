package JavaMultiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
    Пул потоков.
 */
public class ThreadPool {
    public static void main(String[] args) throws InterruptedException {

        //Создаем пул ExecutorService из двух потоков:
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 5; i++)
            executorService.submit(new Work(i)); // передаем в пул потоков объект класса, реализующего интерфейс Runnable

        executorService.shutdown(); // заканчиваем принимать новые задания
        System.out.println("All tasks submitted");

        executorService.awaitTermination(1, TimeUnit.DAYS); // указываем, сколько мы хотим ждать, пока потоки выполнят все задания

    }
}

class Work implements Runnable {
    public int id;

    public Work(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Work " + id + " was completed");
    }
}