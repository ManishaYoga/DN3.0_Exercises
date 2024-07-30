public class EmployeeManagementSystem {
    private Employee[] employees;
    private int size;
    private int capacity;

    public EmployeeManagementSystem(int capacity) {
        this.capacity = capacity;
        this.employees = new Employee[capacity];
        this.size = 0;
    }

    // Add an employee
    public void addEmployee(Employee employee) {
        if (size >= capacity) {
            System.out.println("Array is full. Cannot add more employees.");
            return;
        }
        employees[size++] = employee;
    }

    // Search an employee by ID
    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null; // Return null if employee not found
    }

    // Traverse all employees
    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete an employee by ID
    public void deleteEmployee(int employeeId) {
        int deleteIndex = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                deleteIndex = i;
                break;
            }
        }
        if (deleteIndex == -1) {
            System.out.println("Employee not found.");
            return;
        }
        // Shift elements to the left to fill the gap
        for (int i = deleteIndex; i < size - 1; i++) {
            employees[i] = employees[i + 1];
        }
        employees[--size] = null; // Clear the last element
    }
}
