// EmployeeManagementSystem.java
// Console-based program for managing employee records with validation and error handling.
// Compatible with Java 8

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeManagementSystem {

    private static final ArrayList<Employee> employeeList = new ArrayList<Employee>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = 0;

        while (choice != 5) {
            try {
                System.out.println("\n====== Employee Management System ======");
                System.out.println("1. Add Employee");
                System.out.println("2. View Employees");
                System.out.println("3. Update Employee");
                System.out.println("4. Delete Employee");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        addEmployee();
                        break;
                    case 2:
                        viewEmployees();
                        break;
                    case 3:
                        updateEmployee();
                        break;
                    case 4:
                        deleteEmployee();
                        break;
                    case 5:
                        System.out.println("Exiting... Thank you!");
                        break;
                    default:
                        System.out.println("Invalid choice! Please enter 1-5.");
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }
        scanner.close();
    }

    private static void addEmployee() {
        try {
            System.out.print("Enter Employee ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            for (Employee emp : employeeList) {
                if (emp.getEmployeeID() == id) {
                    System.out.println("Employee ID already exists! Try again.");
                    return;
                }
            }

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Salary: ");
            double salary = scanner.nextDouble();
            scanner.nextLine();

            if (salary < 0) {
                System.out.println("Salary cannot be negative!");
                return;
            }

            System.out.print("Enter Department: ");
            String department = scanner.nextLine();

            Employee emp = new Employee(id, name, salary, department);
            employeeList.add(emp);
            System.out.println("Employee added successfully!");

        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter valid numbers for ID and salary.");
            scanner.nextLine();
        }
    }

    private static void viewEmployees() {
        if (employeeList.isEmpty()) {
            System.out.println("No employees found!");
            return;
        }

        System.out.println("\n------ Employee Details ------");
        for (Employee emp : employeeList) {
            emp.displayInfo();
        }
    }

    private static void updateEmployee() {
        try {
            System.out.print("Enter Employee ID to update: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            Employee empToUpdate = findEmployeeById(id);
            if (empToUpdate == null) {
                System.out.println("Employee not found!");
                return;
            }

            System.out.println("1. Update Salary");
            System.out.println("2. Update Department");
            System.out.print("Choose option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                System.out.print("Enter new salary: ");
                double newSalary = scanner.nextDouble();
                if (newSalary < 0) {
                    System.out.println("Salary cannot be negative!");
                    return;
                }
                empToUpdate.setSalary(newSalary);
                System.out.println("Salary updated successfully!");
            } else if (option == 2) {
                System.out.print("Enter new department: ");
                String newDept = scanner.nextLine();
                empToUpdate.setDepartment(newDept);
                System.out.println("Department updated successfully!");
            } else {
                System.out.println("Invalid option!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter numbers only.");
            scanner.nextLine();
        }
    }

    private static void deleteEmployee() {
        try {
            System.out.print("Enter Employee ID to delete: ");
            int id = scanner.nextInt();

            Employee empToDelete = findEmployeeById(id);
            if (empToDelete == null) {
                System.out.println("Employee not found!");
                return;
            }

            employeeList.remove(empToDelete);
            System.out.println("Employee deleted successfully!");
        } catch (InputMismatchException e) {
            System.out.println("Invalid ID format! Please enter a number.");
            scanner.nextLine();
        }
    }

    private static Employee findEmployeeById(int id) {
        for (Employee emp : employeeList) {
            if (emp.getEmployeeID() == id) {
                return emp;
            }
        }
        return null;
    }
}
