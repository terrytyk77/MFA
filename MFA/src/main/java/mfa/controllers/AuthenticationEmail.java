package mfa.controllers;

import mfa.utils.Utility;

import javax.swing.*;
import java.util.Random;

public class AuthenticationEmail implements AuthenticationInterface {

    @Override
    public Boolean authenticate() {
        // Generate a random G-Code
        int randomNumber = new Random().nextInt(1000);
        String result = "G-" + randomNumber;

        // Send the code to a text file
        Utility.sendCode("Email_Authentication.txt", "Your Code is: " + result);

        // Compare the G-code with the user input
        String response = JOptionPane.showInputDialog("A code has been sent to your email! Insert it below").trim();
        return response.equals(result);
    }
}
