package JavaMultiThreading;

import java.util.Scanner;

public class VolatileExercise {
    public static void main(String[] args) {
        NewThread newThread = new NewThread();
        newThread.start();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); // сканер ждет любую строку из консоли

        newThread.shutdown();

    }
}

class NewThread extends Thread {
    private volatile boolean running = true; // volatile  - значит, что переменная может быть изменена,
                                             // гарантируется когерентность кэшей ядер процессоров (переменная
                                             // не будет кэшироваться, а будет всегда находиться в главной памяти)
                                             // и каждый поток будет обращаться к главной памяти, чтобы получить
                                             // значение этой переменной
    public void run(){
        while (running) {
            System.out.println("Hello");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown(){ // метод для остановки метода run()
        this.running = false;
    }
}
