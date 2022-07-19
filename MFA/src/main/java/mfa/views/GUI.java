package mfa.views;

import mfa.controllers.LoginService;
import mfa.utils.Utility;

import javax.swing.*;
import java.awt.*;

public class GUI {

    //Variables
    protected JFrame applicationFrame;
    protected LoginService login = new LoginService();
    protected String username = "";

    //Panels
    protected JPanel loginPanel;
    protected JPanel applicationPanel;
    protected JPanel authenticationPanel;

    //Layouts
    protected LoginLayout loginLayout;
    protected AuthenticationLayout authenticationLayout;
    protected ApplicationLayout applicationLayout;

    //Setters
    protected void setLoginPanel(JPanel panel){ loginPanel = panel; }
    protected void setApplicationPanel(JPanel panel){ applicationPanel = panel; }
    protected void setAuthenticationPanel(JPanel panel){ authenticationPanel = panel;}

    //Methods
    protected void replacePanel(JPanel panel){
        if(panel == null)
            return;

        applicationFrame.getContentPane().removeAll();
        applicationFrame.add(panel);
        applicationFrame.revalidate();
        applicationFrame.repaint();

    }

    public void start(){
        if(loginPanel == null){
            Utility.println("Oops... Work in progress!");
            return;
        }

        applicationFrame = new JFrame();
        applicationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        applicationFrame.setMinimumSize(new Dimension(400, 150));
        applicationFrame.add(loginPanel, BorderLayout.CENTER);
        applicationFrame.setTitle("IT Services - University of Bradford");
        applicationFrame.setLocationRelativeTo(null);
        applicationFrame.setVisible(true);
    }
}
