package Package_B;
import Package_A.Employee;

public class Manager extends Employee {
    private double bonus; 

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public void displayDetails() {
        super.displayDetails(); 
        System.out.println("  Bonus: Rs." + bonus);
    }

    public double calculateSalary() {
        return salary + bonus;
    }
}
