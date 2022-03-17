package mfa;

import java.util.Random;

public class MobileAuthentication implements MfaInterface{

    @Override
    public Boolean authenticate() {
        int randomNumber1 = new Random().nextInt(10);
        int randomNumber2 = new Random().nextInt(10);
        int result = randomNumber1 + randomNumber2;
        String confirmation = Utility.scan("Calculate: " + randomNumber1 + " + " + randomNumber2 + " to confirm it's you");

        if(String.valueOf(result).equals(confirmation)){
            Utility.print("Authenticated by Mobile Successful");
            return true;
        }

        Utility.print("Authenticated by Mobile Failed");
        return false;
    }
}
