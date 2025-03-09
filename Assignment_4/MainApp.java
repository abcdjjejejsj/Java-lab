import Package_B.Manager;
import java.util.Scanner;
public class MainApp {
    public static void main(String[] args) {
        Manager[] mgr = new Manager[10];
        Scanner sc=new Scanner(System.in);
        String name;
        int id,sal,cnt=0,b,ch;
        do{
            System.out.print("\n1.Add employe details\t2.Display\t3.Exit\nEnter choice :");
            ch=sc.nextInt();
            switch(ch)
            {
                case 1://add employee
                       System.out.print("\nEnter name :");
                       name=sc.nextLine();
                       sc.nextLine();
                       System.out.print("\nEnter ID :");
                       id=sc.nextInt();
                       System.out.print("\nEnter Salary :");
                       sal=sc.nextInt();
                       System.out.print("\nEnter bonus :");
                       b=sc.nextInt();
                       mgr[cnt]=new Manager();
                       mgr[cnt].setDetails(name, id, sal);
                       mgr[cnt].setBonus(b);
                       cnt++;
                       break;
                case 2://display
                       for(int i=0;i<cnt;i++)
                       {
                        System.out.print((i+1)+")");
                        mgr[i].displayDetails();
                        System.out.println("  Total Salary: Rs." + mgr[i].calculateSalary());
                        System.out.println("\n");
                       }
                       break;
                case 3://exit
            }
        }while(ch!=3);
    }
}
