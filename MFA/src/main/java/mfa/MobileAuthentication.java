package mfa;

public class MobileAuthentication implements MfaInterface{

    @Override
    public Boolean Authenticate(boolean authenticate) {
        if(authenticate)
            System.out.println("Authenticated by Mobile Successful");
        else
            System.out.println("Authenticated by Mobile Failed");
        return authenticate;
    }
}
