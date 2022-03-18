package mfa.controllers;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthenticationEmailTest {
    public AuthenticationEmailTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of authenticate method, of class AuthenticationEmail.
     */
    @Test
    public void testAuthenticate() {
        String Input =  "Terry"
                + System.getProperty("line.separator")
                + "12345"
                + System.getProperty("line.separator");
        ByteArrayInputStream in = new ByteArrayInputStream(Input.getBytes());
        System.setIn(in);

        AuthenticationMobile instance = new AuthenticationMobile();
        Boolean expResult = false;
        Boolean result = instance.authenticate();

        assertEquals(expResult, result);
    }
}
