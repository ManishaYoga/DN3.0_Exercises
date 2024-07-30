public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        // Add products
        Product product1 = new Product(1, "Laptop", 10, 999.99);
        Product product2 = new Product(2, "Smartphone", 50, 499.99);
        inventory.addProduct(product1);
        inventory.addProduct(product2);

        // Update a product
        inventory.updateProduct(1, null, 8, 949.99);

        // Delete a product
        inventory.deleteProduct(2);

        // Print the inventory
        System.out.println(inventory);
    }
}
