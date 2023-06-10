package org.monitor.view;

import org.monitor.View;
import org.monitor.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame implements ActionListener {

    private JLabel welkomeText, username, password;
    private JTextField usernameText;
    private JPasswordField passwordText;
    private String emailValue,passwordValue;
    private JButton loginbutton, exitbutton;


    public JPanel loginPanel() {

        welkomeText = new JLabel();
        String logintext = "<html><p>Welkom Bij de werk Monitor!\n Login om je werk prestatie bij te houden.</p></html>";
        welkomeText.setText(logintext);
        welkomeText.setFont(new Font("Arial", Font.BOLD, 20));
        welkomeText.setForeground(new Color(245, 239, 239));
        welkomeText.setBounds(200, 28, 450, 200);

        username = new JLabel();
        username.setText("Gebruikersnaam / E-mailadres");
        username.setForeground(new Color(191, 191, 191));
        username.setBounds(200, 208, 350, 20);

        usernameText = new JTextField(15);
        usernameText.setBounds(200, 227, 400, 28);

        password = new JLabel();
        password.setText("Wachtwoord");
        password.setForeground(new Color(191, 191, 191));
        password.setBounds(200, 255, 170, 20);

        passwordText = new JPasswordField(15);
        passwordText.setBounds(200, 275, 400, 28);

        loginbutton = new JButton("Verzenden");
        loginbutton.setBounds(200, 310, 120, 25);
        loginbutton.setBackground(new Color(239, 204, 54));
        loginbutton.setForeground(new Color(191, 191, 191));

        exitbutton = new JButton("Uitloggen");
        exitbutton.setBounds(400, 310, 120, 25);
        exitbutton.setBackground(new Color(209, 31, 61));
        exitbutton.setForeground(new Color(191, 191, 191));

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);
        loginPanel.add(welkomeText);
        loginPanel.add(username);
        loginPanel.add(usernameText);

        loginPanel.add(password);
        loginPanel.add(passwordText);

        loginPanel.add(loginbutton);
        loginPanel.add(exitbutton);
        loginPanel.setBackground(new Color(40, 31, 107));

        add(loginPanel, BorderLayout.CENTER);
        loginbutton.addActionListener(this);
        exitbutton.addActionListener(this);
        return loginPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        View view = new View();
        ClosingView closingView = new ClosingView();
        WrongCredentialsView wrongcredentials = new WrongCredentialsView();
        MonitorView monitorView = new MonitorView();
        User user = new User();

        if (e.getSource() == loginbutton) {
            try {
                //get input from form
                emailValue = usernameText.getText();
                passwordValue = passwordText.getText();

                //add values to user object
                user.setEmailadress(emailValue);
                user.setPassword(passwordValue);

                if (user.getUserData() == 1) {
                    //if authentic, navigate user to a new page
                    var test = new JFrame();
                    test.setVisible(false);
                    test.dispose();
                    view.gameFrame(monitorView.monitoringPanel());
                } else {
                    //close previouos frame
//                    view.gameFrame(loginPanel()).dispose();
                    var test = new JFrame();
                    test.setVisible(false);
                    test.dispose();
                    view.gameFrame(wrongcredentials.wrongCredentialsPanel());
                }
            } catch (Exception ea) {
                //close previous frame
                var test = new JFrame();
                test.setVisible(false);
                test.dispose();

                view.gameFrame(wrongcredentials.wrongCredentialsPanel());
            }
        }
        if (e.getSource() == exitbutton) {
            var test = new JFrame();
            test.setVisible(false);
            test.dispose();
            view.gameFrame(closingView.closePanel());
        }
    }
}
