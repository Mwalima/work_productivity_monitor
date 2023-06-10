package org.monitor.view;

import javax.swing.*;
import java.awt.*;


public class ClosingView extends JFrame {

    public ClosingView(){
        closePanel();
    }


    public JPanel closePanel() {
        //TODO make panel close after 5 sec
        JLabel welkomeText = new JLabel();
        String logintext = "<html><p>Sluiten van alle voortgang</p></html>";
        welkomeText.setText(logintext);
        welkomeText.setFont(new Font("Arial", Font.BOLD, 20));
        welkomeText.setForeground(Color.WHITE);
        welkomeText.setBounds(600, 28, 450, 200);

        JPanel closePanel = new JPanel();
        closePanel.setLayout(null);
        closePanel.add(welkomeText);
        closePanel.setBackground(new Color(171, 167, 201));
        add(closePanel, BorderLayout.CENTER);
        return closePanel;
    }
}
