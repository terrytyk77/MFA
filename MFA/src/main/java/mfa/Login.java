package mfa;

import java.util.concurrent.TimeUnit;

public class Login {
    private final String name;
    private final String password;
    private final MfaInterface mfaAuthentication;
    private final DataManager dataManager;

    public Login(String name, String password, MfaInterface mfaAuthentication){
        this.name = name;
        this.password = password;
        this.mfaAuthentication = mfaAuthentication;
        this.dataManager = DataManager.getInstance();
    }

    public boolean authenticate() throws InterruptedException {
        System.out.println("Authenticating...");
        TimeUnit.SECONDS.sleep(2);
        if(this.dataManager.getUser(this.name)){
            if(this.dataManager.confirmUserPassword(this.name, this.password)) {
                if(this.mfaAuthentication.authenticate()) {
                    System.out.println(this.name + " Logged in Successfully!");
                    return true;
                }
                else
                    System.out.println("Login Denied!");
            }
            else{
                System.out.println("Wrong Password!");
            }
        }
        else{
            System.out.println("Wrong Username!");
        }
        System.out.println();
        return false;
    }
}
