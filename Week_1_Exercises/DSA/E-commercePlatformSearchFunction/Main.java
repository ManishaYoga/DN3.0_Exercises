public class Main {
    public static void main(String[] args) {
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Smartphone", "Electronics"),
            new Product(3, "Tablet", "Electronics"),
            new Product(4, "Headphones", "Accessories"),
            new Product(5, "Charger", "Accessories")
        };

        // Linear Search
        Product foundProductLinear = LinearSearch.linearSearch(products, "Tablet");
        System.out.println("Linear Search Result: " + foundProductLinear);

        // Binary Search
        Product foundProductBinary = BinarySearch.binarySearch(products, "Tablet");
        System.out.println("Binary Search Result: " + foundProductBinary);
    }
}
