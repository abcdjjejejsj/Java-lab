// ATM Class with synchronized method
class ATM {
    synchronized void checkBalance(String user) {
        System.out.println(user + " is checking balance...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("Balance shown to " + user);
    }

    synchronized void withdraw(String user, int amount) {
        System.out.println(user + " is withdrawing Rs." + amount);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("Rs." + amount + " withdrawn by " + user);
    }
}

// Customer using ATM
class Customer extends Thread {
    ATM atm;
    String user;
    int amount;

    Customer(ATM atm, String user, int amount) {
        this.atm = atm;
        this.user = user;
        this.amount = amount;
        setName(user);   // setting thread name
    }

    public void run() {
        atm.checkBalance(user);
        atm.withdraw(user, amount);
    }
}

public class ATMApp {
    public static void main(String[] args) {
        ATM atm = new ATM();

        Customer c1 = new Customer(atm, "Vaibhav", 1000);
        Customer c2 = new Customer(atm, "Rahul", 2000);

        System.out.println("Transactions Started...");

        c1.start();
        c2.start();

        System.out.println("Is Vaibhav's transaction alive? " + c1.isAlive());
        System.out.println("Is Rahul's transaction alive? " + c2.isAlive());

        try {
            c1.join();  // wait for c1 to finish
            c2.join();  // wait for c2 to finish
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Is Vaibhav's transaction alive? " + c1.isAlive());
        System.out.println("Is Rahul's transaction alive? " + c2.isAlive());

        System.out.println("All Transactions Completed.");
    }
}
