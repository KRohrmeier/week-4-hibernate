package edu.matc.persistence;

import edu.matc.entity.Book;
import edu.matc.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// TODO add unit tests to achieve 100% code coverage of your dao.
// TODO You should run these tests repeatedly, in any order, and they should all pass every time!
// TODO Javadoc comments
class BookDaoTest {
    BookDao dao;

    @BeforeEach
    void setUp() {
        dao = new BookDao();
        // set up db afresh
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    @Test
    void getByIdSuccess() {
        Book returnedBook = dao.getById(2);
        assertEquals("Beginning Hibernate", returnedBook.getTitle());
        assertEquals("Joseph Ottinger", returnedBook.getAuthor());
        assertEquals("978-1-4842-2319-2", returnedBook.getIsbn());
        assertEquals("2016", returnedBook.getPublicationYear());
    }

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

    @Test
    void insertSuccess() {
    }

    @Test
    void deleteSuccess() {
    }

    @Test
    void getAllSuccess() {
    }
}