package mfa.controllers;

import javax.swing.*;
import java.util.Random;

public class AuthenticationApplication implements AuthenticationInterface {

    @Override
    public Boolean authenticate() {
        // Get 2 random numbers
        int randomNumber1 = new Random().nextInt(10);
        int randomNumber2 = new Random().nextInt(10);

        // Sum the 2 numbers
        int result = randomNumber1 + randomNumber2;

        // Compare the result with the user input
        String response = JOptionPane.showInputDialog("Please, calculate "  + randomNumber1 + " + " + randomNumber2 + " to confirm it's you!").trim();
        return response.equals(String.valueOf(result));
    }
}
