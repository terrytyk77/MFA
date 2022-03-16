package mfa;

import com.oracle.tools.packager.Log;

import java.util.Scanner;

/**
 * @author Terry Keyrouz
 */

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Login login;
        do {
            String userName = scan("Enter username:");  // Read user input
            String password = scan("Enter password:");  // Read user input
            MfaInterface mfaAuthentication;

            String authMethod = Main.scan("Choose Auth Method: \"1\" for Mobile \"2\" for Email");  // Read user input
            switch (authMethod){
                case "1":
                    mfaAuthentication = new MobileAuthentication();
                    break;
                default:
                    mfaAuthentication = new EmailAuthentication();
                    break;
            }

            login = new Login(userName, password, mfaAuthentication);
        } while (!login.authenticate());
    }

    public static String scan(String message){
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println(message);
        return myObj.nextLine();
    }
}
