package edu.matc.persistence;

import edu.matc.entity.Book;
import edu.matc.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The tests for BookDao.
 */
class BookDaoTest {
    /**
     * The Dao.
     */
    BookDao dao;

    /**
     * Sets up before each test for fresh database and instantiates a new BookDao
     */
    @BeforeEach
    void setUp() {
        dao = new BookDao();
        // set up db afresh
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * verifies that getById successfully runs
     */
    @Test
    void getByIdSuccess() {
        Book returnedBook = dao.getById(2);
        assertEquals("Beginning Hibernate", returnedBook.getTitle());
        assertEquals("Joseph Ottinger", returnedBook.getAuthor());
        assertEquals("978-1-4842-2319-2", returnedBook.getIsbn());
        assertEquals(2016, returnedBook.getPublicationYear());
    }

    /**
     * verifies that saveOrUpdate successfully runs
     */
    @Test
    void saveOrUpdateSuccess() {
        int id = 1;
        String newTitle = "All Java All the Time";
        Book bookToUpdate = dao.getById(id);
        bookToUpdate.setTitle(newTitle);
        dao.saveOrUpdate(bookToUpdate);
        Book returnedBook = dao.getById(id);
        assertEquals(newTitle, returnedBook.getTitle());
    }

    /**
     * verifies that insert successfully runs
     */
    @Test
    void insertSuccess() {
        Book newBook = new Book("Sundry Tales of Woe and Wonder", "Kathrin Kohler", "111-55-2215", 2019);
        int newBookId = dao.insert(newBook);
        assertNotEquals(0, newBookId);
        Book addedBook = dao.getById(newBookId);
        assertEquals("Kathrin Kohler", addedBook.getAuthor());
        assertEquals("Sundry Tales of Woe and Wonder", addedBook.getTitle());
        assertEquals(2019, addedBook.getPublicationYear());
    }

    /**
     * verifies that delete successfully runs
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(1));
        assertNull(dao.getById(1));
    }

    /**
     * verifies that getAll successfully runs
     */
    @Test
    void getAllSuccess() {
        List<Book> booksInLibrary = dao.getAll();
        int expectedBookCount = 3;
        assertEquals(expectedBookCount, booksInLibrary.size());
    }
}