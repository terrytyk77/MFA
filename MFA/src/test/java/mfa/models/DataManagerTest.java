
package mfa.models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Terry Keyrouz
 */
public class DataManagerTest {
    
    private final DataManager instance;
    
    public DataManagerTest() {
        instance = DataManager.getInstance();
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
}
