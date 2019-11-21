package com.matthewharrop.part1assignment2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Book {

    Long id;
    String isbn;
    String title;
    Float price;

    private static Logger logger = LoggerFactory.getLogger(
            Book.class);

    public void setId(Long id) {
        this.id = id;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setPrice(Float price) {
        this.price = price;
    }

    public void reading() {
        logger.info("Reading " + title + " book");
    }

    public void throwException() throws RuntimeException {
        throw new RuntimeException("Book Bean Exception");
    }


    public String toString() {
        String bookString = "Book - ID: " + id + ", ISBN: " + isbn + ", Title: " + title +
                ", Price: " + price;
        return bookString;
    }

    public Book() {
    }

    public Book(Long id, String isbn, String title, Float price) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.price = price;
    }

}
