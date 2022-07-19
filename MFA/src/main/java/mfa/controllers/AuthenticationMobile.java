package mfa.controllers;

import mfa.utils.Utility;

import javax.swing.*;
import java.util.Random;

public class AuthenticationMobile implements AuthenticationInterface {

    @Override
    public Boolean authenticate() {
        int result = new Random().nextInt(100);

        // Send the code to a text file
        Utility.sendCode("Mobile_Authentication.txt", "Your Code is: " + result);

        String response = JOptionPane.showInputDialog("A code has been sent to your mobile! Insert it below").trim();
        return response.equals(String.valueOf(result));
    }
}
