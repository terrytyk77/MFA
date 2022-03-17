package mfa;

import java.util.Random;

public class ApplicationAuthentication implements MfaInterface{

    @Override
    public Boolean authenticate() {
        int randomNumber = new Random().nextInt(100);
        String confirmation = Utility.scan("Write " + randomNumber + " to confirm it's you");

        if(String.valueOf(randomNumber).equals(confirmation)){
            Utility.print("Authenticated by Application Successful");
            return true;
        }

        Utility.print("Authenticated by Application Failed");
        return false;
    }
}
