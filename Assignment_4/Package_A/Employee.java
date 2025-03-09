package Package_A;

public class Employee {
    private String name;
    private int empID;
    protected double salary; 
    
    public void setDetails(String name, int empID, double salary) {
        this.name = name;
        this.empID = empID;
        this.salary = salary;
    }

   
    public void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("  Employee ID: " + empID);
        System.out.println("  Base Salary: Rs." + salary);
    }

    // Protected method to return salary (used in subclass)
    protected double calculateSalary() {
        return salary;
    }
}
