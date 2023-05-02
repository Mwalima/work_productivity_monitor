package org.monitor;

import javax.swing.*;
import com.formdev.flatlaf.FlatLightLaf;

public class LoginFrame extends JFrame {

    public LoginFrame(){
        try{
            UIManager.setLookAndFeel(new FlatLightLaf());
        }catch (Exception e){
            e.printStackTrace();
        }
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Welcome");
        setSize(800, 600);
    }
}
