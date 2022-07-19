
package mfa.views;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author Terry Keyrouz
 */
public class LoginLayoutTest {
    private static WindowsGUI gui;
    private static LoginLayout loginLayout;

    @BeforeAll
    static void setData(){
        gui = new WindowsGUI();
        loginLayout = new LoginLayout(gui);
    }

    /**
     * Test of resetFieldsTest method, of class LoginLayout.
     */
    @Test
    void resetFieldsTest(){
        String blank = "";
        loginLayout.resetFields();
        assertEquals(loginLayout.getUsernameInput(), blank);
        assertEquals(loginLayout.getPasswordInput(), blank);
    }

    /**
     * Test of setters method, of class LoginLayout.
     */
    @Test
    void settersTest(){
        String username = "Terry";
        String password = "12345";

        loginLayout.setUsernameInput(username);
        loginLayout.setPasswordInput(password);

        assertEquals(loginLayout.getUsernameInput(), username);
        assertEquals(loginLayout.getPasswordInput(), password);
    }

    /**
     * Test of getContentPanelTest method, of class LoginLayout.
     */
    @Test
    void getContentPanelTest(){
        JPanel panel = loginLayout.getPanel();
        gui.setLoginPanel(panel);
        assertEquals(gui.loginPanel , panel);
    }
}
