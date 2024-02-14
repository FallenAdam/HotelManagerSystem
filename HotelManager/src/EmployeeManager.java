import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManager {
    private ArrayList<Employee> employees;

    public EmployeeManager() {
        employees = new ArrayList<>();
        readEmployeesFromFile();
    }

    // Method to add an employee
    public void addEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter position: ");
        String position = scanner.nextLine();
        System.out.print("Enter sex: ");
        String sex = scanner.nextLine();
        System.out.print("Enter salary: ");
        double salary = scanner.nextDouble();
        int id = Employee.generateRandomId();
        Employee employee = new Employee(id, position, sex, salary);
        employees.add(employee);
        saveEmployeesToFile();
        System.out.println("Employee added successfully with ID: " + id);
    }

    // Method to remove an employee
    public void removeEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ID of employee to remove: ");
        int id = scanner.nextInt();
        boolean removed = employees.removeIf(employee -> employee.getId() == id);
        if (removed) {
            saveEmployeesToFile();
            System.out.println("Employee with ID " + id + " removed successfully.");
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    // Method to view all employees
    public void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees to display.");
        } else {
            System.out.println("List of Employees:");
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    // Method to save employees to file
    private void saveEmployeesToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employees.dat"))) {
            oos.writeObject(employees);
        } catch (IOException e) {
            System.out.println("Error saving employees to file: " + e.getMessage());
        }
    }

    // Method to read employees from file
    private void readEmployeesFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employees.dat"))) {
            employees = (ArrayList<Employee>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading employees from file: " + e.getMessage());
        }
    }
    static void manageEmployees() {
        Scanner scanner = new Scanner(System.in);
        EmployeeManager employeeManager = new EmployeeManager();

        int choice;
        do {
            System.out.println("\nEmployee Management Menu:");
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. View Employees");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    employeeManager.addEmployee();
                    break;
                case 2:
                    employeeManager.removeEmployee();
                    break;
                case 3:
                    employeeManager.viewEmployees();
                    break;
                case 4:
                    System.out.println("Exiting Employee Management Menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

}
