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
    private LoginService loginService;
    
    public LoginServiceTest() {
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
        loginService = new LoginService("Terry", "12345");
        assertNull(loginService.getAuthenticationMethod());
    }

    /**
     * Test of setAuthenticationMethod method, of class LoginService.
     */
    @Test
    public void testSetAuthenticationMethod1() {
        loginService = new LoginService("Terry", "12345");
        AuthenticationInterface instance = new AuthenticationMobile();
        loginService.setAuthenticationMethod(instance);

        String Input =  "5"
                        + System.getProperty("line.separator");
        ByteArrayInputStream in = new ByteArrayInputStream(Input.getBytes());
        System.setIn(in);


        Boolean expResult = false;
        Boolean result = loginService.multipleFactorAuthentication();

        assertEquals(expResult, result);
    }

    /**
     * Test of setAuthenticationMethod method, of class LoginService.
     */
    @Test
    public void testSetAuthenticationMethod2() {
        loginService = new LoginService("Terry", "12345");
        AuthenticationInterface instance = new AuthenticationEmail();
        loginService.setAuthenticationMethod(instance);

        String Input =  "5"
                + System.getProperty("line.separator");
        ByteArrayInputStream in = new ByteArrayInputStream(Input.getBytes());
        System.setIn(in);


        Boolean expResult = false;
        Boolean result = loginService.multipleFactorAuthentication();

        assertEquals(expResult, result);
    }

    /**
     * Test of setAuthenticationMethod method, of class LoginService.
     */
    @Test
    public void testSetAuthenticationMethod3() {
        loginService = new LoginService("Terry", "12345");
        AuthenticationInterface instance = new AuthenticationMobile();
        loginService.setAuthenticationMethod(instance);

        String Input =  "5"
                + System.getProperty("line.separator");
        ByteArrayInputStream in = new ByteArrayInputStream(Input.getBytes());
        System.setIn(in);


        Boolean expResult = false;
        Boolean result = loginService.multipleFactorAuthentication();

        assertEquals(expResult, result);
    }

    /**
     * Test of loginAttempt method, of class LoginService.
     */
    @Test
    public void testLoginAttempt() throws InterruptedException {
        loginService = new LoginService("Terry", "1234");
        assertFalse(loginService.loginAttempt());
    }
    
    /**
     * Test of loginAttempt method, of class LoginService.
     */
    @Test
    public void testLoginAttempt2() throws InterruptedException {
        loginService = new LoginService("terry", "12345");
        assertFalse(loginService.loginAttempt());
    }
    
//    /**
//     * Test of loginAttempt method, of class LoginService.
//     */
    @Test
    public void testLoginAttempt3() throws InterruptedException {
        loginService = new LoginService("Terry", "12345");
        assertTrue(loginService.loginAttempt());
    }
}
