package org.monitor.view;

import org.monitor.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WrongCredentialsView extends JFrame implements ActionListener {

    private JButton returnbutton;

    public JPanel wrongCredentialsPanel() {
        JLabel welkomeText = new JLabel();
        String logintext = "<html><p>Vul AUB de correcte gegevens in.</p></html>";
        welkomeText.setText(logintext);
        welkomeText.setFont(new Font("Arial", Font.BOLD, 24));
        welkomeText.setForeground(new Color(6, 6, 6));
        welkomeText.setBounds(600, 28, 600, 200);

        JPanel wroncredentialspanel = new JPanel();
        wroncredentialspanel.setLayout(null);
        wroncredentialspanel.add(welkomeText);
        wroncredentialspanel.setBackground(new Color(255, 255, 255));

        returnbutton = new JButton("Terug");
        returnbutton.setBounds(600, 200, 250, 50);
        returnbutton.setFont(new Font("Arial", Font.BOLD, 20));
        returnbutton.setFocusPainted(false);
        returnbutton.setForeground(new Color(0,173,230));
        returnbutton.setBorder(BorderFactory.createBevelBorder(1,new Color(0,173,230),new Color(0,173,230)));

        wroncredentialspanel.add(returnbutton);
        add(wroncredentialspanel, BorderLayout.CENTER);
        returnbutton.addActionListener(this);
        return wroncredentialspanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        View view = new View();
        LoginView lpanel = new LoginView();
        if (e.getSource() == returnbutton) {
            //close previouos frame
            JFrame test = new JFrame();
            test.setVisible(false);
            test.dispose();
            view.gameFrame(lpanel.loginPanel());
        }
    }
}
