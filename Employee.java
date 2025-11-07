// Employee.java
// Represents an Employee entity with basic details and salary calculation.

public class Employee {
    private int employeeID;
    private String name;
    private double salary;
    private String department;

    // Constructor
    public Employee(int employeeID, String name, double salary, String department) {
        this.employeeID = employeeID;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    // Getters and Setters
    public int getEmployeeID() { return employeeID; }
    public void setEmployeeID(int employeeID) { this.employeeID = employeeID; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    // Calculate total salary after tax deduction
    public double getNetSalary() {
        double tax = 0.10 * salary; // 10% tax
        return salary - tax;
    }

    // Display employee details
    public void displayInfo() {
        System.out.println("-------------------------------------");
        System.out.println("Employee ID   : " + employeeID);
        System.out.println("Name          : " + name);
        System.out.println("Department    : " + department);
        System.out.println("Salary        : " + salary);
        System.out.println("Net Salary(10% tax): " + getNetSalary());
        System.out.println("-------------------------------------");
    }
}

