package com.twu.biblioteca;

import java.util.Arrays;
import java.util.List;

public class BibliotecaApp {

    private static boolean status;
    private static Library defaultBooksInLibrary =new Library(Arrays.asList(new Book(1,"book1", "Ann", "2015"), new Book(2,"book2", "Kate", "2015")));
    public static MovieLibrary defaultMoviesInLibrary = new MovieLibrary(Arrays.asList(new Movie("movie1","2015", "Green", 3),new Movie("movie2", "2015", "Sam", 5)));
    public  static IReadInputData IReadInputData = new ReadInputData();
    private static UserHelper userHelper =new UserHelper();
    private static CurrentUser currentUser;


    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        System.out.println(bibliotecaApp.welcomeMessage());
        currentUser = getCurrentUser();
        status = userHelper.logIn(currentUser);
        if (!status){
            System.out.println("logIn failed !");
        }

        while (status){
            bibliotecaApp.showDefaultBookList();
            int option = Integer.parseInt(IReadInputData.readInputData("Menu Options:"));
            System.out.println(bibliotecaApp.showMenuOptions(option));
        }
    }

    public String welcomeMessage() {
        return "Welcome to Biblioteca!!";
    }

    private static CurrentUser getCurrentUser() {
        String name = IReadInputData.readInputData("user Name: ");
        String password = IReadInputData.readInputData("input PassWord: ");
        return new CurrentUser(name,password);
    }

    private void showDefaultBookList() {
        String[] menuOptions = getMenuOptions();
        System.out.println("Menu : ");
        for (String option : menuOptions){
            System.out.println(option);
        }
    }

    public String[] getMenuOptions() {
        return new String[]{
                "1: get book lists",
                "2:check out a book",
                "3:return a book",
                "4:getMoviesList",
                "5:checkoutMovie",
                "6:getUserDetail",
                "7: quit"};
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
            case 4:message = getMoviesList();
                break;
            case 5:message = checkoutMovie();
                break;
            case 6:message = getUserInfo();
                break;
            case 7:
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

    public static String getMoviesList() {
        printMovieList(defaultMoviesInLibrary.getMoviesList());
        return "sucess";
    }

    private static void printMovieList(List<Movie> moviesList) {
        System.out.println("movieList: ");
        System.out.println("Name|" + "Director|" + "Year|"+"Rate|");
        for (Movie movie :moviesList){
            System.out.print(movie.getName()+"|");
            System.out.print(movie.getDirector() + "|");
            System.out.print(movie.getYear()+"|");
            System.out.print(movie.getRate());
            System.out.println();
        }
    }

    private static String checkoutMovie() {
        String movieName = IReadInputData.readInputData("input movie Name :");
        return defaultMoviesInLibrary.checkout(movieName);
    }

    private static String getUserInfo() {
        printUserInfo(userHelper.getUserDetail(currentUser.getName()));
        return "success";
    }

    private static void printUserInfo(BibliotecaAppUser userDetail) {
        System.out.println("UserInfo: ");
        System.out.println("Name|" + "EmailAddress|" + "PhoneNumber|");
        System.out.print(userDetail.getName() + "|");
        System.out.print(userDetail.getEmailAddress() + "|");
        System.out.print(userDetail.getPhoneNumber() + "|");
        System.out.println();

    }


    private String showInvalidMessage() {
        return "Please select a valid option!";
    }

    private String Logout() {
        status=false;
        return "Quit success!";
    }



}
