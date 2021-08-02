/*
Semaphore semaphore = new Semaphore(3); // указываем количество одновременно разрешенных потоков

        try {
            semaphore.acquire(); // в потоке начинаем взаимодействовать с ресурсом (например, сервером)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaphore.release(); // возвращаем разрешение после окончания работы потока

        System.out.println(semaphore.availablePermits()); // возвращает количество свободных разрешений (permits)
 */

package JavaMultiThreading;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(200); // создаем пул на 10 потоков

        Connection connection = Connection.getConnection();
        for (int i = 0; i < 200; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        connection.work();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        executorService.shutdown(); // заканчиваем передавать задания в пул
        executorService.awaitTermination(1, TimeUnit.DAYS); // ждем выполнения заданий

    }
}

// Паттерн Singleton - приватный конструктор не позволяет больше создавать объекты класса
class Connection {
    private static Connection connection = new Connection();
    private int connectionsCounter = 0;
    private Semaphore semaphore = new Semaphore(10); // ограничиваем количество одновременно работающих потоков

    private Connection() {

    }

    public static Connection getConnection() {
        return connection;
    }

    public void work() throws InterruptedException {
        semaphore.acquire();
        try {
            doWork();
        } finally {
            semaphore.release();
        }
    }

    private void doWork() throws InterruptedException {
        synchronized (this) {
            connectionsCounter++;
            System.out.println(connectionsCounter);
        }
        Thread.sleep(5000);

        synchronized (this) {
            connectionsCounter--;
        }
    }
}
