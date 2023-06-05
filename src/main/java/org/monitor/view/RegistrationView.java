package org.monitor.view;

import org.monitor.View;
import org.monitor.model.User;

import javax.swing.*;
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


        inloglabel = new JLabel();
        String HTMLlabelStr = "<html><h1>Of als je al geregistreerd bent. Log in </h1></html>";

        inloglabel.setText(HTMLlabelStr);
        inloglabel.setForeground(Color.WHITE);
        inloglabel.setBounds(400, 620, 500, 50);

        inlogbutton = new JButton("inloggen");
        inlogbutton.setBounds(600, 670, 120, 25);
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
        registrationPanel.add(inloglabel);
        registrationPanel.add(inlogbutton);
        registrationPanel.setBackground(new Color(171, 167, 201));

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
                            view.gameFrame(registrationPanel()).dispose();
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
