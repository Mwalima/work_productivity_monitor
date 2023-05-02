package org.monitor;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.*;


public class View extends JFrame{

    View(){

    }
    public void welkomeFrame() {
        //UIManager.setLookAndFeel(new FlatLightLaf());
        ImageIcon logo = new ImageIcon("/home/linuxpc/Documents/studie/Programmeren/Les1&2/work_productivity_monitor/src/main/resources/images/logo_small.png");

        Model model = new Model();
        Monitor form = new Monitor();
        form.setDefaultCloseOperation(EXIT_ON_CLOSE);
        form.setSize(800, 600);
        form.setTitle("Provincie Zuid-Holland Werk Monitor");
        form.setLocationRelativeTo(null);
        form.getContentPane().add(model.getGui());//set size of the frame
        form.setIconImage(logo.getImage());
        form.setVisible(true);
    }
    public void closeFrame(){
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

    public void loginFrame(){
        try{
            UIManager.setLookAndFeel(new FlatLightLaf());
        }catch (Exception e){
            e.printStackTrace();
        }
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Welcome");
        setSize(800, 600);
        setLocationRelativeTo(null);
    }
}
