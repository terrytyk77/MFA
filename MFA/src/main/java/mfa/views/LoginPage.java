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
            String userName = Utility.scan("Enter username:");
            String password = Utility.scan("Enter password:");

            login = new LoginService(userName, password);
            userChooseAuthenticationMethod();
        }while (!login.loginAttempt());
    }

    private void userChooseAuthenticationMethod(){
        String authMethod = Utility.scan("Choose Authentication Method: \"1\" for Mobile, \"2\" for Email or \"3\" for Application");  // Read user input

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
