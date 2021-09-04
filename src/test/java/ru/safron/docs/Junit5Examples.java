package ru.safron.docs;

import org.junit.jupiter.api.*;

public class Junit5Examples {

    @BeforeAll
    static void beforeAll(){
        System.out.println("Before all!\n");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("After all!\n");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("Before\n");
    }

    @AfterEach
    void afterEach(){
        System.out.println("After\n");
    }

    @Test
    void firstTest() {
        System.out.println("Blyaha-muha\n");
    }

    @Test
    void SecondTest() {
        System.out.println("Second\n");
    }
}
