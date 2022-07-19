package mfa.controllers;


import java.util.HashMap;

import mfa.enums.AuthenticationMethod;
import mfa.utils.Tuple;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Terry Keyrouz
 */
public class LoginServiceTest {
    private static LoginService loginService;

    @BeforeAll
    public static void setUpClass() {
        loginService = new LoginService();
    }

    /**
     * Test of getAuthenticationStrings method, of class LoginService.
     */
    @Test
    public void getAuthenticationStringsTest(){
        HashMap<AuthenticationMethod, String> authenticationStrings = new HashMap<>();

        // Populating the auth messages
        authenticationStrings.put(AuthenticationMethod.EMAIL, "Email");
        authenticationStrings.put(AuthenticationMethod.MOBILE, "Mobile");
        authenticationStrings.put(AuthenticationMethod.APPLICATION, "Application");

       assertEquals(loginService.getAuthenticationStrings(), authenticationStrings);
    }

    /**
     * Test of setAuthenticationMethod method, of class LoginService.
     */
    // Commented out for the mutation testing!
//    @Test
//    public void testSetAuthenticationMethod1() {
//        assertEquals(loginService.multipleFactorAuthentication(AuthenticationMethod.EMAIL) , false);
//        assertEquals(loginService.multipleFactorAuthentication(AuthenticationMethod.MOBILE) , false);
//        assertEquals(loginService.multipleFactorAuthentication(AuthenticationMethod.APPLICATION) , false);
//    }

    /**
     * Test of loginAttempt method, of class LoginService.
     */
    @ParameterizedTest
    @CsvSource({"Terry, 12345, true", "Tom, 12345, false", " No, No, false", "Ali, Apple13, false"})
    public void testLoginAttempt(String name, String password, boolean expectedResult){
        Tuple<Boolean, String> response = loginService.loginAttempt(name, password);
        assertEquals(response.getFirst(), expectedResult);
    }
}
