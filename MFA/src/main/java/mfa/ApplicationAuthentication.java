package mfa;

public class ApplicationAuthentication implements MfaInterface{

    @Override
    public Boolean authenticate(boolean authenticate) {
        if(authenticate)
            System.out.println("Authenticated by Application Successful");
        else
            System.out.println("Authenticated by Application Failed");
        return authenticate;
    }
}
