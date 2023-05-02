package org.monitor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Model extends JPanel implements ActionListener {

    private int score;
    private JLabel username, password,welkomeText;
    private JTextField usernameText;
    private JPasswordField passwordText;
    private JButton login,exit;
    private JPanel loginPanel;

    public Model() {
        monitor();
        initMonitor();
        LoginForm();
    }

    public Component LoginForm() {

        welkomeText = new JLabel();
        String logintext = "<html><p>Welkom Bij de werk Monitor!\n Login om je werk prestatie bij te houden.</p></html>";
        welkomeText.setText(logintext);
        welkomeText.setFont(new Font("Arial", Font.BOLD, 20));
        welkomeText.setForeground(new Color(245, 239, 239));
        welkomeText.setBounds(200, 28, 450, 200);

        username = new JLabel();
        username.setText("Gebruikersnaam");
        username.setForeground(new Color(191,191,191));
        username.setBounds(200, 208, 170, 20);

        usernameText = new JTextField(15);
        usernameText.setBounds(200, 227, 400, 28);

        password = new JLabel();
        password.setText("Wachtwoord");
        password.setForeground(new Color(191,191,191));
        password.setBounds(200, 255, 170, 20);

        passwordText = new JPasswordField(15);
        passwordText.setBounds(200, 275, 400, 28);

        login = new JButton("Verzenden");
        login.setBounds(200, 310, 120, 25);
        login.setBackground(new Color(239,204,54));
        login.setForeground(new Color(191,191,191));

        exit = new JButton("Uitloggen");
        exit.setBounds(400, 310, 120, 25);
        exit.setBackground(new Color(209,31,61));
        exit.setForeground(new Color(191,191,191));

        loginPanel = new JPanel();
        loginPanel.setLayout(null);
        loginPanel.add(welkomeText);
        loginPanel.add(username);
        loginPanel.add(usernameText);

        loginPanel.add(password);
        loginPanel.add(passwordText);

        loginPanel.add(login);
        loginPanel.add(exit);
        loginPanel.setBackground(new Color(40, 31, 107));


        add(loginPanel, BorderLayout.CENTER);
        login.addActionListener(this);
        exit.addActionListener(this);
        return null;
    }

    public JComponent getGui(){
        return loginPanel;
    }

    public void monitor() {
        addKeyListener(new TAdapter());
        setFocusable(true);
        initMonitor();
    }

    private void initMonitor() {
        score = 0;
    }



    class TAdapter implements KeyListener {
        private boolean monitoring;

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            if (monitoring) {
                key += 1;
            } else {
                repaint();
            }
        }
        @Override
        public void keyReleased(KeyEvent e) {
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String userValue = usernameText.getText();        //get user entered username from the textField1
        String passValue = passwordText.getText();        //get user entered pasword from the textField2

        if(e.getSource() == login) {
            if (userValue.equals("test1@gmail.com") && passValue.equals("test")) {  //if authentic, navigate user to a new page

                //create instance of the NewPage
                LoginFrame page = new LoginFrame();
                //make page visible to the user
                page.setVisible(true);
                //create a welcome label and set it to the new page
                JLabel wel_label = new JLabel("Welcome: " + userValue);
                page.getContentPane().add(wel_label);
            } else {
                //show error message
                System.out.println("Please enter valid username and password");
            }
        }
        if(e.getSource() == exit){
            //create instance of the NewPage
            CloseFrame close_page = new CloseFrame();
            JLabel exit_label = new JLabel("Vaarwel: " + userValue);
            close_page.getContentPane().add(exit_label);
            //make page visible to the user
            close_page.setVisible(true);
        }

    }
}

