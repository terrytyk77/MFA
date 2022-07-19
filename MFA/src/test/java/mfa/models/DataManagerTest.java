
package mfa.models;

import mfa.controllers.AuthenticationInterface;
import mfa.enums.AuthenticationMethod;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Terry Keyrouz
 */
public class DataManagerTest {
    
    private final DataManager instance;
    private final AuthenticationInterface EmailAuth;
    private final AuthenticationInterface MobileAuth;
    private final AuthenticationInterface ApplicationAuth;
    private static final HashMap<AuthenticationMethod, String> authenticationStrings = new HashMap<>();
    
    public DataManagerTest(){
        instance = DataManager.getInstance();
        EmailAuth = instance.getAuthenticationMethod(AuthenticationMethod.EMAIL);
        MobileAuth = instance.getAuthenticationMethod(AuthenticationMethod.MOBILE);
        ApplicationAuth = instance.getAuthenticationMethod(AuthenticationMethod.APPLICATION);

        // Populating the auth messages
        authenticationStrings.put(AuthenticationMethod.EMAIL, "Email");
        authenticationStrings.put(AuthenticationMethod.MOBILE, "Mobile");
        authenticationStrings.put(AuthenticationMethod.APPLICATION, "Application");
    }


    /**
     * Test of getUser method, of class DataManager.
     */
    @ParameterizedTest
    @CsvSource({"Terry, true", "Tom, false", "terry, false", "Ali, true"})
    public void testGetUser(String name, Boolean expectedResult) {
        boolean result = instance.getUser(name);
        assertEquals(expectedResult, result);
    }

    /**
     * Test of confirmUserPassword method, of class DataManager.
     */
    @ParameterizedTest
    @CsvSource({"Terry, 12345, true", "Tom, 12345, false", " No, No, false", "Ali, Apple13, false"})
    public void testConfirmUserPassword(String name, String password, boolean expectedResult) {
        boolean result = instance.confirmUserPassword(name, password);
        assertEquals(expectedResult, result);
    }

    /**
     * Test of getAuthenticationMethod method, of class DataManager.
     */
    @Test
    public void getAuthenticationMethod() {
        assertEquals(instance.getAuthenticationMethod(AuthenticationMethod.EMAIL), EmailAuth);
        assertEquals(instance.getAuthenticationMethod(AuthenticationMethod.MOBILE), MobileAuth);
        assertEquals(instance.getAuthenticationMethod(AuthenticationMethod.APPLICATION), ApplicationAuth);
        assertNotNull(instance.getAuthenticationMethod(AuthenticationMethod.EMAIL));
        assertNull(instance.getAuthenticationMethod(null));
    }

    /**
     * Test of getAuthenticationStrings method, of class DataManager.
     */
    @Test
    public void getAuthenticationStrings() {
        assertEquals(instance.getAuthenticationStrings(), authenticationStrings);
    }
}
