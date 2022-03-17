package mfa.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Utility {
    private static final Scanner scanner = new Scanner(System.in);

    // Ask a question before taking user input
    public static String scan(String message){
        println(message);
        return scanner.nextLine();
    }

    // Easier way to print
    public static void println(String message){
        System.out.println(message);
    }

    // Send a file to the user with the code to authenticate
    public static void sendCode(String fileName, String content){
        try{
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(content);
            fileWriter.close();
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
