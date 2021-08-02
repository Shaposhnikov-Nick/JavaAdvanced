package JavaMultiThreading;

public class SynchronizedExercise {
    private int counter;

    public static void main(String[] args) throws InterruptedException {
        SynchronizedExercise synchronizedExercise = new SynchronizedExercise();

        synchronizedExercise.doWork();

    }

    /*
    synchronized - только один поток в момент времени имеет доступ к методу, остальные потоки ждут.
    Каждому объекту при создании Java создает "монитор". "Монитор" в момент времени может принадлежать только
    одному потоку. Синхронизация происходит только на объекте.
     */
    public  void  increment(){
        // synchronized - блок (операции в нем синзронизированы). Вне этого блока  - несинхронизированы
        synchronized (this) { // this - объект, на котором синхронизируемся
            counter++;
        }
    }

    public void doWork () throws InterruptedException { // два потока пишут в одну переменную counter
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });

        thread1.start();
        thread2.start();

        /*
        метод join() позволяет дождаться выполнения работы потока и потом продолжить выполнение программы
         */
        thread1.join();
        thread2.join();

        System.out.println(counter);
    }
}
