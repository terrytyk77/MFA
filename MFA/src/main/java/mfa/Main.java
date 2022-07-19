package mfa;

import mfa.views.GUI;
import mfa.views.LinuxGUI;
import mfa.views.MacGUI;
import mfa.views.WindowsGUI;

/**
 * @author Terry Keyrouz
 */

public class Main {

    public static void main(String[] args){
        GUI gui;
        String OS = System.getProperty("os.name");

        if (OS.contains("Win")) {
            gui = new WindowsGUI();
        }
        else if(OS.contains("Mac")){
            gui = new MacGUI();
        }
        else{
            gui = new LinuxGUI();
        }

        gui.start();
    }
}
