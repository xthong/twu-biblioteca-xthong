package com.twu.biblioteca;

import java.util.Scanner;


public class ReadInputData implements IReadInputData {
    public String readInputData(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        return scanner.nextLine();
    }
}
