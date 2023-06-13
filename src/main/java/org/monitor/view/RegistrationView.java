package org.monitor.view;

import org.monitor.View;
import org.monitor.model.User;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationView extends JFrame implements ActionListener {

    public User user = new User();
    private String userValue, firstname, lastname, streetname, postalcode, cityname, coutryname, emailregistration, passwordregistration, housenumber, phonenumber;
    private JLabel welkomeText, firstnamelabel, lastnamelabel, streetnamelabel, housenumberlabel, phonelabel, citylabel, countrylabel, postalcodelabel, emailregistrationlabel, passwordregistrationLabel,inloglabel;
    private JTextField emailregistrationtext, passwordregistrationText, firstnametext, laststnametext, streetnametext, housenumbertext, postalcodetext, phonetext, citytext, countrytext;
    private JButton registerbutton, inlogbutton;

    public JPanel registrationPanel() {
        welkomeText = new JLabel();
        String logintext = "<html><p>Registreer je om deel te nemen aan de werk monitor applicatie</p></html>";
        welkomeText.setText(logintext);
        welkomeText.setFont(new Font("Arial", Font.BOLD, 24));
        welkomeText.setForeground(new Color(6,6,6));
        welkomeText.setBounds(600, 28, 450, 200);

        //voornaam
        firstnamelabel = new JLabel();
        firstnamelabel.setText("Voornaam");
        firstnamelabel.setFont(new Font("Arial", Font.BOLD, 18));
        firstnamelabel.setForeground(new Color(48, 48, 48, 100));
        firstnamelabel.setBounds(300, 200, 170, 28);
        firstnametext = new JTextField(15);
        firstnametext.setBounds(600, 200, 400, 28);

        //achternaam
        lastnamelabel = new JLabel();
        lastnamelabel.setText("Achternaam");
        lastnamelabel.setFont(new Font("Arial", Font.BOLD, 18));
        lastnamelabel.setForeground(new Color(48, 48, 48, 100));
        lastnamelabel.setBounds(300, 230, 170, 28);
        laststnametext = new JTextField(15);
        laststnametext.setBounds(600, 230, 400, 28);

        //straatnaam
        streetnamelabel = new JLabel();
        streetnamelabel.setText("Straatnaam");
        streetnamelabel.setFont(new Font("Arial", Font.BOLD, 18));
        streetnamelabel.setForeground(new Color(48, 48, 48, 100));
        streetnamelabel.setBounds(300, 260, 170, 28);
        streetnametext = new JTextField(15);
        streetnametext.setBounds(600, 260, 400, 28);

        //postalcode
        postalcodelabel = new JLabel();
        postalcodelabel.setText("Postcode");
        postalcodelabel.setFont(new Font("Arial", Font.BOLD, 18));
        postalcodelabel.setForeground(new Color(48, 48, 48, 100));
        postalcodelabel.setBounds(300, 290, 400, 28);
        postalcodetext = new JTextField(15);
        postalcodetext.setToolTipText("1245AB");
        postalcodetext.setBounds(600, 290, 100, 28);

        //housenumber
        housenumberlabel = new JLabel();
        housenumberlabel.setText("Huisnummer");
        housenumberlabel.setFont(new Font("Arial", Font.BOLD, 18));
        housenumberlabel.setForeground(new Color(48, 48, 48, 100));
        housenumberlabel.setBounds(300, 320, 170, 20);
        housenumbertext = new JTextField(15);
        housenumbertext.setBounds(600, 320, 70, 28);
        //city
        citylabel = new JLabel();
        citylabel.setText("Stad");
        citylabel.setFont(new Font("Arial", Font.BOLD, 18));
        citylabel.setForeground(new Color(48, 48, 48, 100));
        citylabel.setBounds(300, 350, 170, 28);
        citytext = new JTextField(15);
        citytext.setBounds(600, 350, 400, 28);

        //country
        countrylabel = new JLabel();
        countrylabel.setText("Land");
        countrylabel.setFont(new Font("Arial", Font.BOLD, 18));
        countrylabel.setForeground(new Color(48, 48, 48, 100));
        countrylabel.setBounds(300, 380, 170, 28);
        countrytext = new JTextField(15);
        countrytext.setBounds(600, 380, 400, 28);

        //phonenumber
        phonelabel = new JLabel();
        phonelabel.setText("Telefoonnummer");
        phonelabel.setFont(new Font("Arial", Font.BOLD, 18));
        phonelabel.setForeground(new Color(48, 48, 48, 100));
        phonelabel.setBounds(300, 410, 400, 28);
        phonetext = new JTextField(15);
        phonetext.setBounds(600, 410, 400, 28);

        emailregistrationlabel = new JLabel();
        emailregistrationlabel.setText("Email-adres");
        emailregistrationlabel.setFont(new Font("Arial", Font.BOLD, 18));
        emailregistrationlabel.setForeground(new Color(48, 48, 48, 100));
        emailregistrationlabel.setBounds(300, 440, 250, 28);
        emailregistrationtext = new JTextField(15);
        emailregistrationtext.setBounds(600, 440, 400, 28);

        passwordregistrationLabel = new JLabel();
        passwordregistrationLabel.setText("kies een wachtwoord");
        passwordregistrationLabel.setFont(new Font("Arial", Font.BOLD, 18));
        passwordregistrationLabel.setForeground(new Color(48, 48, 48, 100));
        passwordregistrationLabel.setBounds(300, 470, 250, 28);
        passwordregistrationText = new JPasswordField(15);
        passwordregistrationText.setBounds(600, 470, 400, 28);

        registerbutton = new JButton("registreren");
        registerbutton.setBounds(600, 520, 250, 50);
        registerbutton.setFont(new Font("Arial", Font.BOLD, 20));
        registerbutton.setFocusPainted(false);
        registerbutton.setForeground(Color.WHITE);
        registerbutton.setBackground(new Color(0,173,230));
        registerbutton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        inloglabel = new JLabel();
        String HTMLlabelStr = "<html><h1>Of als je al geregistreerd bent. Log in </h1></html>";

        inloglabel.setText(HTMLlabelStr);
        inloglabel.setForeground(Color.BLACK);
        inloglabel.setBounds(600, 620, 500, 50);

        inlogbutton = new JButton("inloggen");
        inlogbutton.setBounds(600, 670, 250, 50);
        inlogbutton.setFont(new Font("Arial", Font.BOLD, 20));
        inlogbutton.setFocusPainted(false);
        inlogbutton.setForeground(new Color(0,173,230));
        inlogbutton.setBorder(BorderFactory.createBevelBorder(1,new Color(0,173,230),new Color(0,173,230)));

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
        registrationPanel.add(inloglabel);
        registrationPanel.add(inlogbutton);
        registrationPanel.setBackground(new Color(255, 255, 255));

        add(registrationPanel, BorderLayout.CENTER);
        registerbutton.addActionListener(this);
        inlogbutton.addActionListener(this);

        return registrationPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        LoginView lpanel = new LoginView();
        View view = new View();

        if (e.getSource() == inlogbutton) {
            var test = new JFrame();
            test.setVisible(false);
            test.dispose();

            view.gameFrame(lpanel.loginPanel());
        }

        if (e.getSource() == registerbutton) {

            if (emailregistrationtext.getText() != null || passwordregistrationText.getText() != null) {

                try {
                    firstname = firstnametext.getText();
                    lastname = laststnametext.getText();
                    streetname = streetnametext.getText();
                    housenumber = housenumbertext.getText();
                    postalcode = postalcodetext.getText();
                    phonenumber = phonetext.getText();
                    cityname = citytext.getText();
                    coutryname = countrytext.getText();
                    emailregistration = emailregistrationtext.getText();
                    passwordregistration = passwordregistrationText.getText();
                } catch (Exception es) {
                    JOptionPane.showMessageDialog(null, "Controleer je invoer", "Error", JOptionPane.ERROR_MESSAGE);
                }

                try {
                    Pattern emailpattern = Pattern.compile("[a-zA-Z.0-9]+@[a-zA-Z]+.[a-zA-Z]{2,5}");
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
//                            view.gameFrame(registrationPanel()).dispose();
                            var test = new JFrame();
                            test.setVisible(false);
                            test.dispose();
                            view.gameFrame(lpanel.loginPanel());
                        }
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Controleer je invoer", "Error", JOptionPane.ERROR_MESSAGE);

                }
            }
        }
    }
}
