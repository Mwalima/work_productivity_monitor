package org.monitor.view;

import org.monitor.View;
import org.monitor.helper.CustomDialog;
import org.monitor.helper.Reminder;
import org.monitor.model.User;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.apache.commons.lang3.StringUtils.isEmpty;

public class LoginView extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    private JLabel username;
    private JLabel password;
    private JTextField usernameText;
    private JPasswordField passwordText;
    private String emailValue,passwordValue;
    private JButton loginbutton, exitbutton;
    private CustomDialog dialog;
    public JPanel loginPanel() {


        JLabel welkomeText = new JLabel();
        String logintext = "<html><p>Welkom Bij de werk Monitor!\n Login om je werk prestatie bij te houden.</p></html>";
        welkomeText.setText(logintext);
        welkomeText.setFont(new Font("Arial", Font.BOLD, 24));
        welkomeText.setForeground(new Color(6, 6, 6));
        welkomeText.setBounds(600, 28, 600, 200);

        username = new JLabel();
        username.setText("E-mailadres");
        username.setFont(new Font("Arial", Font.BOLD, 18));
        username.setForeground(new Color(48, 48, 48, 100));
        username.setBounds(400, 200, 200, 28);
        usernameText = new JTextField(15);
        usernameText.setBounds(600, 200, 400, 28);

        password = new JLabel();
        password.setText("Wachtwoord");
        password.setFont(new Font("Arial", Font.BOLD, 18));
        password.setForeground(new Color(48, 48, 48, 100));
        password.setBounds(400, 230, 170, 28);
        passwordText = new JPasswordField(15);
        passwordText.setBounds(600, 230, 400, 28);

        loginbutton = new JButton("inloggen");
        loginbutton.setBounds(600, 400, 150, 50);
        loginbutton.setFont(new Font("Arial", Font.BOLD, 20));
        loginbutton.setFocusPainted(false);
        loginbutton.setForeground(Color.WHITE);
        loginbutton.setBackground(new Color(0,173,230));
        loginbutton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        exitbutton = new JButton("Afsluiten");
        exitbutton.setBounds(800, 400, 150, 50);
        exitbutton.setFont(new Font("Arial", Font.BOLD, 20));
        exitbutton.setFocusPainted(false);
        exitbutton.setForeground(new Color(0,173,230));
        exitbutton.setBorder(BorderFactory.createBevelBorder(1,new Color(0,173,230),new Color(0,173,230)));

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);
        loginPanel.add(welkomeText);
        loginPanel.add(username);
        loginPanel.add(usernameText);

        loginPanel.add(password);
        loginPanel.add(passwordText);

        loginPanel.add(loginbutton);
        loginPanel.add(exitbutton);
        loginPanel.setBackground(new Color(255, 255, 255));

        add(loginPanel, BorderLayout.CENTER);
        loginbutton.addActionListener(this);
        exitbutton.addActionListener(this);
        return loginPanel;
    }

    @Override
    @SuppressWarnings("deprecation")
    public void actionPerformed(ActionEvent e) {
        View view = new View();
        WrongCredentialsView wrongcredentials = new WrongCredentialsView();
        MonitorView monitor = new MonitorView();
        User user = new User();//special case

        if (e.getSource() == loginbutton) {

            try {
                //get input from form
                emailValue = usernameText.getText();
                passwordValue = passwordText.getText();

                if((!isEmpty(passwordValue)) && (!isEmpty(emailValue))){

                    //add values to user object
                    user.setEmailadress(emailValue);
                    user.setPassword(passwordValue);

                    if (user.getUserData() == 1) {

                        new MonitorView(emailValue,passwordValue);

                        view.gameFrame(monitor.monitoringPanel());
                        JOptionPane.showMessageDialog(this, "Typ zo goed en snel mogelijk de tekst na die onder staat. \nDe tijd gaat lopen als u ONDER de tekst in het tekst venster klikt.", "Instructie", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        view.gameFrame(wrongcredentials.wrongCredentialsPanel());
                    }
                }else{
                    view.gameFrame(wrongcredentials.wrongCredentialsPanel());
                }
            } catch (Exception ea) {
                view.gameFrame(wrongcredentials.wrongCredentialsPanel());
            }
        }
        if (e.getSource() == exitbutton) {
            new Reminder(1);

            dialog = new CustomDialog(view.gameFrame(this.loginPanel()), "De applicatie sluit over 3 seconden");
            dialog.setVisible(true);

        }
    }
}
