import java.util.Arrays;

class Book {
    private int bookId;
    private String title;
    private String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

class Library {
    private Book[] books;

    public Library(Book[] books) {
        this.books = books;
    }

    // Linear search for a book by title
    public Book linearSearchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Binary search for a book by title (assuming the array is sorted by title)
    public Book binarySearchByTitle(String title) {
        int low = 0;
        int high = books.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = title.compareToIgnoreCase(books[mid].getTitle());
            if (cmp < 0) {
                high = mid - 1;
            } else if (cmp > 0) {
                low = mid + 1;
            } else {
                return books[mid];
            }
        }
        return null;
    }
}

public class LibraryDemo {
    public static void main(String[] args) {
        Book[] books = {
            new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"),
            new Book(2, "1984", "George Orwell"),
            new Book(3, "To Kill a Mockingbird", "Harper Lee"),
            new Book(4, "Pride and Prejudice", "Jane Austen")
        };

        // Sort books by title for binary search
        Arrays.sort(books, (a, b) -> a.getTitle().compareToIgnoreCase(b.getTitle()));

        Library library = new Library(books);

        // Linear Search
        System.out.println("Linear Search:");
        String searchTitle = "1984";
        Book foundBook = library.linearSearchByTitle(searchTitle);
        if (foundBook != null) {
            System.out.println("Found: " + foundBook);
        } else {
            System.out.println("Book with title \"" + searchTitle + "\" not found.");
        }

        // Binary Search
        System.out.println("\nBinary Search:");
        searchTitle = "Pride and Prejudice";
        foundBook = library.binarySearchByTitle(searchTitle);
        if (foundBook != null) {
            System.out.println("Found: " + foundBook);
        } else {
            System.out.println("Book with title \"" + searchTitle + "\" not found.");
        }
    }
}
