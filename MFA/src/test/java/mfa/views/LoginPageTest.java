/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package mfa.views;

import java.io.ByteArrayInputStream;
import mfa.controllers.AuthenticationMobile;
import mfa.controllers.LoginService;
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
public class LoginPageTest {
    LoginPage loginPage = new LoginPage();
    public LoginPageTest() {
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
     * Test of main method, of class LoginPage.
     */
    @Test
    public void testMain() throws InterruptedException {
        String Input =  "Terry"
                        + System.getProperty("line.separator")
                        + "12345"
                        + System.getProperty("line.separator")
                        + "1"
                        + System.getProperty("line.separator")
                        + "5"
                        + System.getProperty("line.separator");
        ByteArrayInputStream in = new ByteArrayInputStream(Input.getBytes());
        System.setIn(in);
    }
    
}
