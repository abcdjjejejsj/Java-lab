import java.util.Scanner;

class TicketBooking implements Runnable {
    int tickets;  
    String counterName; 

    TicketBooking(int tickets, String name) {
        this.tickets = tickets;
        this.counterName = name;
    }

    public void run() {
        while (tickets > 0) {
            bookTicket();
            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    synchronized void bookTicket() {
        if (tickets > 0) {
            System.out.println(counterName + " booked ticket no: " + tickets);
            tickets--;
        } else {
            System.out.println(counterName + " : No tickets left");
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter total no of tickets: ");
        int totalTickets = sc.nextInt();

        System.out.print("Enter no of Counters: ");
        int noOfCounters = sc.nextInt();

        Thread counters[] = new Thread[noOfCounters];

        // creating threads dynamically
        for(int i=0; i<noOfCounters; i++) {
            System.out.print("Enter name of Counter " + (i+1) + ": ");
            String name = sc.next();

            TicketBooking booking = new TicketBooking(totalTickets, name);
            counters[i] = new Thread(booking);

            // priority concept
            counters[i].setPriority(Thread.NORM_PRIORITY); 
        }

        // starting threads
        for(int i=0; i<noOfCounters; i++) {
            counters[i].start();
        }

        // join all threads
        for(int i=0; i<noOfCounters; i++) {
            counters[i].join();
        }

        System.out.println("All Tickets Booked Successfully");
    }
}
