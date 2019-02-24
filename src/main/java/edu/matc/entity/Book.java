package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
/**
 *
 * TODO add hibernate annotations
 * TODO Javadoc comments
 */
@Entity(name = "Book")
@Table(name = "book")
public class Book {
    private String title;
    private String author;
    private int id;
    private String isbn;
    private int publicationYear;

    public Book() {
    }


    public Book(String title, String author, int id, String isbn, int publicationYear) {
        this.title = title;
        this.author = author;
        this.id = id;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
