package mfa.controllers;

import mfa.models.DataManager;
import mfa.utils.Utility;
import mfa.views.LoginPage;

public class LoginService {
    private final DataManager dataManager;
    private final String name;
    private final String password;
    private LoginPage loginPage;
    private AuthenticationInterface authenticationMethod;

    public LoginService(String name, String password){
        this.name = name;
        this.password = password;
        this.authenticationMethod = null;
        this.loginPage = null;
        this.dataManager = DataManager.getInstance();
    }

    public AuthenticationInterface getAuthenticationMethod(){
        return this.authenticationMethod;
    }

    public void setAuthenticationMethod(AuthenticationInterface mfaAuthentication){
        this.authenticationMethod = mfaAuthentication;
    }

    public void setLoginPage(LoginPage loginPage){
        this.loginPage = loginPage;
    }

    /* Attempt to log in if succeed it will call the authenticate method
     from the chosen authenticationMethod chosen by the user, by calling
     it's implemented interface
     */
    public boolean loginAttempt() {
        Utility.println("Authenticating...");
        if(this.dataManager.getUser(this.name)){
            if(this.dataManager.confirmUserPassword(this.name, this.password)) {
                this.loginPage.AuthenticationUI();
                if(this.authenticationMethod.authenticate()) {
                    Utility.println(this.name + " Logged in Successfully!");
                    return true;
                }
                else
                    Utility.println("Login Denied!");
            }
            else{
                Utility.println("Wrong Password!");
            }
        }
        else{
            Utility.println("Wrong Username!");
        }
        return false;
    }
}
