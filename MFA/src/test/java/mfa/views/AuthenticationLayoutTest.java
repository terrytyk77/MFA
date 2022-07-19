
package mfa.views;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author Terry Keyrouz
 */
public class AuthenticationLayoutTest {
    private static WindowsGUI gui;
    private static AuthenticationLayout authenticationLayout;

    @BeforeAll
    static void setData(){
        gui = new WindowsGUI();
        authenticationLayout = new AuthenticationLayout(gui);
    }

    /**
     * Test of resetSelectedIndex method, of class AuthenticationLayout.
     */
    @Test
    void resetSelectedIndexTest(){
        authenticationLayout.resetSelectedIndex();
        assertEquals(authenticationLayout.getSelectedIndex(), 0);
    }

    /**
     * Test of setters method, of class AuthenticationLayout.
     */
    @Test
    void settersTest(){
        int selectedIndex = 0;
        authenticationLayout.setSelectedIndex(selectedIndex);
        assertEquals(authenticationLayout.getSelectedIndex(), selectedIndex);
    }

    /**
     * Test of getContentPanel method, of class AuthenticationLayout.
     */
    @Test
    void getContentPanelTest(){
        JPanel panel = authenticationLayout.getPanel();
        gui.setAuthenticationPanel(panel);
        assertEquals(gui.authenticationPanel , panel);
    }
}
