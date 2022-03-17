package mfa;

import java.util.Random;

public class EmailAuthentication implements MfaInterface{

    @Override
    public Boolean authenticate() {
        int randomNumber = new Random().nextInt(1000);
        String result = "G-" + randomNumber;
        String confirmation = Utility.scan("Write down the code sent: " + result + " to confirm it's you");

        if(result.equals(confirmation)){
            Utility.print("Authenticated by Email Successful");
            return true;
        }

        Utility.print("Authenticated by Email Failed");
        return false;
    }
}
