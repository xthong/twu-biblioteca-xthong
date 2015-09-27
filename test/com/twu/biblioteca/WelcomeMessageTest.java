package com.twu.biblioteca;


import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static com.twu.biblioteca.BibliotecaApp.welcomeMessage;
import static org.junit.Assert.assertEquals;

public class WelcomeMessageTest {


    @Test
    public void testWelcomeMessage() {
        assertEquals(welcomeMessage(), "Welcome to Biblioteca!!");
    }
}
