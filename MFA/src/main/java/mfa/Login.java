package mfa;

import java.util.concurrent.TimeUnit;

public class Login {
    private final DataManager dataManager;
    private final String name;
    private final String password;
    private  MfaInterface mfaAuthentication;

    public Login(String name, String password){
        this.name = name;
        this.password = password;
        this.mfaAuthentication = null;
        this.dataManager = DataManager.getInstance();
    }

    public void setMfaInterface(){
        String authMethod = Utility.scan("Choose Authentication Method: \"1\" for Mobile, \"2\" for Email or \"3\" for Application");  // Read user input
        switch (authMethod){
            case "1":
                this.mfaAuthentication = new MobileAuthentication();
                break;
            case "2":
                this.mfaAuthentication = new EmailAuthentication();
                break;
            case "3":
                this.mfaAuthentication = new ApplicationAuthentication();
                break;
            default:
                this.mfaAuthentication = null;
                break;
        }

        if(this.mfaAuthentication == null){
            Utility.print("Option Unavailable! \n");
            this.setMfaInterface();
        }
    }

    public boolean authenticate() throws InterruptedException {
        Utility.print("Authenticating...");
        TimeUnit.SECONDS.sleep(2);
        if(this.dataManager.getUser(this.name)){
            if(this.dataManager.confirmUserPassword(this.name, this.password)) {
                this.setMfaInterface();
                if(this.mfaAuthentication.authenticate()) {
                    Utility.print(this.name + " Logged in Successfully!");
                    return true;
                }
                else
                    Utility.print("Login Denied!");
            }
            else{
                Utility.print("Wrong Password!");
            }
        }
        else{
            Utility.print("Wrong Username!");
        }
        Utility.print("");
        return false;
    }
}
