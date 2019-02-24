package edu.matc.persistence;

import edu.matc.entity.Book;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * TODO At minimum create methods to create, read, update, and delete Books.
 * TODO a logger is used here, be sure to set up a log4j2.properties file
 */
public class BookDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get book by id
     */
    public Book getById(int id) {

        return null;
    }

    /**
     * update book
     * @param book  Book to be inserted or updated
     */
    public void saveOrUpdate(Book book) {

    }

    /**
     * update Book
     * @param book  Book to be inserted or updated
     */
    public int insert(Book book) {
        return 0;
    }

    /**
     * Delete a book
     * @param book Book to be deleted
     */
    public void delete(Book book) {

    }


    /** Return a list of all books
     *
     * @return All books
     */
    public List<Book> getAll() {

        return null;
    }



}
