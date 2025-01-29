//class with 5 attributes accept and display information
import java.util.Scanner;
class Bank{
    String name;
    int ac_no,Bal,Deposite,Withdraw;
    void display()
    {
     System.out.println("\nName:"+name+"\nAccount no.:"+ac_no+"\nBalance:"+Bal);
    }
    void deposite(int x)
    {
     Bal+=x;
     System.out.println("Rs."+x+" deposited successfully !\n");
    }
    void withdraw(int x)
    {
     if(Bal<Withdraw)
     {
      System.out.println("Balance is NOT sufficient !");
     }else{
     Bal-=x;
     System.out.println("Rs."+x+" Withdraw successfully !\n");
     }
    }
}

public class One{
    public static void main(String[] args)
    {
	Scanner sc=new Scanner(System.in);
	Bank b=new Bank();
	int ch;
	System.out.print("Enter name:");
	b.name=sc.nextLine();
	System.out.print("Enter Account no:");
	b.ac_no=sc.nextInt();
	while(b.ac_no<=0)
	{
	if(b.ac_no==0)
	{
	 System.out.println("Account number should NOT be 0 !\n");
	 System.out.print("Enter Account no:");
	 b.ac_no=sc.nextInt();
	}else{
	 System.out.println("Account number should NOT be negative !\n");
	 System.out.print("Enter Account no:");
	 b.ac_no=sc.nextInt();
	 }
	}
	System.out.print("Enter initial balance:");
	b.Bal=sc.nextInt();
	while(b.Bal<0)
	{
	 System.out.println("Balance should NOT be negative !\n");
	 System.out.print("Enter initial balance:");
	 b.Bal=sc.nextInt();
	}
	
	do{
	 System.out.print("1.Deposite\t2.Withdraw\t3.Display\t4.Exit\nEnter choice:");
	 ch=sc.nextInt();
	 switch(ch)
	 {
	  case 1://deposite
	  	 System.out.print("Enter amount for Deposite:");
	  	 b.Deposite=sc.nextInt();
	  	 while(b.Deposite<=0)
	  	 {
		  	 if(b.Deposite<0)
		  	 {
		  	  System.out.println("Amount should NOT be negative !\n");
		  	 System.out.print("Enter amount for Deposite:");
		  	 b.Deposite=sc.nextInt();
		  	 }else if(b.Deposite==0)
		  	 {
		  	  System.out.println("Amount should be greater than 0 !\n");
		  	 System.out.print("Enter amount for Deposite:");
		  	 b.Deposite=sc.nextInt();
		  	 }
		 }
		 b.deposite(b.Deposite);
		 break;
         case 2://withdraw
	  	 System.out.print("Enter amount for withdraw:");
	  	 b.Withdraw=sc.nextInt();
	  	 while(b.Withdraw<=0)
	  	 {
		  	 if(b.Withdraw<0)
		  	 {
		  	  System.out.println("Amount should NOT be negative !\n");
		  	 System.out.print("Enter amount for Deposite:");
		  	 b.Withdraw=sc.nextInt();
		  	 }else if(b.Withdraw==0)
		  	 {
		  	  System.out.println("Amount should be greater than 0 !\n");
		  	 System.out.print("Enter amount for withdraw:");
		  	 b.Withdraw=sc.nextInt();
		  	 }
		 }
		 b.withdraw(b.Withdraw);
		 break;
		 
	  case 3://display
	         b.display();
	         break;
	         
	  case 4://exit;
	  	 break;
	  	 
	  default:System.out.println("Wrong choice");
	 }
	}while(ch!=4);
	
    }
}
    
