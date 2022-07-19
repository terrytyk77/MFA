package mfa.controllers;

import mfa.enums.AuthenticationMethod;
import mfa.models.DataManager;
import mfa.utils.Tuple;

import java.util.HashMap;

public class LoginService {
    private final DataManager dataManager;

    public LoginService(){
        this.dataManager = DataManager.getInstance();
    }

    public HashMap<AuthenticationMethod, String> getAuthenticationStrings(){
        return dataManager.getAuthenticationStrings();
    }

    /* attemptToLogIn, send multiple responds to the front-end
     * depending on if it succeeds or not.
     * The response is in tuple indicating <Success status, Error Message>
     */
    public Tuple<Boolean, String> loginAttempt(String name, String password){
        if(!this.dataManager.getUser(name))
            return new Tuple<>(false, "Wrong Username!");

        if(this.dataManager.confirmUserPassword(name, password))
            return new Tuple<>(true, "Login Successful!");
        else
            return new Tuple<>(false, "Wrong Password!");
    }

    /* multipleFactorAuthentication, send multiple responds to the front-end
     * depending on if it succeeds to communicate with the interface that implements
     * the authentication method and gets validated.
     * The response is in tuple indicating <Success status, Error Message>
     */
    public Tuple<Boolean, String> multipleFactorAuthentication(AuthenticationMethod mfaAuthentication){
        AuthenticationInterface authenticationMethod = dataManager.getAuthenticationMethod(mfaAuthentication);
        assert authenticationMethod != null;
        boolean authenticateResponse = authenticationMethod.authenticate();
        if(authenticateResponse)
            return new Tuple<>(true, "Authenticate Successful!");
        else
            return new Tuple<>(false, "Access Denied!");
    }
}
