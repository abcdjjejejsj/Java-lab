import java.util.Scanner;

class Bank {
    String name;
    int ac_no, Bal;

    void accept(String nme, int ba, int acc) {
        ac_no = acc;
        Bal = ba;
        name = nme;
    }

    void display() {
        System.out.println("\nName: " + name + "\nAccount no.: " + ac_no + "\nBalance: " + Bal + "\n");
    }

    void deposite(int x) {
        Bal += x;
        System.out.println("Rs." + x + " deposited successfully !\n");
    }

    void withdraw(int x) {
        if (Bal < x) {
            System.out.println("Balance is NOT sufficient !");
        } else {
            Bal -= x;
            System.out.println("Rs." + x + " Withdraw successfully !\n");
        }
    }
}

public class Assignment_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank[] b = new Bank[10]; // Array to hold up to 10 Bank objects
        int ch, count = 0, i;

        do {
            System.out.print("1. Add user\t2. Deposit\t3. Withdraw\t4. Display\t5. Exit\nEnter choice: ");
            ch = sc.nextInt();
            sc.nextLine(); // Consume newline left after nextInt()

            switch (ch) {
                case 1: // Add user
                    System.out.print("Enter name: ");
                    String nam = sc.nextLine();
                    System.out.print("Enter Account no: ");
                    int a = sc.nextInt();
                    while (a <= 0) {
                        if (a == 0) {
                            System.out.println("Account number should NOT be 0!\n");
                            System.out.print("Enter Account no:");
                            a = sc.nextInt();
                        } else {
                            System.out.println("Account number should NOT be negative!\n");
                            System.out.print("Enter Account no:");
                            a = sc.nextInt();
                        }
                    }
                    System.out.print("Enter initial balance: ");
                    int ib = sc.nextInt();
                    while (ib < 0) {
                        System.out.println("Balance should NOT be negative!\n");
                        System.out.print("Enter initial balance: ");
                        ib = sc.nextInt();
                    }
                    b[count] = new Bank(); // Initialize a new Bank object in the array slot
                    b[count].accept(nam, ib, a);
                    count++;
                    break;

                case 2: // Deposit
                    System.out.print("Enter Account number: ");
                    int tempAc = sc.nextInt();
                    int flag = 0;
                    for (i = 0; i < count; i++) {
                        if (tempAc == b[i].ac_no) {
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 0) {
                        System.out.print("User NOT found!\n");
                    } else {
                        System.out.print("Enter amount for Deposit: ");
                        int depositAmount = sc.nextInt();
                        while (depositAmount <= 0) {
                            if (depositAmount < 0) {
                                System.out.println("Amount should NOT be negative!\n");
                                System.out.print("Enter amount for Deposit: ");
                                depositAmount = sc.nextInt();
                            } else if (depositAmount == 0) {
                                System.out.println("Amount should be greater than 0!\n");
                                System.out.print("Enter amount for Deposit: ");
                                depositAmount = sc.nextInt();
                            }
                        }
                        b[i].deposite(depositAmount);
                    }
                    break;

                case 3: // Withdraw
                    System.out.print("Enter Account number: ");
                    tempAc = sc.nextInt();
                    flag = 0;
                    for (i = 0; i < count; i++) {
                        if (tempAc == b[i].ac_no) {
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 0) {
                        System.out.print("User NOT found!\n");
                    } else {
                        System.out.print("Enter amount for Withdraw: ");
                        int withdrawAmount = sc.nextInt();
                        while (withdrawAmount <= 0) {
                            if (withdrawAmount < 0) {
                                System.out.println("Amount should NOT be negative!\n");
                                System.out.print("Enter amount for Withdraw: ");
                                withdrawAmount = sc.nextInt();
                            } else if (withdrawAmount == 0) {
                                System.out.println("Amount should be greater than 0!\n");
                                System.out.print("Enter amount for Withdraw: ");
                                withdrawAmount = sc.nextInt();
                            }
                        }
                        b[i].withdraw(withdrawAmount);
                    }
                    break;

                case 4: // Display
                    for (i = 0; i < count; i++) {
                        b[i].display();
                    }
                    break;

                case 5: // Exit
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Wrong choice");
                    break;
            }
        } while (ch != 5);

        sc.close();
    }
}
