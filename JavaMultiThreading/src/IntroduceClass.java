package JavaMultiThreading;

public class IntroduceClass {
    public static void main(String[] args) {

        /*
        создание потоков класса MyThread
         */
        MyThread myThread = new MyThread();
        myThread.start(); // вызываем у объекта потока метод start(), который запустит метод run(), чтобы обеспечить многопоточность

        MyThread myThread2 = new MyThread();
        myThread2.start();

        /*
        создание потоков класса Runner
         */
        Thread thread = new Thread(new Runner());
        thread.start();

        System.out.println("Hello from main thread!");

    }
}

/*
класс нового потока имплементирует интерфейс Runnable. Нужно переопределить
метод run()
 */
class Runner implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000); // статический метод, поток "засыпает" на заданное количетво времени
                // (в аргументах метода указывается время в миллисекундах)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Hello from MyThread!" + i);
        }
    }
}

/*
класс нового потока наследуется от класса Thread. Также переопределяется метод run()
 */
class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000); // статический метод, поток "засыпает" на заданное количетво времени
                // (в аргументах метода указывается время в миллисекундах)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Hello from MyThread!" + i);
        }
    }
}
