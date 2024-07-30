import java.util.Arrays;
import java.util.Comparator;

public class LibraryBinary {
    private Book[] books;

    public LibraryBinary(Book[] books) {
        this.books = books;
        Arrays.sort(this.books, Comparator.comparing(Book::getTitle));
    }

    // Binary search to find books by title
    public Book binarySearchByTitle(String title) {
        int left = 0;
        int right = books.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                return books[mid];
            }

            if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; // Return null if book not found
    }
}
