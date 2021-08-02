package JavaMultiThreading.MyThreadTest;

public class MyThread {
    static  Object lock = new Object();
    static int count = 5;

    public static void main(String[] args) {

        Thread newThread1 = new Thread(new NewThread());


        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("thread1 was started");
                    while (newThread1.isAlive()) {
                    for (int i = 0; i < 20; i++) {
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.print(i + " ");
                    }
                    }
                    System.out.println("\nthread1 was stopped");
                }
            }
        });
        thread1.start();
        newThread1.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        newThread1.interrupt();

        try {
            newThread1.join();
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        SuperThread superThread = new SuperThread(count);
        superThread.start();
        SuperThread superThread2 = new SuperThread(count);
        superThread2.start();

        try {
            superThread.join();
            superThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class NewThread implements Runnable {
    Object lock2 = new Object();
    volatile int amount = 0;
    @Override
    public void run() {
        synchronized (lock2) {
            System.out.println("newThread was started");

            for (int i = 0; i < 5; i++) {
                if (Thread.currentThread().isInterrupted()) {
                    break;
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    System.out.println("\nNewThread was interrupted");;
                }
                amount += i;
            }
            System.out.println("\namount: " + amount + "\n");
            System.out.println("NewThread was stopped");


        }
    }
}

class SuperThread extends Thread {
    static  Object lock3 = new Object();
    static int count;

    public SuperThread(int count) {
        this.count = count;
    }


    @Override
    public void run() {
        synchronized (lock3) {
            count += 5;
            System.out.println("Started thread " + getName());
            System.out.println("Thread " + getName() + " count " + count);
            System.out.println("Finished thread " + getName());

        }
    }
}