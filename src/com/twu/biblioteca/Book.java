package com.twu.biblioteca;


public class Book {
    private int bookId;
    private String bookName;
    private String author;
    private String yearPublished;
    private boolean available;

    public Book(){}

    public Book(int bookId,String bookName,String author,String yearPublished) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.yearPublished = yearPublished;
        this.available = true;
    }

    public Book(int bookId,String bookName,String author,String yearPublished,boolean available) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.yearPublished = yearPublished;
        this.available = available;
    }

    public int getBookId() {
        return this.bookId;
    }

    public String getBookName() {
        return this.bookName;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getYearPublished() {
        return this.yearPublished;
    }

    public boolean getStatus() {
        return this.available;
    }

    public void setStatus(boolean status) {
        this.available = status;
    }


}
