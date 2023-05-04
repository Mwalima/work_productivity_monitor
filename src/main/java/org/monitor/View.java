package org.monitor;
//import com.formdev.flatlaf.FlatLightLaf;

import org.monitor.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;

import static java.lang.System.exit;


public class View extends JFrame implements ActionListener {

    private int score;
    private JLabel username, password,welkomeText;
    private JTextField usernameText;
    private JPasswordField passwordText;
    private JButton login,exit;
    private JPanel loginPanel, wrongcredPanel,monitoringPanel,closePanel;
    private static final Logger log;

    private ImageIcon logo = new ImageIcon("/home/linuxpc/Documents/studie/Programmeren/Les1&2/work_productivity_monitor/src/main/resources/images/logo_small.png");
    public View(){
        loginForm();
    }

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%4$-7s] %5$s %n");
        log = Logger.getLogger(Monitor.class.getName());
    }

    public Component loginForm() {
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
        return loginPanel;
    }

    /**
     * guid of the start screen called loginframe
     * @return
     */
    public JComponent getGui(){
        return loginPanel;
    }

    public void loginFrame() {
        Monitor form = new Monitor();
        form.setDefaultCloseOperation(EXIT_ON_CLOSE);
        form.setSize(800, 600);
        form.setTitle("Provincie Zuid-Holland Werk Monitor scherm 1");
        form.setLocationRelativeTo(null);
        form.getContentPane().add(getGui());//set size of the frame
        form.setIconImage(logo.getImage());
        form.setVisible(true);
    }
    public void monitoringFrame(){
        welkomeText = new JLabel();
        String logintext = "<html><p>En nu als de wiedeweerga aan de slag!</p></html>";
        welkomeText.setText(logintext);
        welkomeText.setFont(new Font("Arial", Font.BOLD, 20));
        welkomeText.setForeground(new Color(245, 239, 239));
        welkomeText.setBounds(200, 28, 450, 200);

        monitoringPanel = new JPanel();
        monitoringPanel.setLayout(null);
        monitoringPanel.add(welkomeText);
        monitoringPanel.setBackground(new Color(40, 31, 107));
        add(monitoringPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setTitle("Provincie Zuid-Holland Werk Monitor scherm 2");
        setLocationRelativeTo(null);
        getContentPane().add(monitoringPanel);
        setIconImage(logo.getImage());
        setVisible(true);
    }

    public void closeFrame(){
        welkomeText = new JLabel();
        String logintext = "<html><p>Sluiten van alle voortgang</p></html>";
        welkomeText.setText(logintext);
        welkomeText.setFont(new Font("Arial", Font.BOLD, 20));
        welkomeText.setForeground(new Color(245, 239, 239));
        welkomeText.setBounds(200, 28, 450, 200);

        closePanel = new JPanel();
        closePanel.setLayout(null);
        closePanel.add(welkomeText);
        closePanel.setBackground(new Color(40, 31, 107));
        add(closePanel, BorderLayout.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setTitle("Provincie Zuid-Holland Werk Monitor scherm 3");
        setLocationRelativeTo(null);
        add(closePanel);
        setIconImage(logo.getImage());
        setVisible(true);
    }

    public void CloseFrame(){
        super.dispose();
    }
    public void wrongCredentialsFrame(){
        Monitor formwroncred = new Monitor();
        welkomeText = new JLabel();
        String logintext = "<html><p>Vul aub de correcte gegevens in. Neem anders contact op met de database admin</p></html>";
        welkomeText.setText(logintext);
        welkomeText.setFont(new Font("Arial", Font.BOLD, 20));
        welkomeText.setForeground(new Color(245, 239, 239));
        welkomeText.setBounds(200, 28, 450, 200);

        closePanel = new JPanel();
        closePanel.setLayout(null);
        closePanel.add(welkomeText);
        closePanel.setBackground(new Color(40, 31, 107));
        add(closePanel, BorderLayout.CENTER);

        formwroncred.setSize(800, 600);
        formwroncred.setTitle("Provincie Zuid-Holland Werk Monitor scherm 4");
        formwroncred.setLocationRelativeTo(null);
        //getContentPane().add(getWrongCredGui());
        formwroncred.setIconImage(logo.getImage());
        formwroncred.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String userValue = usernameText.getText();
        /*
        TODO  get user entered username from the usernameText
        String passValue = passwordText.getText();
         */

        if (e.getSource() == login) {
            try {
                //call the database and check the input
                User insert = new User();
                //check if userna already in db
                if (userValue.equals(insert.getUserData(userValue))) {  //if authentic, navigate user to a new page
                    //create instance of the monitoring page
                    monitoringFrame();

                } else {
                    //show error message
                    wrongCredentialsFrame();
                }
            } catch (Exception ea) {
               log.info("Create display results"+ ea);
               wrongCredentialsFrame();
            }
        }
        if (e.getSource() == exit) {
           closeFrame();
        }
    }
}
