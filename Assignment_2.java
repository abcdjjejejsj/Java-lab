// 2nd Assignment: Using Inheritance and Polymorphism

class Basic {
    protected double r;
    int l, b,side;
    double a;
    final double pi = 3.14;
    
    Basic(int len, int bre) {
        this.l = len;
        this.b = bre;
    }

    void setRadius(double rad) {
        this.r = rad;
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
      
        Rectangle r = new Rectangle(2, 3);
        r.area();

      
        Circle c = new Circle(4.5);
        c.area();
        
        Square s=new Square(4);
        s.area();
    }
}

