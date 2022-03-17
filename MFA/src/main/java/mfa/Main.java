package mfa;

import mfa.views.LoginPage;

/**
 * @author Terry Keyrouz
 */

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // Create the login page and run its instructions
        LoginPage loginPage = new LoginPage();
        loginPage.main();
    }

}
