package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> bookList ;

    public Library(List<Book> bookList){
        this.bookList = bookList;
    }

    public List<Book> getBookList() {
        List<Book> books = new ArrayList<Book>();
        for (Book book : this.bookList){
            if (book.getStatus()){
                books.add(book);
            }
        }
        return books;
    }

    public String checkOut(int id) {
        Book book = this.getBookById(id);
        if (book.getStatus()){
            book.setStatus(false);
            return "Thank you! Enjoy the book.";
        }
        else {
            return "That book is not available.";
        }

    }

    public String returnBook(int id) {
        Book book = this.getBookById(id);
        if (book.getStatus()) {
            return "This book is no valid for return.";
        }
        book.setStatus(true);
        return "Thank you for returning the book.";
    }

    public Book getBookById(int id){
        for (Book book : this.bookList){
            if(book.getBookId() == id){
                return book;
            }
        }
        return null;
    }

}
