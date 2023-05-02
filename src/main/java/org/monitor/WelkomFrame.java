package org.monitor;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.*;
import java.awt.*;

public class WelkomFrame extends JFrame{

    WelkomFrame() {

        try{
            UIManager.setLookAndFeel(new FlatLightLaf());
        }catch (Exception e){
            e.printStackTrace();
        }
        ImageIcon logo = new ImageIcon("./images/logo_small.png");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setTitle("Monitor");
        setLocationRelativeTo(null);
        setLayout(null);
//        getContentPane().setBackground(new Color(40, 31, 107));
        setIconImage(logo.getImage());
    }
}
