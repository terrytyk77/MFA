package mfa;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Login {
    private final HashMap<String,String> loginInfo = new HashMap<String,String>();

    private final String name;
    private final String password;

    public Login(String name, String password){
        loginInfo.put("Terry", "12345");
        this.name = name;
        this.password = password;
    }

    public void Authenticate() throws InterruptedException {
        System.out.println("Authenticating...");
        TimeUnit.SECONDS.sleep(1);
        if(loginInfo.containsKey(this.name)){
            if(loginInfo.get(this.name).equals(this.password)) {
                MfaInterface MfaAuthentication = new MobileAuthentication();
                if(MfaAuthentication.Authenticate(true))
                    System.out.println("Login Successful!");
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
    }
}
