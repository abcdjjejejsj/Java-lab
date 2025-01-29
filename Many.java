//class with 5 attributes accept and display information
import java.util.Scanner;
class Bank{
    String name;
    int ac_no,Bal,Deposite,Withdraw;
    void accept(String nme,int ba,int acc)
    {
     ac_no=acc;
     Bal=ba;
     name=nme;
    }
    void display()
    {
   
     System.out.println("\nName:"+name+"\nAccount no.:"+ac_no+"\nBalance:"+Bal+"\n\n");
    
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

public class Many{
    public static void main(String[] args)
    {
	Scanner sc=new Scanner(System.in);
	Bank[] b=new Bank[10];
	int ch,count=0,i;
	do{
	 System.out.print("1.Add user\t2.Deposite\t3.Withdraw\t4.Display\t5.Exit\nEnter choice:");
	 ch=sc.nextInt();
	 switch(ch)
	 {
	  case 1://accept
	        System.out.print("Enter name:");
		String nam=sc.nextLine();
		System.out.print("Enter Account no:");
		int a=sc.nextInt();
		while(a<=0)
		{
		if(a==0)
		{
		 System.out.println("Account number should NOT be 0 !\n");
		 System.out.print("Enter Account no:");
		 a=sc.nextInt();
		}else{
		 System.out.println("Account number should NOT be negative !\n");
		 System.out.print("Enter Account no:");
		 a=sc.nextInt();
		 }
		}
		System.out.print("Enter initial balance:");
		int ib=sc.nextInt();
		while(ib<0)
		{
		 System.out.println("Balance should NOT be negative !\n");
		 System.out.print("Enter initial balance:");
		 ib=sc.nextInt();
		}
		b[count].accept(nam,ib,a);
		count++;
		
	  case 2://deposite
	        System.out.print("Enter Account number:");
	        int tempAc=sc.nextInt();
	        int flag=0;
	        for(i=0;i<count;i++)
	        {
	         if(tempAc==b[i].ac_no)
	         {
	          flag=1;
	         }
	        }
	        if(flag==0)
	        {
	         System.out.print("User NOT found !\n");
	        }else{
	  	 System.out.print("Enter amount for Deposite:");
	  	 b[i].Deposite=sc.nextInt();
	  	 while(b[i].Deposite<=0)
	  	 {
		  	 if(b[i].Deposite<0)
		  	 {
		  	  System.out.println("Amount should NOT be negative !\n");
		  	 System.out.print("Enter amount for Deposite:");
		  	 b[i].Deposite=sc.nextInt();
		  	 }else if(b[i].Deposite==0)
		  	 {
		  	  System.out.println("Amount should be greater than 0 !\n");
		  	 System.out.print("Enter amount for Deposite:");
		  	 b[i].Deposite=sc.nextInt();
		  	 }
		 }
		 b[i].deposite(b[i].Deposite);
		 }
		 break;
         case 3://withdraw
	        System.out.print("Enter Account number:");
	        tempAc=sc.nextInt();
	        flag=0;
	        for(i=0;i<count;i++)
	        {
	         if(tempAc==b[i].ac_no)
	         {
	          flag=1;
	         }
	        }
	        if(flag==0)
	        {
	         System.out.print("User NOT found !\n");
	        }else{
	  	 System.out.print("Enter amount for withdraw:");
	  	 b[i].Withdraw=sc.nextInt();
	  	 while(b[i].Withdraw<=0)
	  	 {
		  	 if(b[i].Withdraw<0)
		  	 {
		  	  System.out.println("Amount should NOT be negative !\n");
		  	 System.out.print("Enter amount for Deposite:");
		  	 b[i].Withdraw=sc.nextInt();
		  	 }else if(b[i].Withdraw==0)
		  	 {
		  	  System.out.println("Amount should be greater than 0 !\n");
		  	 System.out.print("Enter amount for withdraw:");
		  	 b[i].Withdraw=sc.nextInt();
		  	 }
		 }
		 b[i].withdraw(b.Withdraw);
		 }
		 break;
		 
	  case 4://display
	  	 for(i=0;i<count;i++)
	  	 {
	          b[i].display();
	         }
	         break;
	         
	  case 5://exit;
	  	 break;
	  	 
	  default:System.out.println("Wrong choice");
	 }
	}while(ch!=5);
	
    }
}
    
