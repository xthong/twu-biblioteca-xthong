package com.twu.biblioteca;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {

    BibliotecaApp bibliotecaApp = new BibliotecaApp();

    @Test
    public void testWelcomeMessage() {
        assertEquals(bibliotecaApp.welcomeMessage(), "Welcome to Biblioteca!!");
    }

    @Test
    public void testDefaultBookList() {
        String invalidOption = bibliotecaApp.showMenuOptions(0);
        assertEquals(invalidOption, "Please select a valid option!");
    }
}
