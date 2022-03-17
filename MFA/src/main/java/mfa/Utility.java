package mfa;

import java.util.Scanner;

public class Utility {
    private static final Scanner scanner = new Scanner(System.in);

    public static String scan(String message){
        print(message);
        return scanner.nextLine();
    }

    public static void print(String message){
        System.out.println(message);
    }
}
