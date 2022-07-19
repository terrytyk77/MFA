package mfa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Terry Keyrouz
 */

public class MainTest {
    @BeforeAll
    static void setData(){

    }

    /**
     * Test of setWelcomeMessage method, of class ApplicationLayout.
     */
    @Test
    void MainTest(){
        String OS = System.getProperty("os.name");
        Assertions.assertEquals("Windows 10", OS);
    }

}
