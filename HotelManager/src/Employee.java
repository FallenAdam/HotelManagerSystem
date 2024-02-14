import java.util.Random;

public class Employee {
    private int id;
    private String position;
    private String sex;
    private double salary;

    public Employee(int id, String position, String sex, double salary) {
        this.id = id;
        this.position = position;
        this.sex = sex;
        this.salary = salary;
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public String getPosition() {
        return position;
    }

    public String getSex() {
        return sex;
    }

    public double getSalary() {
        return salary;
    }

    // Method to generate random employee ID
    public static int generateRandomId() {
        Random random = new Random();
        return 10000000 + random.nextInt(90000000);
    }

    @Override
    public String toString() {
        return "Employee ID: " + id +
                "\nPosition: " + position +
                "\nSex: " + sex +
                "\nSalary: $" + salary;
    }
}
