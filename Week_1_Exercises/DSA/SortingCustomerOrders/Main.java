public class Main {
    public static void main(String[] args) {
        Order[] orders = {
            new Order(1, "Alice", 300.50),
            new Order(2, "Bob", 150.75),
            new Order(3, "Charlie", 450.00),
            new Order(4, "David", 200.25),
            new Order(5, "Eve", 500.00)
        };

        // Bubble Sort
        BubbleSort.bubbleSort(orders);
        System.out.println("Orders sorted by Bubble Sort:");
        for (Order order : orders) {
            System.out.println(order);
        }

        // Quick Sort
        orders = new Order[]{
            new Order(1, "Alice", 300.50),
            new Order(2, "Bob", 150.75),
            new Order(3, "Charlie", 450.00),
            new Order(4, "David", 200.25),
            new Order(5, "Eve", 500.00)
        };
        QuickSort.quickSort(orders, 0, orders.length - 1);
        System.out.println("Orders sorted by Quick Sort:");
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
