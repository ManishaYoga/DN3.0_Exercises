public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Customer findCustomerById(String id) {
        // Mock implementation - In a real scenario, this would interact with a database
        if ("123".equals(id)) {
            return new Customer(id, "John Doe");
        }
        return null;
    }
}
