class Employee {
    private int employeeId;
    private String name;
    private String position;
    private double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}

class EmployeeManager {
    private Employee[] employees;
    private int count;

    public EmployeeManager(int size) {
        employees = new Employee[size];
        count = 0;
    }

    public void addEmployee(Employee employee) {
        if (count < employees.length) {
            employees[count++] = employee;
        } else {
            System.out.println("Employee array is full. Cannot add more employees.");
        }
    }

    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    public void deleteEmployee(int employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                employees[i] = employees[--count];
                employees[count] = null;
                System.out.println("Employee with ID " + employeeId + " deleted.");
                return;
            }
        }
        System.out.println("Employee with ID " + employeeId + " not found.");
    }

    public void traverseEmployees() {
        if (count == 0) {
            System.out.println("No employees to display.");
        } else {
            for (int i = 0; i < count; i++) {
                System.out.println(employees[i]);
            }
        }
    }
}

public class EmployeeManagementDemo {
    public static void main(String[] args) {
        EmployeeManager employeeManager = new EmployeeManager(10);

        Employee emp1 = new Employee(1, "Alice", "Developer", 75000);
        Employee emp2 = new Employee(2, "Bob", "Manager", 85000);
        Employee emp3 = new Employee(3, "Charlie", "Analyst", 65000);

        employeeManager.addEmployee(emp1);
        employeeManager.addEmployee(emp2);
        employeeManager.addEmployee(emp3);

        System.out.println("Employees after adding:");
        employeeManager.traverseEmployees();

        System.out.println("\nSearching for employee with ID 2:");
        Employee searchedEmployee = employeeManager.searchEmployee(2);
        if (searchedEmployee != null) {
            System.out.println("Found: " + searchedEmployee);
        } else {
            System.out.println("Employee not found.");
        }

        System.out.println("\nDeleting employee with ID 3:");
        employeeManager.deleteEmployee(3);

        System.out.println("\nEmployees after deletion:");
        employeeManager.traverseEmployees();
    }
}
