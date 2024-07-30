public class Main {
    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(10);

        // Add employees
        ems.addEmployee(new Employee(1, "Alice", "Manager", 75000));
        ems.addEmployee(new Employee(2, "Bob", "Developer", 55000));
        ems.addEmployee(new Employee(3, "Charlie", "Analyst", 60000));

        // Traverse employees
        System.out.println("Employee List:");
        ems.traverseEmployees();

        // Search for an employee
        System.out.println("Search Result:");
        Employee searchResult = ems.searchEmployee(2);
        System.out.println(searchResult != null ? searchResult : "Employee not found.");

        // Delete an employee
        ems.deleteEmployee(2);

        // Traverse employees after deletion
        System.out.println("Employee List After Deletion:");
        ems.traverseEmployees();
    }
}
