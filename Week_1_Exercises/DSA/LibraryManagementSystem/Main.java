public class Main {
    public static void main(String[] args) {
        Book[] books = {
            new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"),
            new Book(2, "To Kill a Mockingbird", "Harper Lee"),
            new Book(3, "1984", "George Orwell"),
            new Book(4, "Pride and Prejudice", "Jane Austen"),
            new Book(5, "The Catcher in the Rye", "J.D. Salinger")
        };

        // Linear search example
        LibraryLinear libraryLinear = new LibraryLinear(books);
        System.out.println("Linear Search:");
        Book linearSearchResult = libraryLinear.linearSearchByTitle("1984");
        System.out.println(linearSearchResult != null ? linearSearchResult : "Book not found.");

        // Binary search example
        LibraryBinary libraryBinary = new LibraryBinary(books);
        System.out.println("Binary Search:");
        Book binarySearchResult = libraryBinary.binarySearchByTitle("1984");
        System.out.println(binarySearchResult != null ? binarySearchResult : "Book not found.");
    }
}
