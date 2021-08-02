package JavaMultiThreading;

import java.util.Random;
import java.util.concurrent.*;

/*
    Получение данных из потока
 */

public class CallableAndFuture {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Future<Integer> future = executorService.submit(new Callable<Integer>() { // <Integer> - указываем тип возвращаемого значения
            @Override
            public Integer call() throws Exception {
                System.out.println("Starting");
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Finished");

                Random random = new Random();
                int randomValue = random.nextInt(10);
                if (randomValue < 5)
                    throw new Exception("Something bad happened");

                return random.nextInt(100);
            }
        });

        executorService.shutdown();

        try {
            int result = future.get();  // get  ожидает окончания выполнения потока
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            Throwable ex = e.getCause(); // получаем эксепшн из потока
            System.out.println(ex.getMessage());
        }
    }
}
