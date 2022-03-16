package mfa;

import java.util.Random;

public class EmailAuthentication implements MfaInterface{

    @Override
    public Boolean authenticate(boolean authenticate) {
        int randomNumber = new Random().nextInt(100);;
        String confirmation = Main.scan("Write " + randomNumber + " to confirm it's you");

        if(String.valueOf(randomNumber).equals(confirmation)){
            System.out.println("Authenticated by Email Successful");
            return true;
        }
        else{
            System.out.println("Authenticated by Email Failed");
            return false;
        }
    }
}
