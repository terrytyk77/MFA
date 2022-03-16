package mfa;

import java.util.Scanner;

/**
 * @author Terry Keyrouz
 */

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object

        System.out.println("Enter username:");
        String userName = myObj.nextLine();  // Read user input

        System.out.println("Enter password:");
        String password = myObj.nextLine();  // Read user input

        Login login = new Login(userName, password);
        login.Authenticate();
    }
}
