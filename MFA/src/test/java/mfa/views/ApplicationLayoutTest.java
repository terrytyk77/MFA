
package mfa.views;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author Terry Keyrouz
 */
public class ApplicationLayoutTest {
    private static WindowsGUI gui;
    private static ApplicationLayout applicationLayout;

    @BeforeAll
    static void setData(){
        gui = new WindowsGUI();
        applicationLayout = new ApplicationLayout(gui);
    }

    /**
     * Test of setWelcomeMessage method, of class ApplicationLayout.
     */
    @Test
    void setWelcomeMessageTest(){
        applicationLayout.setWelcomeMessage("Terry");
        assertEquals(applicationLayout.getWelcomeMessage(), "Hello Terry!");
    }

    /**
     * Test of getContentPanel method, of class ApplicationLayout.
     */
    @Test
    void getContentPanelTest(){
        JPanel panel = applicationLayout.getPanel();
        gui.setApplicationPanel(panel);
        assertEquals(gui.applicationPanel , panel);
    }
}
