/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package mfa.models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Darkness
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
     * Test of getInstance method, of class DataManager.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        DataManager expResult = instance;
        DataManager result = DataManager.getInstance();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUser method, of class DataManager.
     */
    @Test
    public void testGetUser1() {
        System.out.println("getUser");
        String name = "Joe"; // Doesn't exist
        boolean expResult = false;
        boolean result = instance.getUser(name);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getUser method, of class DataManager.
     */
    @Test
    public void testGetUser2() {
        System.out.println("getUser");
        String name = "Terry"; // Exists
        boolean expResult = true;
        boolean result = instance.getUser(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of confirmUserPassword method, of class DataManager.
     */
    @Test
    public void testConfirmUserPassword1() {
        System.out.println("confirmUserPassword");
        String name = "Terry"; // Exist
        String password = "12345"; // Correct pass
        boolean expResult = true;
        boolean result = instance.confirmUserPassword(name, password);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of confirmUserPassword method, of class DataManager.
     */
    @Test
    public void testConfirmUserPassword2() {
        System.out.println("confirmUserPassword");
        String name = "Joe"; //Doesn't exist
        String password = "";
        boolean expResult = false;
        boolean result = instance.confirmUserPassword(name, password);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of confirmUserPassword method, of class DataManager.
     */
    @Test
    public void testConfirmUserPassword3() {
        System.out.println("confirmUserPassword");
        String name = "Terry"; //Exists
        String password = ""; // Wrong pass
        boolean expResult = false;
        boolean result = instance.confirmUserPassword(name, password);
        assertEquals(expResult, result);
    }
    
}
