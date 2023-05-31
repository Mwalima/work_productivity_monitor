package org.monitor;

import org.monitor.model.User;
import org.monitor.view.ClosingView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class View extends JFrame implements ActionListener, KeyListener, MouseListener {
    static final String newline = System.getProperty("line.separator");
    private static final Logger log;

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%4$-7s] %5$s %n");
        log = Logger.getLogger(View.class.getName());
    }

    public int count = 0;

    private String userValue, firstname, lastname, streetname, postalcode, cityname, coutryname, emailregistration, passwordregistration, housenumber, phonenumber;
    private JLabel username, password, welkomeText, keyboardcount, mousecount, keycounttext, mousecounttextfield, firstnamelabel, lastnamelabel, streetnamelabel, housenumberlabel, phonelabel, citylabel, countrylabel, postalcodelabel, emailregistrationlabel, passwordregistrationLabel;
    private JTextField usernameText, keycount, mouseactionfield, emailregistrationtext, passwordregistrationText, firstnametext, laststnametext, streetnametext, housenumbertext, postalcodetext, phonetext, citytext, countrytext;
    private JTextArea mousecountText, keyboardcountText;
    private JButton loginbutton, exitbutton, returnbutton, registerbutton, inlogbutton;
    private JPanel monitoringGridPanel;
    private JPanel closePanel;
    private JPanel wroncredentialspanel;
    private JScrollPane scrollPaneKey, scrollPaneMouse;
    private final ImageIcon logo = new ImageIcon("./resources/images/logo_small.png");

    public View() {
        loginPanel();
        monitoringPanel();
        wrongCredentialsPanel();
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

    public JPanel registrationPanel() {
        welkomeText = new JLabel();
        String logintext = "<html><p>Registreer je om deel te nemen aan de werk monitor applicatie</p></html>";
        welkomeText.setText(logintext);
        welkomeText.setFont(new Font("Arial", Font.BOLD, 20));
        welkomeText.setForeground(new Color(245, 239, 239));
        welkomeText.setBounds(600, 28, 450, 200);

        //voornaam
        firstnamelabel = new JLabel();
        firstnamelabel.setText("vul je voornaam in");
        firstnamelabel.setForeground(new Color(72, 70, 70));
        firstnamelabel.setBounds(200, 200, 170, 20);
        firstnametext = new JTextField(15);
        firstnametext.setBounds(600, 200, 400, 28);

        //achternaam
        lastnamelabel = new JLabel();
        lastnamelabel.setText("vul je achternaam in");
        lastnamelabel.setForeground(new Color(72, 70, 70));
        lastnamelabel.setBounds(200, 230, 170, 20);
        laststnametext = new JTextField(15);
        laststnametext.setBounds(600, 230, 400, 28);

        //straatnaam
        streetnamelabel = new JLabel();
        streetnamelabel.setText("vul je straatnaam in");
        streetnamelabel.setForeground(new Color(72, 70, 70));
        streetnamelabel.setBounds(200, 260, 170, 20);
        streetnametext = new JTextField(15);
        streetnametext.setBounds(600, 260, 400, 28);

        //postalcode
        postalcodelabel = new JLabel();
        postalcodelabel.setText("vul je postcode in (zonderspatie) 1234AB");
        postalcodelabel.setForeground(new Color(72, 70, 70));
        postalcodelabel.setBounds(200, 290, 350, 20);
        //TODO add placholder
        postalcodetext = new JTextField(15);
        postalcodetext.setBounds(600, 290, 100, 28);

        //housenumber
        housenumberlabel = new JLabel();
        housenumberlabel.setText("vul je huinummer in");
        housenumberlabel.setForeground(new Color(72, 70, 70));
        housenumberlabel.setBounds(200, 320, 170, 20);
        housenumbertext = new JTextField(15);
        housenumbertext.setBounds(600, 320, 70, 28);
        //city
        citylabel = new JLabel();
        citylabel.setText("vul je stad in");
        citylabel.setForeground(new Color(72, 70, 70));
        citylabel.setBounds(200, 350, 170, 20);
        citytext = new JTextField(15);
        citytext.setBounds(600, 350, 400, 28);

        //country
        countrylabel = new JLabel();
        countrylabel.setText("vul je land in");
        countrylabel.setForeground(new Color(72, 70, 70));
        countrylabel.setBounds(200, 380, 170, 20);
        countrytext = new JTextField(15);
        countrytext.setBounds(600, 380, 400, 28);

        //phonenumber
        phonelabel = new JLabel();
        phonelabel.setText("vul je telefoonnummer in (10 cijfers)");
        phonelabel.setForeground(new Color(72, 70, 70));
        phonelabel.setBounds(200, 410, 350, 20);
        phonetext = new JTextField(15);
        phonetext.setBounds(600, 410, 400, 28);

        emailregistrationlabel = new JLabel();
        emailregistrationlabel.setText("vul je email adres in");
        emailregistrationlabel.setForeground(new Color(72, 70, 70));
        emailregistrationlabel.setBounds(200, 440, 170, 20);
        emailregistrationtext = new JTextField(15);
        emailregistrationtext.setBounds(600, 440, 400, 28);

        passwordregistrationLabel = new JLabel();
        passwordregistrationLabel.setText("kies een wachtwoord");
        passwordregistrationLabel.setForeground(new Color(72, 70, 70));
        passwordregistrationLabel.setBounds(200, 470, 170, 20);
        passwordregistrationText = new JPasswordField(15);
        passwordregistrationText.setBounds(600, 470, 400, 28);

        registerbutton = new JButton("registreren");
        registerbutton.setBounds(600, 520, 120, 25);
        registerbutton.setBackground(new Color(239, 204, 54));
        registerbutton.setForeground(Color.BLACK);

        inlogbutton = new JButton("inloggen");
        inlogbutton.setBounds(800, 520, 120, 25);
        inlogbutton.setBackground(new Color(209, 31, 61));
        inlogbutton.setForeground(Color.WHITE);

        JPanel registrationPanel = new JPanel();
        registrationPanel.setLayout(null);
        registrationPanel.add(welkomeText);

        registrationPanel.add(firstnamelabel);
        registrationPanel.add(firstnametext);

        registrationPanel.add(lastnamelabel);
        registrationPanel.add(laststnametext);

        registrationPanel.add(streetnamelabel);
        registrationPanel.add(streetnametext);

        registrationPanel.add(postalcodelabel);
        registrationPanel.add(postalcodetext);

        registrationPanel.add(housenumberlabel);
        registrationPanel.add(housenumbertext);

        registrationPanel.add(citylabel);
        registrationPanel.add(citytext);

        registrationPanel.add(countrylabel);
        registrationPanel.add(countrytext);

        registrationPanel.add(phonelabel);
        registrationPanel.add(phonetext);

        registrationPanel.add(emailregistrationlabel);
        registrationPanel.add(emailregistrationtext);

        registrationPanel.add(passwordregistrationLabel);
        registrationPanel.add(passwordregistrationText);

        registrationPanel.add(registerbutton);
        registrationPanel.add(inlogbutton);
        registrationPanel.setBackground(new Color(171, 167, 201));

        add(registrationPanel, BorderLayout.CENTER);
        registerbutton.addActionListener(this);
        inlogbutton.addActionListener(this);

        return registrationPanel;
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

        JPasswordField passwordText = new JPasswordField(15);
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
    private JPanel monitoringPanel() {
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

   private JPanel wrongCredentialsPanel() {
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
        ClosingView closingView = new ClosingView();
        User user = new User();

        /*
        TODO  get user entered username from the usernameText
        String passValue = passwordText.getText();
         */
        if (e.getSource() == loginbutton) {
            try {
                userValue = usernameText.getText();

                if (userValue.equals(user.getUserData(userValue))) {
                    //if authentic, navigate user to a new page
                    gameFrame(view.loginPanel()).dispose();
                    view.gameFrame(view.monitoringPanel());
                    //key action part
                    mousecountText.setText("");
                    keyboardcountText.setText("");
                } else {
                    //close previouos frame
                    gameFrame(view.loginPanel()).dispose();
                    view.gameFrame(view.wrongCredentialsPanel());
                }
            } catch (Exception ea) {
                //close previouos frame
                gameFrame(view.loginPanel()).dispose();
                view.gameFrame(view.wrongCredentialsPanel());
            }
        }
        if (e.getSource() == inlogbutton) {
            //close previouos frame
            gameFrame(view.registrationPanel()).dispose();
            view.gameFrame(view.loginPanel());
        }
        if (e.getSource() == exitbutton) {
            view.gameFrame(closingView.closePanel());
        }
        if (e.getSource() == returnbutton) {
            //close previouos frame
            gameFrame(view.wrongCredentialsPanel()).dispose();
            view.gameFrame(view.loginPanel());
        }
        if (e.getSource() == registerbutton) {

            if (emailregistrationtext.getText() != null || passwordregistrationText.getText() != null) {

                try {
                    firstname = firstnametext.getText();
                    lastname = laststnametext.getText();
                    streetname = streetnametext.getText();
                    housenumber = housenumbertext.getText();
                    postalcode = postalcodetext.getText();
                    System.out.println(phonenumber);
                    phonenumber = phonetext.getText();
                    cityname = citytext.getText();
                    coutryname = countrytext.getText();
                    emailregistration = emailregistrationtext.getText();
                    passwordregistration = passwordregistrationText.getText();
                } catch (Exception es) {
                    JOptionPane.showMessageDialog(null, "Controleer je invoer", "Error", JOptionPane.ERROR_MESSAGE);
                }

                try {
                    Pattern emailpattern = Pattern.compile("[a-zA-Z.]+@[a-zA-Z]+.[a-zA-Z]{2,5}");
                    Pattern postalcodepattern = Pattern.compile("[1-9]{1}[0-9]{3}[a-zA-Z]{2}");
                    Pattern housenumberpattern = Pattern.compile("[1-9]{1}[0-9]{0,3}");
                    Pattern phonepattern = Pattern.compile("[0]{1}[0-9]{9}");

                    Matcher postalcodematcher = postalcodepattern.matcher(postalcode);
                    Matcher housenumbermatcher = housenumberpattern.matcher(housenumber);
                    Matcher emailmatcher = emailpattern.matcher(emailregistration);
                    Matcher phonematcher = phonepattern.matcher(phonenumber);

                    if (!postalcodematcher.matches()) {
                        JOptionPane.showMessageDialog(null, "Voer een geldige postcode in", "Error", JOptionPane.ERROR_MESSAGE);
                    } else if (!housenumbermatcher.matches()) {
                        JOptionPane.showMessageDialog(null, "voer een geldig huisnummer in", "Error", JOptionPane.ERROR_MESSAGE);
                    } else if (!phonematcher.matches()) {
                        JOptionPane.showMessageDialog(null, "Voer een geldig telefoonnummer in", "Error", JOptionPane.ERROR_MESSAGE);
                    } else if (!emailmatcher.matches()) {
                        JOptionPane.showMessageDialog(null, "voer een geldig email-adres in", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        user.setFirstname(firstname);
                        user.setLastname(lastname);
                        user.setStreetname(streetname);
                        user.setHousenumber(housenumber);
                        user.setPostalcode(postalcode);
                        user.setCityname(cityname);
                        user.setCountry(coutryname);

                        int number = Integer.parseInt(phonenumber);
                        user.setPhonenumber(number);
                        user.setPassword(passwordregistration);
                        user.setEmailadress(emailregistration);

                        if (user.insertUser() == 1) {
                            JOptionPane.showMessageDialog(null, "Succesvoll geregistreerd", "Succes", JOptionPane.PLAIN_MESSAGE);
                            gameFrame(view.registrationPanel()).dispose();
                            view.gameFrame(view.loginPanel());
                        }
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Controleer je invoer", "Error", JOptionPane.ERROR_MESSAGE);

                }

            }

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
