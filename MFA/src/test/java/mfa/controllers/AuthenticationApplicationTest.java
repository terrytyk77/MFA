package mfa.controllers;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthenticationApplicationTest {
    public AuthenticationApplicationTest() {
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
     * Test of authenticate method, of class AuthenticationApplication.
     */
    @Test
    public void testAuthenticate() {
        String Input =  "Terry"
                + System.getProperty("line.separator")
                + "12345"
                + System.getProperty("line.separator");
        ByteArrayInputStream in = new ByteArrayInputStream(Input.getBytes());
        System.setIn(in);

        AuthenticationApplication instance = new AuthenticationApplication();
        Boolean expResult = false;
        Boolean result = instance.authenticate();

        assertEquals(expResult, result);
    }
}
