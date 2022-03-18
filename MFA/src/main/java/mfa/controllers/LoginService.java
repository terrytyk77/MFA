package mfa.controllers;

import mfa.models.DataManager;
import mfa.utils.Utility;
import java.util.concurrent.TimeUnit;

public class LoginService {
    private final DataManager dataManager;
    private final String name;
    private final String password;
    private AuthenticationInterface authenticationMethod;

    public LoginService(String name, String password){
        this.name = name;
        this.password = password;
        this.authenticationMethod = null;
        this.dataManager = DataManager.getInstance();
    }

    public AuthenticationInterface getAuthenticationMethod(){
        return this.authenticationMethod;
    }

    public void setAuthenticationMethod(AuthenticationInterface mfaAuthentication){
        this.authenticationMethod = mfaAuthentication;
    }

    /* Attempt to log in if succeed it will call the authenticate method
     from the chosen authenticationMethod chosen by the user, by calling
     it's implemented interface
     */
    public boolean loginAttempt() throws InterruptedException {
        Utility.println("Authenticating...");
        //Simulate Network Delay
        TimeUnit.SECONDS.sleep(1);
        if(this.dataManager.getUser(this.name)){
            if(this.dataManager.confirmUserPassword(this.name, this.password))
                return true;
            else
                Utility.println("Wrong Password!");
        }
        else{
            Utility.println("Wrong Username!");
        }
        return false;
    }

    public boolean multipleFactorAuthentication(){
        if(this.authenticationMethod.authenticate()) {
            Utility.println(this.name + " Logged in Successfully!");
            return true;
        }

        Utility.println("Login Denied!");
        return false;
    }
}
