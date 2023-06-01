package org.monitor;

import org.monitor.model.User;
import org.monitor.view.ClosingView;
import org.monitor.view.RegistrationView;
import org.monitor.view.WrongCredentialsView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class View extends JFrame implements ActionListener, KeyListener, MouseListener {
    static final String newline = System.getProperty("line.separator");

    public int count = 0;
    String emailValue,passwordValue;
    private JLabel username, password, welkomeText, keyboardcount, mousecount, keycounttext, mousecounttextfield;
    private JTextField usernameText, keycount, mouseactionfield;
    private JTextArea mousecountText, keyboardcountText;
    private JButton loginbutton, exitbutton, returnbutton;
    private JPasswordField passwordText;
    private JPanel monitoringGridPanel;
    private JPanel wroncredentialspanel;
    private JScrollPane scrollPaneKey, scrollPaneMouse;
    private final ImageIcon logo = new ImageIcon("./resources/images/logo_small.png");

    public View() {
        loginPanel();
        monitoringPanel();
    }

    /**
     * guid of the start screen called loginframe
     *
     * @return
     */
    public JComponent getGui(JPanel panel) {
        return panel;
    }

    public JFrame gameFrame(JPanel panel) {
        Main form = new Main();
        form.setDefaultCloseOperation(EXIT_ON_CLOSE);
        form.setExtendedState(JFrame.MAXIMIZED_BOTH);
        form.setTitle("Provincie Zuid-Holland Werk Monitor scherm");
        form.setLocationRelativeTo(null);
        form.getContentPane().add(getGui(panel));//set size of the frame
        form.setIconImage(logo.getImage());
        form.setVisible(true);
        return form;
    }


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
    public JPanel monitoringPanel() {
        welkomeText = new JLabel();
        String logintext = "<html><h1>Proceed with the test</h1></html>";
        welkomeText.setText(logintext);
        welkomeText.setFont(new Font("Arial", Font.BOLD, 20));
        welkomeText.setForeground(new Color(245, 239, 239));
        welkomeText.setBounds(200, 28, 450, 200);
        welkomeText.setHorizontalTextPosition(SwingConstants.LEFT);

        mousecount = new JLabel();
        mousecount.setText("mouse activity counter");
        mousecount.setForeground(new Color(191, 191, 191));
        mousecount.setBounds(500, 150, 200, 20);

        mousecountText = new JTextArea();
        mousecountText.setWrapStyleWord(true);
        mousecountText.setBounds(500, 200, 200, 300);

        scrollPaneMouse = new JScrollPane(mousecountText);
        scrollPaneMouse.setPreferredSize(new Dimension(100, 300));
        mousecountText.setEditable(false);
        //keylistner label en area
        keyboardcount = new JLabel();
        keyboardcount.setText("Keyboard activity counter");
        keyboardcount.setForeground(new Color(191, 191, 191));
        keyboardcount.setBounds(200, 150, 200, 20);

        keyboardcountText = new JTextArea();
        keyboardcountText.setWrapStyleWord(true);
        keyboardcountText.setBounds(200, 200, 200, 300);

        keyboardcountText.setEditable(false);
        scrollPaneKey = new JScrollPane(keyboardcountText);
        scrollPaneKey.setPreferredSize(new Dimension(100, 300));

        //add counter fields
        keycounttext = new JLabel();
        keycounttext.setText("counter");
        keycounttext.setForeground(new Color(191, 191, 191));
        keycounttext.setBounds(200, 500, 200, 20);
        keycount = new JTextField(15);
        keycount.setBounds(200, 550, 200, 28);

        //add mouse counter fields
        mousecounttextfield = new JLabel();
        mousecounttextfield.setText("Mouse counter");
        mousecounttextfield.setForeground(new Color(191, 191, 191));
        mousecounttextfield.setBounds(400, 450, 200, 20);
        mouseactionfield = new JTextField(15);
        mouseactionfield.setBounds(400, 500, 200, 28);

        JPanel monitoringBorderPanel = new JPanel();
        monitoringBorderPanel.setLayout(new BorderLayout());
        monitoringBorderPanel.add(welkomeText, BorderLayout.NORTH);
        monitoringBorderPanel.setBackground(new Color(40, 31, 107));
        //mouse label

        JButton WestButton = new JButton();
        monitoringBorderPanel.add(WestButton, BorderLayout.WEST);
        JButton EastButton = new JButton("EAst");
        monitoringBorderPanel.add(EastButton, BorderLayout.EAST);
        //mouse textarea
        //monitoringPanel.add(mousecountText);
        monitoringGridPanel = new JPanel(new GridLayout(4, 2));
        //mousescrollpane
        monitoringGridPanel.add(mousecount);
        monitoringGridPanel.add(keyboardcount);
        monitoringGridPanel.add(scrollPaneMouse);
        monitoringGridPanel.add(scrollPaneKey);
        monitoringGridPanel.add(mouseactionfield);
        monitoringGridPanel.add(keycount);

        monitoringBorderPanel.add(monitoringGridPanel, BorderLayout.CENTER);

        mousecountText.addMouseListener(this);
        mouseactionfield.addMouseListener(this);
        keyboardcountText.addKeyListener(this);
        keycount.addKeyListener(this);

        return monitoringBorderPanel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        View view = new View();
        ClosingView closingView = new ClosingView();
        RegistrationView registration = new RegistrationView();
        WrongCredentialsView wrongcredentials = new WrongCredentialsView();
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
                    gameFrame(view.loginPanel()).dispose();
                    view.gameFrame(view.monitoringPanel());
                    //key action part
                    mousecountText.setText("");
                    keyboardcountText.setText("");
                } else {
                    //close previouos frame
                    gameFrame(view.loginPanel()).dispose();
                    view.gameFrame(wrongcredentials.wrongCredentialsPanel());
                }
            } catch (Exception ea) {
                //close previouos frame
                gameFrame(view.loginPanel()).dispose();
                view.gameFrame(wrongcredentials.wrongCredentialsPanel());
            }
        }
        if (e.getSource() == exitbutton) {
            view.gameFrame(closingView.closePanel());
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        displayInfo(e, "KEY TYPED: ");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        displayInfo(e, "KEY PRESSED: ");
        count++;
        keycount.setText("Totaal:" + count);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        displayInfo(e, "KEY RELEASED: ");
    }

    private void displayInfo(KeyEvent e, String keyStatus) {
        int id = e.getID();
        String keyString;

        if (id == KeyEvent.KEY_TYPED) {
            char c = e.getKeyChar();
            keyString = "key character = '" + c + "'";

        } else {
            int keyCode = e.getKeyCode();
            keyString = "key code = " + keyCode + " (" + KeyEvent.getKeyText(keyCode) + ")";
        }

        int modifiersEx = e.getModifiersEx();
        String modString = "extended modifiers = " + modifiersEx;
        String tmpString = KeyEvent.getModifiersExText(modifiersEx);
        if (tmpString.length() > 0) {
            modString += " (" + tmpString + ")";
        } else {
            modString += " (no extended modifiers)";
        }

        String actionString = "action key? ";
        if (e.isActionKey()) {
            actionString += "YES";
        } else {
            actionString += "NO";
        }

        String locationString = "key location: ";
        int location = e.getKeyLocation();
        if (location == KeyEvent.KEY_LOCATION_STANDARD) {
            locationString += "standard";
        } else if (location == KeyEvent.KEY_LOCATION_LEFT) {
            locationString += "left";
        } else if (location == KeyEvent.KEY_LOCATION_RIGHT) {
            locationString += "right";
        } else if (location == KeyEvent.KEY_LOCATION_NUMPAD) {
            locationString += "numpad";
        } else { // (location == KeyEvent.KEY_LOCATION_UNKNOWN)
            locationString += "unknown";
        }

        keyboardcountText.append(keyStatus + newline + "    " + keyString + newline + "    " + modString + newline + "    " + actionString + newline + "    " + locationString + newline);
        keyboardcountText.setCaretPosition(keyboardcountText.getDocument().getLength());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        displayMouseInfo("Mouse clicked; # of clicks: " + e.getClickCount());
        count++;
        mouseactionfield.setText("total clicks" + count);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        displayMouseInfo("Mouse pressed; # of clicks: " + e.getClickCount());
        mouseactionfield.setText("total clicks" + e.getClickCount());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        displayMouseInfo("Mouse moved" + e.getClickCount());
    }

    @Override
    public void mouseExited(MouseEvent e) {
        displayMouseInfo("Mouse exited" + e.getClickCount());
    }

    private void displayMouseInfo(String eventDescription) {
        mousecountText.append(eventDescription + "." + newline);
    }
}
