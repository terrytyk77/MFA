package mfa.controllers;

import mfa.utils.Utility;
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
        String confirmation = Utility.scan("Please, write down the security code that was sent to your email confirm it's you");

        if(result.equals(confirmation)){
            Utility.println("Authenticated by Email Successful!");
            return true;
        }

        Utility.println("Authenticated by Email Failed!");
        return false;
    }
}
