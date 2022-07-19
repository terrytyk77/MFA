package mfa.views;

import mfa.views.GUI;

import javax.swing.*;

public class ApplicationLayout {
    private JPanel contentPanel;
    private JButton buttonLogout;
    private JLabel message;

    public ApplicationLayout(GUI gui) {
        this.buttonLogout.addActionListener(e -> logout(gui));
    }

    private void logout(GUI gui){
        gui.loginLayout.resetFields();
        gui.replacePanel(gui.loginPanel);
    }

    // Setters
    public void setWelcomeMessage(String username) { this.message.setText("Hello " + username + "!"); }

    // Getters
    public String getWelcomeMessage(){ return this.message.getText(); }
    public JPanel getPanel(){ return this.contentPanel; }
}
