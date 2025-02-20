//assignment 3 using interfaces
import java.util.*;

/*
 basic :-add,sub,div,mul
 advance:expoonential
 display:-show
*/

interface basic{
 int add(int a,int b);
 int sub(int a,int b);
 int mul(int a,int b);
 int div(int a,int b);
}

interface advance extends basic{
 int power(int a,int b);
}
interface display extends basic,advance{
 void show(int res);
}

class Operation implements display
{
 public void show(int res)
 {
  System.out.println("Result : "+res);
 }
 public int add(int a,int b)
 {
  return a+b;
 }
 public int sub(int a,int b)
 {
  return a-b;
 }
 public int mul(int a,int b)
 {
  return a*b;
 }
 public int div(int a,int b)
 {
 int d=0;
   try{
     d=a/b;
   }catch(ArithmeticException e)
   {
    System.out.println("Error: Divide by 0 is NOT possible !");
   }
   return d;  
 }
 public int power(int a,int b)
 {
  int s=1;
  for(int i=0;i<b;i++)
  {
   s=s*a;
  }
  return s;
 }
 
}

public class Assignment_3{
 public static void main(String[] args)
 {
   Scanner sc=new Scanner(System.in);
   int ch,x,y,res;
   basic ba=new Operation();
   display di=new Operation();
   do{
    System.out.print("\n1.Addition\t2.Subtraction\t3.Multiplication\t4.Division\t5.Exponential\t6.Exit\nEnter choice:");
    ch=sc.nextInt();
    switch(ch)
    {
     case 1://add           
            System.out.print("\nEnter num1 : ");
            x=sc.nextInt();
            System.out.print("\nEnter num2 : ");
            y=sc.nextInt();
            res=ba.add(x,y);      
            di.show(res);
            break;
     case 2://sub         
            System.out.print("\nEnter num1 : ");
            x=sc.nextInt();
            System.out.print("\nEnter num2 : ");
            y=sc.nextInt();    
            res=ba.sub(x,y);            
            di.show(res);
            break;
    case 3://Multiplication        
            System.out.print("\nEnter num1 : ");
            x=sc.nextInt();
            System.out.print("\nEnter num2 : ");
            y=sc.nextInt();
            res=ba.mul(x,y);
            di.show(res);
            break;
    case 4://div      
            System.out.print("\nEnter num1 : ");
            x=sc.nextInt();
            System.out.print("\nEnter num2 : ");
            y=sc.nextInt(); 
            res=ba.div(x,y);
            di.show(res);
            break;
    case 5://exponential     
            advance ad=new Operation(); 
            System.out.print("\nEnter number : ");
            x=sc.nextInt();
            System.out.print("\nEnter power : ");
            y=sc.nextInt(); 
            res=ad.power(x,y);
            di.show(res);
            break;
    }
   }while(ch!=6);
   
 }
}
