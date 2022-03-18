/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package mfa.controllers;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Terry Keyrouz
 */
public class AuthenticationMobileTest {
   
    public AuthenticationMobileTest() {
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
     * Test of authenticate method, of class AuthenticationMobile.
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
