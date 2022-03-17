package mfa.controllers;

import mfa.utils.Utility;
import java.util.Random;

public class AuthenticationMobile implements AuthenticationInterface {

    @Override
    public Boolean authenticate() {
        int randomNumber = new Random().nextInt(100);
        String confirmation = Utility.scan("Please, write down " + randomNumber + " to confirm it's you");

        if(String.valueOf(randomNumber).equals(confirmation)){
            Utility.println("Authenticated by Mobile Successful!");
            return true;
        }

        Utility.println("Authenticated by Mobile Failed!");
        return false;
    }
}
