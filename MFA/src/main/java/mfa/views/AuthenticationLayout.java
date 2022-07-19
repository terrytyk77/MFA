package mfa.views;

import mfa.enums.AuthenticationMethod;
import mfa.utils.Tuple;

import javax.swing.*;
import java.util.HashMap;

public class AuthenticationLayout {
    private JPanel contentPanel;
    private JButton buttonConfirm;
    private JButton buttonBack;
    private JComboBox<String> mfaDropDown;

    public AuthenticationLayout(GUI gui) {
        this.generateAuthenticationOptions(gui);
        this.buttonConfirm.addActionListener(e -> authenticationAttempt(gui));
        this.buttonBack.addActionListener(e -> backToLogin(gui));
    }

    private void generateAuthenticationOptions(GUI gui){
        HashMap<AuthenticationMethod, String> authenticationStrings = gui.login.getAuthenticationStrings();
        for(int i = 0; i < authenticationStrings.size(); i++){
            this.mfaDropDown.addItem(authenticationStrings.get(AuthenticationMethod.values()[i]));
        }
    }

    private void authenticationAttempt(GUI gui){
        int selectedIndex = this.mfaDropDown.getSelectedIndex();
        AuthenticationMethod selectedMethod = AuthenticationMethod.values()[selectedIndex];

        Tuple<Boolean, String> loginAttemptResponse = gui.login.multipleFactorAuthentication(selectedMethod);
        Boolean success = loginAttemptResponse.getFirst();
        String errorMessage = loginAttemptResponse.getSecond();

        if(!success) {
            JOptionPane.showMessageDialog(null, errorMessage);
        }
        else {
            gui.replacePanel(gui.applicationPanel);
            gui.applicationLayout.setWelcomeMessage(gui.username);
        }
    }

    private void backToLogin(GUI gui){
        gui.loginLayout.resetFields();
        gui.replacePanel(gui.loginPanel);
    }

    //Setters
    public void resetSelectedIndex(){ setSelectedIndex(0); }
    public void setSelectedIndex(int index){ this.mfaDropDown.setSelectedIndex(index); }

    // Getters
    public int getSelectedIndex(){ return this.mfaDropDown.getSelectedIndex(); }
    public JPanel getPanel(){ return this.contentPanel; }
}
