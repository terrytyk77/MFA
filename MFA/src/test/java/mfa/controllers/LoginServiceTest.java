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
public class LoginServiceTest {
    private ByteArrayInputStream in;
    private LoginService loginService;
    
    public LoginServiceTest() {
        loginService = new LoginService("Terry", "12345");
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
     * Test of getAuthenticationMethod method, of class LoginService.
     */
    @Test
    public void testGetAuthenticationMethod() {
        System.out.println("getAuthenticationMethod");
        assertNull(loginService.getAuthenticationMethod());
    }

    /**
     * Test of setAuthenticationMethod method, of class LoginService.
     */
    @Test
    public void testSetAuthenticationMethod() {
        System.out.println("setAuthenticationMethod");
        AuthenticationMobile auth = new AuthenticationMobile();
        loginService.setAuthenticationMethod(auth);
        assertEquals(loginService.getAuthenticationMethod(), auth);
    }

    /**
     * Test of loginAttempt method, of class LoginService.
     */
    @Test
    public void testLoginAttempt() throws InterruptedException {
        AuthenticationInterface auth = new AuthenticationMobile();
        loginService.setAuthenticationMethod(auth);
        in = new ByteArrayInputStream("33".getBytes());
        System.setIn(in);
        assertFalse(loginService.loginAttempt());
    }
    
    /**
     * Test of loginAttempt method, of class LoginService.
     */
    @Test
    public void testLoginAttempt2() throws InterruptedException {
        loginService = new LoginService("Terry", "12345");
        AuthenticationInterface auth1 = new AuthenticationApplication();
        loginService.setAuthenticationMethod(auth1);
        in = new ByteArrayInputStream("12".getBytes());
        System.setIn(in);
        System.out.println("12");
        assertFalse(loginService.loginAttempt());
    }
    
//    /**
//     * Test of loginAttempt method, of class LoginService.
//     */
    @Test
    public void testLoginAttempt3() throws InterruptedException {
        loginService = new LoginService("Terry", "12345");
        AuthenticationInterface auth2 = new AuthenticationEmail();
        loginService.setAuthenticationMethod(auth2);
        in = new ByteArrayInputStream("G-223".getBytes());
        System.setIn(in);
        assertFalse(loginService.loginAttempt());
    }
    
    /**
     * Test of loginAttempt method, of class LoginService.
     */
    @Test
    public void testLoginAttempt4() throws InterruptedException {
        loginService = new LoginService("", "12345");
        AuthenticationInterface auth = new AuthenticationEmail();
        loginService.setAuthenticationMethod(auth);
        in = new ByteArrayInputStream("33".getBytes());
        System.setIn(in);
        assertFalse(loginService.loginAttempt());
    }
    
    /**
     * Test of loginAttempt method, of class LoginService.
     */
    @Test
    public void testLoginAttempt5() throws InterruptedException {
        loginService = new LoginService("", "12345");
        AuthenticationInterface auth = new AuthenticationEmail();
        loginService.setAuthenticationMethod(auth);
        in = new ByteArrayInputStream("33".getBytes());
        System.setIn(in);
        assertFalse(loginService.loginAttempt());
    }
}
