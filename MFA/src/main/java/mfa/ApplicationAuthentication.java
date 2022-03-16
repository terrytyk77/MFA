package mfa;

import java.util.Random;

public class ApplicationAuthentication implements MfaInterface{

    @Override
    public Boolean authenticate() {
        int randomNumber = new Random().nextInt(100);
        String confirmation = Main.scan("Write " + randomNumber + " to confirm it's you");

        if(String.valueOf(randomNumber).equals(confirmation)){
            System.out.println("Authenticated by Application Successful");
            return true;
        }

        System.out.println("Authenticated by Application Failed");
        return false;
    }
}
