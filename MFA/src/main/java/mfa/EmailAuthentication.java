package mfa;

public class EmailAuthentication implements MfaInterface{

    @Override
    public Boolean Authenticate(boolean authenticate) {
        if(authenticate)
            System.out.println("Authenticated by Email Successful");
        else
            System.out.println("Authenticated by Email Failed");
        return authenticate;
    }
}
