package mfa.controllers;

import mfa.utils.Utility;
import java.util.Random;

public class AuthenticationApplication implements AuthenticationInterface {

    @Override
    public Boolean authenticate() {
        int randomNumber1 = new Random().nextInt(10);
        int randomNumber2 = new Random().nextInt(10);
        int result = randomNumber1 + randomNumber2;
        String confirmation = Utility.scan("Please, calculate: " + randomNumber1 + " + " + randomNumber2 + " to confirm it's you");

        if(String.valueOf(result).equals(confirmation)){
            Utility.println("Authenticated by Application Successful!");
            return true;
        }

        Utility.println("Authenticated by Application Failed!");
        return false;
    }
}
