package org.monitor.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

import static java.awt.AWTEventMulticaster.add;

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
        welkomeText.setForeground(new Color(245, 239, 239));
        welkomeText.setBounds(200, 28, 450, 200);

        JPanel closePanel = new JPanel();
        closePanel.setLayout(null);
        closePanel.add(welkomeText);
        closePanel.setBackground(new Color(40, 31, 107));
        add(closePanel, BorderLayout.CENTER);
        return closePanel;
    }
}
