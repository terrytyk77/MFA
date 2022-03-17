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
            String userName = Utility.scan("Enter username:");
            String password = Utility.scan("Enter password:");

            login = new Login(userName, password);
        } while (!login.authenticate());
    }
}
