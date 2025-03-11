import java.util.Scanner;

// User-defined exception for invalid salary
class InvalidSalaryException extends Exception {
    public InvalidSalaryException(String message) {
        super(message);
    }
}

// Employee class
class Employee {
    private String name;
    private double basicSalary;

    // Constructor
    public Employee(String name, double basicSalary) {
        this.name = name;
        this.basicSalary = basicSalary;
    }

    // Method to calculate net salary
    public double calculateSalary() throws InvalidSalaryException {
        if (basicSalary <= 0) {
            throw new InvalidSalaryException("Salary must be greater than zero.");
        }

        double taxRate = 10.0; // 10% tax
        double taxAmount = (basicSalary * taxRate) / 100;
        return basicSalary - taxAmount;
    }

    // Display employee details
    public void displaySalary() {
        try {
            double netSalary = calculateSalary();  // Call method that throws exception
            System.out.println("\nEmployee Name: " + name);
            System.out.println("Net Salary: ₹" + netSalary);
        } catch (InvalidSalaryException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

// Main class
public class EmployeeSalarySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter Employee Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Basic Salary: ₹");
            double salary = Double.parseDouble(scanner.nextLine()); // May cause NumberFormatException

            Employee emp = new Employee(name, salary);
            emp.displaySalary();

        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid numeric salary.");
        } finally {
            scanner.close();
            System.out.println("Program execution completed.");
        }
    }
}
