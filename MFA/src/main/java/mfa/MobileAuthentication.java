package mfa;

import java.util.Random;

public class MobileAuthentication implements MfaInterface{

    @Override
    public Boolean authenticate() {
        int randomNumber1 = new Random().nextInt(10);
        int randomNumber2 = new Random().nextInt(10);
        int result = randomNumber1 + randomNumber2;
        String confirmation = Main.scan("Calculate: " + randomNumber1 + " + " + randomNumber2 + " to confirm it's you");

        if(String.valueOf(result).equals(confirmation)){
            System.out.println("Authenticated by Mobile Successful");
            return true;
        }

        System.out.println("Authenticated by Mobile Failed");
        return false;
    }
}
