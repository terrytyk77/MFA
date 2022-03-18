/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package mfa.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
public class UtilityTest {
    private ByteArrayInputStream in;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    
    public UtilityTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of scan method, of class Utility.
     */
    @Test
    public void testScan() {
        in = new ByteArrayInputStream("Terry".getBytes());
        System.setIn(in);
        String result = Utility.scan("What is your name?");

        String expResult = "Terry";
        assertEquals(expResult, result);
    }

    /**
     * Test of println method, of class Utility.
     */
    @Test
    public void testPrintln() {
        String message = "Hey Test!";
        Utility.println(message);
        assertEquals("Hey Test!", outputStreamCaptor.toString().trim());
    }

    /**
     * Test of sendCode method, of class Utility.
     */
    @Test
    public void testSendCode() {
        System.out.println("sendCode");
        String fileName = "Terry.txt";
        String content = "123";
        Utility.sendCode(fileName, content);
    }
    
    @Test
    public void testSendCode2() {
        System.out.println("sendCode");
        String fileName = "Terry.txt";
        String content = "123";
        Utility.sendCode(fileName, content);
    }
    
}
