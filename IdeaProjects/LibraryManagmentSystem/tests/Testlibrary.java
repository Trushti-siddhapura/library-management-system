import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Testlibrary {
    private Library library;

    @BeforeEach
    public void setUp() {
        library = new Library();
    }

    @Test
    public void testAddBook() {
        library.addBook("123", "Book Title", "Author Name", 2021);
        assertEquals(1, library.viewAvailableBooks().size());
    }

    @Test
    public void testBorrowBook() {
        library.addBook("123", "Book Title", "Author Name", 2021);
        assertTrue(library.borrowBook("123"));
        assertFalse(library.borrowBook("123")); // Book already borrowed
    }

    @Test
    public void testReturnBook() {
        library.addBook("123", "Book Title", "Author Name", 2021);
        library.borrowBook("123");
        library.returnBook("123");
        assertTrue(library.viewAvailableBooks().containsKey("123"));
    }

    @Test
    public void testViewAvailableBooks() {
        library.addBook("123", "Book Title", "Author Name", 2021);
        library.addBook("456", "Another Book", "Another Author", 2022);
        assertEquals(2, library.viewAvailableBooks().size());
        library.borrowBook("123");
        assertEquals(1, library.viewAvailableBooks().size());
    }
}
