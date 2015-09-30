package com.twu.biblioteca;

import java.util.Arrays;
import java.util.List;

public class BibliotecaApp {

    private static boolean status;
    private static Library defaultBooksInLibrary =new Library(Arrays.asList(new Book(1,"book1", "Ann", "2015"), new Book(2,"book2", "Kate", "2015")));
    public  static IReadInputData IReadInputData = new ReadInputData();


    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        System.out.println(bibliotecaApp.welcomeMessage());
        status = true;
        while (status){
            bibliotecaApp.showDefaultBookList();
            int option = Integer.parseInt(IReadInputData.readInputData("Menu Options:"));
            System.out.println(bibliotecaApp.showMenuOptions(option));
        }
    }

    public String welcomeMessage() {
        return "Welcome to Biblioteca!!";
    }

    private void showDefaultBookList() {
        String[] menuOptions = getMenuOptions();
        System.out.println("Menu : ");
        for (String option : menuOptions){
            System.out.println(option);
        }
    }

    public String[] getMenuOptions() {
        return new String[]{"1: get book lists","2:check out a book","3:return a book","4: quit"};
    }

    public String showMenuOptions(int option) {
        String message = "";
        switch (option){
            case 1:
                message = getBookListsOperation();
                break;
            case 2:message = checkOutBook();
                break;
            case 3:message = returnBook();
                break;
            case 4:
                message = Logout();
                break;
            default:
                message = showInvalidMessage();
        }
        return message;
    }


    private String getBookListsOperation() {
        printBookList(defaultBooksInLibrary.getBookList());
        return "Get BookList Success !";
    }

    private void printBookList(List<Book> booksList) {
        System.out.println("bookList: ");
        System.out.println("Id|" +"Name|" + "Author|" + "Year|");
        for (Book book :booksList){
            System.out.print(book.getBookId()+"|");
            System.out.print(book.getBookName()+"|");
            System.out.print(book.getAuthor() + "|");
            System.out.print(book.getYearPublished()+"|");
            System.out.print(book.getStatus());
            System.out.println();
        }
    }

    private String checkOutBook() {
        Integer bookId = Integer.parseInt(IReadInputData.readInputData("Input book id :"));
        return defaultBooksInLibrary.checkOut(bookId);
    }

    private String returnBook() {
        Integer bookId = Integer.parseInt(IReadInputData.readInputData("Input the book id you want to return :"));
        return defaultBooksInLibrary.returnBook(bookId);
    }

    private String showInvalidMessage() {
        return "Please select a valid option!";
    }

    private String Logout() {
        status=false;
        return "Quit success!";
    }



}
