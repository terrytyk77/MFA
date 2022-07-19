
package mfa.utils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Terry Keyrouz
 */
public class UtilityTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    /**
     * Test of scan method, of class Utility.
     */
    // Commented Out for the mutation testing to work
//    @Test
//    public void testScan() {
//        ByteArrayInputStream in = new ByteArrayInputStream("Terry".getBytes());
//        System.setIn(in);
//        String result = Utility.scan("What is your name?");
//
//        String expResult = "Terry";
//        assertEquals(expResult, result);
//    }

    /**
     * Test of println method, of class Utility.
     */
    @Test
    public void printlnTest() {
        String message = "Hey Test!";
        Utility.println(message);
        assertEquals("Hey Test!", outputStreamCaptor.toString().trim());
    }

    /**
     * Test of sendCode method, of class Utility.
     */
    @Test
    public void sendCodeTest() {
        System.out.println("sendCode");
        String fileName = "Terry.txt";
        String content = "123";
        Utility.sendCode(fileName, content);
    }
    
    @Test
    public void sendCodeTest2() {
        System.out.println("sendCode");
        String fileName = "longName" +
                "999999999999999999999999999999999999" +
                "999999999999999999999999999999999999" +
                "999999999999999999999999999999999999" +
                "999999999999999999999999999999999999" +
                "999999999999999999999999999999999999" +
                "999999999999999999999999999999999999" +
                "999999999999999999999999999999999999" +
                "999999999999999999999999999999999999";
        String content = "123";
        Utility.sendCode(fileName, content);
    }
    
}
