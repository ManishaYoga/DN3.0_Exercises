public class DependencyInjectionTest {
    public static void main(String[] args) {
        // Create a repository instance
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        // Create a service instance with repository injected
        CustomerService customerService = new CustomerService(customerRepository);

        // Use the service to find a customer
        Customer customer = customerService.getCustomer("123");
        if (customer != null) {
            System.out.println("Customer found: " + customer.getName());
        } else {
            System.out.println("Customer not found.");
        }
    }
}
