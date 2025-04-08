import java.util.Scanner;

// TicketBooking implements Runnable
class TicketBooking implements Runnable {
    int tickets;

    TicketBooking(int tickets) {
        this.tickets = tickets;
    }

    // synchronized method for safe booking
    synchronized public void bookTicket(String counterName) {
        if (tickets > 0) {
            System.out.println(counterName + " booked 1 ticket. Remaining: " + (--tickets));
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            System.out.println(counterName + " -> No tickets left!");
        }
    }

    @Override
    public void run() {
        // blank because booking will be done by Counter class
    }
}

// Counter class extends Thread
class Counter extends Thread {
    TicketBooking bookingSystem;
    String counterName;

    Counter(TicketBooking bookingSystem, String counterName) {
        this.bookingSystem = bookingSystem;
        this.counterName = counterName;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (bookingSystem) {
                if (bookingSystem.tickets <= 0)
                    break;
                bookingSystem.bookTicket(counterName);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter total number of tickets:");
        int totalTickets = sc.nextInt();

        System.out.println("Enter number of counters:");
        int n = sc.nextInt();

        sc.nextLine(); // clear buffer

        TicketBooking bookingSystem = new TicketBooking(totalTickets);

        Counter[] counters = new Counter[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter name of Counter " + (i + 1) + ":");
            String name = sc.nextLine();
            counters[i] = new Counter(bookingSystem, name);
        }

        System.out.println("\nBooking Started...\n");

        for (int i = 0; i < n; i++) {
            counters[i].start();
        }

        for (int i = 0; i < n; i++) {
            try {
                counters[i].join();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        System.out.println("\nBooking Closed.");
    }
}
