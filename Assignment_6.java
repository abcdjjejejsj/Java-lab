import java.util.Scanner;

// Factorial thread (extends Thread)
class FactorialThread extends Thread {
    private int number;

    public FactorialThread(int number) {
        super("FactorialThread"); // Set thread name
        this.number = number;
    }

    @Override
    public void run() {
        try {
            System.out.println(getName() + " started.");
            long factorial = 1;
            for (int i = 1; i <= number; i++) {
                factorial *= i;
                System.out.println(getName() + " calculating: " + i + "! = " + factorial);
                Thread.sleep(500); // simulate time-consuming task
            }
            System.out.println(getName() + " result: Factorial of " + number + " is " + factorial);
        } catch (InterruptedException e) {
            System.out.println(getName() + " interrupted.");
        }
    }
}

// Square thread (implements Runnable)
class SquareThread implements Runnable {
    private int number;

    public SquareThread(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("SquareThread"); // Set thread name
        try {
            System.out.println(Thread.currentThread().getName() + " started.");
            for (int i = 1; i <= number; i++) {
                int square = i * i;
                System.out.println(Thread.currentThread().getName() + " calculating: " + i + "^2 = " + square);
                Thread.sleep(400); // simulate task time
            }
            System.out.println(Thread.currentThread().getName() + " finished.");
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " interrupted.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to calculate factorial and squares up to it: ");
        int num = scanner.nextInt();

        // Create both threads
        FactorialThread factorialThread = new FactorialThread(num);
        Thread squareThread = new Thread(new SquareThread(num));

        // Start both threads
        factorialThread.start();
        squareThread.start();

        // Wait for both threads to finish
        try {
            factorialThread.join();
            squareThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread done.");
    }
}
