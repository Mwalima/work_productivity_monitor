package org.monitor.view;

import org.monitor.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WrongCredentialsView extends JFrame implements ActionListener {

    private JLabel welkomeText;
     private JButton returnbutton;
    private JPanel wroncredentialspanel;

    public JPanel wrongCredentialsPanel() {
        welkomeText = new JLabel();
        String logintext = "<html><p>Vul AUB de correcte gegevens in.</p></html>";
        welkomeText.setText(logintext);
        welkomeText.setFont(new Font("Arial", Font.BOLD, 20));
        welkomeText.setForeground(new Color(245, 239, 239));
        welkomeText.setBounds(200, 28, 450, 200);

        wroncredentialspanel = new JPanel();
        wroncredentialspanel.setLayout(null);
        wroncredentialspanel.add(welkomeText);
        wroncredentialspanel.setBackground(new Color(40, 31, 107));

        returnbutton = new JButton("return");
        returnbutton.setBounds(200, 310, 120, 25);
        returnbutton.setBackground(new Color(209, 31, 61));
        returnbutton.setForeground(new Color(191, 191, 191));
        wroncredentialspanel.add(returnbutton);
        add(wroncredentialspanel, BorderLayout.CENTER);

        returnbutton.addActionListener(this);
        return wroncredentialspanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        View view = new View();
        if (e.getSource() == returnbutton) {
            //close previouos frame
            view.gameFrame(wrongCredentialsPanel()).dispose();
            view.gameFrame(view.loginPanel());
        }
    }
}
