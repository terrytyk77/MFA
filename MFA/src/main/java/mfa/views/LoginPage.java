package mfa.views;

import mfa.controllers.AuthenticationApplication;
import mfa.controllers.AuthenticationEmail;
import mfa.controllers.LoginService;
import mfa.controllers.AuthenticationMobile;
import mfa.utils.Utility;

public class LoginPage{
    private LoginService login;

    public void main() throws InterruptedException {
        do {
            // Output -- Starting the application and grabbing the inputs of the user
            Utility.println("\n#~#~#~# Welcome to Bradford IT! #~#~#~#");
            String userName = Utility.scan("Username:");
            String password = Utility.scan("Password:");

            login = new LoginService(userName, password);
            login.setLoginPage(this);
        }while (!login.loginAttempt());
    }

    // Ask the user which method of authentication he wants to use
    public void userChooseAuthenticationMethod(){
        String authMethod = Utility.scan("Please, Select An Authentication Method:\n" +
                "1 - Mobile \n" +
                "2 - Email \n" +
                "3 - Application");  // Read user input

        switch (authMethod){
            case "1":
                login.setAuthenticationMethod(new AuthenticationMobile());
                break;
            case "2":
                login.setAuthenticationMethod(new AuthenticationEmail());
                break;
            case "3":
                login.setAuthenticationMethod(new AuthenticationApplication());
                break;
            default:
                login.setAuthenticationMethod(null);
                break;
        }

        if(login.getAuthenticationMethod() == null){
            Utility.println("Option Unavailable! \n");
            userChooseAuthenticationMethod();
        }
    }
}
