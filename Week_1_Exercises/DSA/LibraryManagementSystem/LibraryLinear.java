public class LibraryLinear {
    private Book[] books;

    public LibraryLinear(Book[] books) {
        this.books = books;
    }

    // Linear search to find books by title
    public Book linearSearchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null; // Return null if book not found
    }
}
