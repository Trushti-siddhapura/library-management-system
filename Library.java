import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<String, Book> books = new HashMap<>();

    // Adds a new book to the library
    public void addBook(String isbn, String title, String author, int year) {
        Book book = new Book(isbn, title, author, year);
        books.put(isbn, book);
    }

    // Borrows a book from the library if it is available
    public boolean borrowBook(String isbn) {
        Book book = books.get(isbn);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            return true;
        }
        return false; // Book is either not found or not available
    }

    // Returns a borrowed book to the library
    public void returnBook(String isbn) {
        Book book = books.get(isbn);
        if (book != null) {
            book.setAvailable(true);
        }
    }

    // Views all available books in the library
    public Map<String, Book> viewAvailableBooks() {
        Map<String, Book> availableBooks = new HashMap<>();
        for (Map.Entry<String, Book> entry : books.entrySet()) {
            if (entry.getValue().isAvailable()) {
                availableBooks.put(entry.getKey(), entry.getValue());
            }
        }
        return availableBooks;
    }
}

class Book {
    private String isbn;
    private String title;
    private String author;
    private int year;
    private boolean isAvailable;

    public Book(String isbn, String title, String author, int year) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
        this.isAvailable = true; // By default, a new book is available
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
