package mfa.views;

import mfa.utils.Tuple;

import javax.swing.*;

public class LoginLayout   {
    private JPanel contentPanel;
    private JButton buttonLogin;
    private JButton buttonReset;
    private JTextField usernameTextField;
    private JPasswordField passwordPasswordField;

    public LoginLayout(GUI gui) {
        this.buttonReset.addActionListener(e -> resetFields());
        this.buttonLogin.addActionListener(e -> loginAttempt(gui));
    }

    private void loginAttempt(GUI gui){
        String username = getUsernameInput();
        String password = getPasswordInput();

        Tuple<Boolean, String> loginAttemptResponse = gui.login.loginAttempt(username, password);
        Boolean success = loginAttemptResponse.getFirst();
        String errorMessage = loginAttemptResponse.getSecond();

        if(!success){
            JOptionPane.showMessageDialog(null, errorMessage);
        }
        else {
            gui.username = username;
            gui.authenticationLayout.resetSelectedIndex();
            gui.replacePanel(gui.authenticationPanel);
        }
    }

    public void resetFields(){
        setUsernameInput("");
        setPasswordInput("");
    }

    // Setters
    public void setUsernameInput(String username){ this.usernameTextField.setText(username); }
    public  void setPasswordInput(String password){ this.passwordPasswordField.setText(password); }

    // Getters
    public String getUsernameInput(){ return usernameTextField.getText(); }
    public  String getPasswordInput(){ return  String.valueOf(this.passwordPasswordField.getPassword()); }
    public JPanel getPanel(){ return this.contentPanel; }
}
