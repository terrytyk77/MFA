
package mfa.views;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Terry Keyrouz
 */
public class LoginPageTest {

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
    public void testMain() {
        InputStream sysInBackup = System.in; // backup System.in to restore it later
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

        // do your thing

        // optionally, reset System.in to its original
        System.setIn(sysInBackup);

    }
}
