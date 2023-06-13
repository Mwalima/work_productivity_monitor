package org.monitor.view;

import org.monitor.View;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class StartView extends JFrame {

    public StartView(){

        startPanel();
    }


    public JPanel startPanel() {
        //TODO make panel close after 5 sec
        JLabel welkomeText = new JLabel();
        String logintext = "<html><p>Welkom bij de typ-vaardigheid-monitor</p></html>";
        welkomeText.setText(logintext);
        welkomeText.setFont(new Font("Arial", Font.BOLD, 42));
        welkomeText.setForeground(new Color(10, 0, 0));
        welkomeText.setBounds(600, 180, 900, 600);


        JButton begin = new JButton();
        begin.setText("start");
        begin.setBackground(new Color(0,173,230));
        begin.setBounds(900,600,150,50);
        begin.setFocusPainted(false);
        begin.setFont(new Font("Arial", Font.BOLD, 20));
        begin.setForeground(Color.WHITE);
        begin.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        begin.setOpaque(true);
        begin.addActionListener(e -> {
            RegistrationView registrate = new RegistrationView();
             if( e.getSource()==begin ) {

                View view = new View();

                var test = new JFrame();
                test.setVisible(false);
                test.dispose();
                view.gameFrame(registrate.registrationPanel());
            }
        });

        JPanel sPanel = new JPanel();
        sPanel.setLayout(null);
        sPanel.add(welkomeText);
        sPanel.setBackground(new Color(255, 255, 255));
        sPanel.add(begin);

        add(sPanel, BorderLayout.CENTER);

        return sPanel;
    }
}
