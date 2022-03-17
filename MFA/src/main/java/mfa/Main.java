package mfa;

import javax.xml.crypto.Data;
import java.util.Scanner;

/**
 * @author Terry Keyrouz
 */

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Login login;
        do {
//            String userNameC = scan("Enter username:");  // Read user input
//            String passwordC = scan("Enter password:");  // Read user input
//
//            DataManager dataManager = DataManager.getInstance();
//            dataManager.createUser(userNameC, passwordC);

            String userName = Utility.scan("Enter username:");  // Read user input
            String password = Utility.scan("Enter password:");  // Read user input

            login = new Login(userName, password);
        } while (!login.authenticate());
    }
}
