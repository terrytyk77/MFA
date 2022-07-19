package mfa.models;

import mfa.controllers.AuthenticationApplication;
import mfa.controllers.AuthenticationEmail;
import mfa.controllers.AuthenticationInterface;
import mfa.controllers.AuthenticationMobile;
import mfa.enums.AuthenticationMethod;

import java.util.HashMap;

public final class DataManager {

    private static final HashMap<String,String> loginInfo = new HashMap<>();
    private static final HashMap<AuthenticationMethod, AuthenticationInterface> authenticationMethods = new HashMap<>();
    private static final HashMap<AuthenticationMethod, String> authenticationStrings = new HashMap<>();
    private static final DataManager INSTANCE = new DataManager();

    private  DataManager(){
        // Populating the user database
        loginInfo.put("Terry", "12345");
        loginInfo.put("Ali", "Apple12");
        loginInfo.put("John", "Pizza");

        // Populating the auth methods
        authenticationMethods.put(AuthenticationMethod.EMAIL, new AuthenticationEmail());
        authenticationMethods.put(AuthenticationMethod.MOBILE, new AuthenticationMobile());
        authenticationMethods.put(AuthenticationMethod.APPLICATION, new AuthenticationApplication());

        // Populating the auth messages
        authenticationStrings.put(AuthenticationMethod.EMAIL, "Email");
        authenticationStrings.put(AuthenticationMethod.MOBILE, "Mobile");
        authenticationStrings.put(AuthenticationMethod.APPLICATION, "Application");
    }

    public static DataManager getInstance(){
        return INSTANCE;
    }

    public boolean getUser(String name){
        return loginInfo.containsKey(name);
    }

    public boolean confirmUserPassword(String name,String password){
        if(!getUser(name)) return false;
        return loginInfo.get(name).equals(password);
    }

    public AuthenticationInterface getAuthenticationMethod(AuthenticationMethod method){
        if(!authenticationMethods.containsKey(method)) return null;
        return authenticationMethods.get(method);
    }

    public HashMap<AuthenticationMethod, String> getAuthenticationStrings(){
        return authenticationStrings;
    }
}
