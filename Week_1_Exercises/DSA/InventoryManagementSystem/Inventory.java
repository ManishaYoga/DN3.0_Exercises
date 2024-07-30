import java.util.HashMap;

public class Inventory {
    private HashMap<Integer, Product> products;

    public Inventory() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product) {
        if (products.containsKey(product.getProductId())) {
            throw new IllegalArgumentException("Product ID already exists.");
        }
        products.put(product.getProductId(), product);
    }

    public void updateProduct(int productId, String productName, Integer quantity, Double price) {
        Product product = products.get(productId);
        if (product == null) {
            throw new IllegalArgumentException("Product not found.");
        }
        if (productName != null) {
            product.setProductName(productName);
        }
        if (quantity != null) {
            product.setQuantity(quantity);
        }
        if (price != null) {
            product.setPrice(price);
        }
    }

    public void deleteProduct(int productId) {
        if (!products.containsKey(productId)) {
            throw new IllegalArgumentException("Product not found.");
        }
        products.remove(productId);
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "products=" + products +
                '}';
    }
}