// 2nd Assignment: Using Inheritance and Polymorphism
import java.util.Scanner;
class Basic {
    protected double r;
    int l, b,side;
    double a;
    final double pi = 3.14;
    
    Basic(int len, int bre) {
        this.l = len;
        this.b = bre;
    }

    void area()
    {
     a=l*b;
    }
}


class Circle extends Basic {
    
    Circle(double rad) {
        super(0, 0); 
        this.r = rad;
    }

    void area() {
        a = pi * r * r;
        System.out.println("Area of circle is: " + a);
    }
}


class Rectangle extends Basic {
    Rectangle(int le, int br) {
        super(le, br);
    }

   
    void area() {
        a = l * b;
        System.out.println("Area of rectangle is: " + a);
    }
}
class Square extends Basic
{
 Square(int s)
 {
  super(0,0);
  side=s;
 }
 void area()
 {
  a=side*side;
   System.out.println("Area of Square is: " + a);
 }
}


public class Assignment_2 {
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
        int ch,ln,bd,rd,sd;
        do{
         System.out.println("Find the Area of 1.Rectangle\t2.Circle\t3.Square\t4.Exit\nEnter choice:");
         ch=sc.nextInt();
         switch(ch)
         {
           case 1://for rectangle
           	  System.out.print("Enter the length:");
           	  ln=sc.nextInt();
           	  System.out.print("Enter the breadth:");
           	  bd=sc.nextInt();
           	  Rectangle r=new Rectangle(ln,bd);
           	  r.area();
           	  break;
           case 2://circle
           	  System.out.print("Enter the radius:");
           	  rd=sc.nextInt();
           	  Circle c=new Circle(rd);
           	  c.area();
           	  break;
           case 3://square
           	  System.out.print("Enter the length:");
           	  sd=sc.nextInt();
           	  Square s=new Square(sd);
           	  s.area();
           	  break;
           case 4://exit
           
         }
         
        }while(ch!=4);
    }
}
