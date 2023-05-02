package org.monitor;

import javax.swing.*;

import com.formdev.flatlaf.FlatLightLaf;

public class CloseFrame extends JFrame{

    CloseFrame(){
        try{
            UIManager.setLookAndFeel(new FlatLightLaf());
        }catch (Exception e){
            e.printStackTrace();
        }
        setDefaultCloseOperation(javax.swing.
                WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Vaarwel");
        setTitle("Provincie Zuid-Holland Werk Monitor");
        setSize(800, 600);
    }
}
