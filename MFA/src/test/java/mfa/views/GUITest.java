
package mfa.views;

import org.junit.jupiter.api.*;

import javax.swing.*;

/**
 *
 * @author Terry Keyrouz
 */

// This class has to be commented out, for the mutation testing to work!
public class GUITest {
   private static WindowsGUI Windows;

    @BeforeAll
    static void setData(){
        LinuxGUI Linux = new LinuxGUI();
        Linux.start();

        MacGUI Mac = new MacGUI();
        Mac.start();

        Windows = new WindowsGUI();
        Windows.start();
    }

    /**
     * Test of setters method, of class GUI.
     */
    @Test
    void testSetters(){
        JPanel panel = new JPanel();

        Windows.setLoginPanel(null);
        Assertions.assertNull(Windows.loginPanel);

        Windows.setLoginPanel(panel);
        Windows.setAuthenticationPanel(panel);
        Windows.setApplicationPanel(panel);

        Assertions.assertEquals(Windows.loginPanel, panel);
        Assertions.assertEquals(Windows.authenticationPanel, panel);
        Assertions.assertEquals(Windows.applicationPanel, panel);
    }

    /**
     * Test of replacePanel method, of class GUI.
     */
    @Test
    public void replacePanelTest() {
        Windows.replacePanel(Windows.loginPanel);
    }
}
