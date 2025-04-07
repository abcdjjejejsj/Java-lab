// Using Thread Class
class MyThread1 extends Thread {
    public void run() {
        System.out.println(getName() + " is starting...");

        try {
            Thread.sleep(1000);  // sleep for 1 sec
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println(getName() + " is finished.");
    }
}

// Using Runnable Interface
class MyThread2 implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is starting...");

        try {
            Thread.sleep(1500);  // sleep for 1.5 sec
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println(Thread.currentThread().getName() + " is finished.");
    }
}

public class ThreadConcepts {
    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1(); // Thread class
        MyThread2 obj = new MyThread2();
        Thread t2 = new Thread(obj);    // Runnable interface

        t1.setName("Thread-One");
        t2.setName("Thread-Two");

        System.out.println("Starting Threads...");
        
        t1.start();
        t2.start();

        System.out.println("Is t1 alive? " + t1.isAlive());
        System.out.println("Is t2 alive? " + t2.isAlive());

        try {
            t1.join();  // wait for t1
            t2.join();  // wait for t2
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Are threads alive after finish?");
        System.out.println("Is t1 alive? " + t1.isAlive());
        System.out.println("Is t2 alive? " + t2.isAlive());

        System.out.println("Main Thread Finished.");
    }
}
