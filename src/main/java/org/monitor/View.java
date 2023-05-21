package org.monitor;
import org.monitor.model.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Logger;

public class View extends JFrame implements ActionListener, KeyListener, MouseListener {

    private int score;
    private JLabel username, password, welkomeText,keyboardcount,mousecount,keycounttext,mousecounttextfield;
    private JTextField usernameText, keycount,mouseactionfield;
    private JTextArea mousecountText,keyboardcountText;
    private JPasswordField passwordText;
    private JButton loginbutton,exitbutton,returnbutton,registerbutton,inlogbutton;
    private JPanel loginPanel,registrationPanel,monitoringBorderPanel,monitoringGridPanel,closePanel,wroncredentialspanel;
    private static final Logger log;

    private JScrollPane scrollPaneKey,scrollPaneMouse;
    static final String newline = System.getProperty("line.separator");

    public int count = 0;

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%4$-7s] %5$s %n");
        log = Logger.getLogger(Main.class.getName());
    }
    private ImageIcon logo = new ImageIcon("/home/linuxpc/Documents/studie/Programmeren/Les1&2/work_productivity_monitor/src/main/resources/images/logo_small.png");
    public View(){
        loginPanel();
        monitoringPanel();
        closePanel();
        wrongCredentialsPanel();
    }

    /**
     * guid of the start screen called loginframe
     * @return
     */
    public JComponent getGui(JPanel panel){
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
        welkomeText.setBounds(200, 28, 450, 200);

        username = new JLabel();
        username.setText("vul je email adres in");
        username.setForeground(new Color(191,191,191));
        username.setBounds(200, 208, 170, 20);

        usernameText = new JTextField(15);
        usernameText.setBounds(200, 227, 400, 28);

        password = new JLabel();
        password.setText("kies een wachtwoord");
        password.setForeground(new Color(191,191,191));
        password.setBounds(200, 255, 170, 20);

        passwordText = new JPasswordField(15);
        passwordText.setBounds(200, 275, 400, 28);

        registerbutton = new JButton("registreren");
        registerbutton.setBounds(200, 310, 120, 25);
        registerbutton.setBackground(new Color(239,204,54));
        registerbutton.setForeground(new Color(191,191,191));

        inlogbutton = new JButton("inloggen");
        inlogbutton.setBounds(400, 310, 120, 25);
        inlogbutton.setBackground(new Color(209,31,61));
        inlogbutton.setForeground(new Color(191,191,191));

        registrationPanel = new JPanel();
        registrationPanel.setLayout(null);
        registrationPanel.add(welkomeText);
        registrationPanel.add(username);
        registrationPanel.add(usernameText);

        registrationPanel.add(password);
        registrationPanel.add(passwordText);

        registrationPanel.add(registerbutton);
        registrationPanel.add(inlogbutton);
        registrationPanel.setBackground(new Color(40, 31, 107));

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

        loginbutton = new JButton("Verzenden");
        loginbutton.setBounds(200, 310, 120, 25);
        loginbutton.setBackground(new Color(239,204,54));
        loginbutton.setForeground(new Color(191,191,191));

        exitbutton = new JButton("Uitloggen");
        exitbutton.setBounds(400, 310, 120, 25);
        exitbutton.setBackground(new Color(209,31,61));
        exitbutton.setForeground(new Color(191,191,191));

        loginPanel = new JPanel();
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

    private JPanel monitoringPanel(){
        welkomeText = new JLabel();
        String logintext = "<html><h1>Proceed with the test</h1></html>";
        welkomeText.setText(logintext);
        welkomeText.setFont(new Font("Arial", Font.BOLD, 20));
        welkomeText.setForeground(new Color(245, 239, 239));
        welkomeText.setBounds(200, 28, 450, 200);
        welkomeText.setHorizontalTextPosition(SwingConstants.LEFT);

        mousecount = new JLabel();
        mousecount.setText("mouse activity counter");
        mousecount.setForeground(new Color(191,191,191));
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
        keyboardcount.setForeground(new Color(191,191,191));
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
        keycounttext.setForeground(new Color(191,191,191));
        keycounttext.setBounds(200, 500, 200, 20);
        keycount = new JTextField(15);
        keycount.setBounds(200, 550, 200, 28);

        //add mouse counter fields
        mousecounttextfield = new JLabel();
        mousecounttextfield.setText("Mouse counter");
        mousecounttextfield.setForeground(new Color(191,191,191));
        mousecounttextfield.setBounds(400, 450, 200, 20);
        mouseactionfield = new JTextField(15);
        mouseactionfield.setBounds(400, 500, 200, 28);

        monitoringBorderPanel = new JPanel();
        monitoringBorderPanel.setLayout(new BorderLayout());
        monitoringBorderPanel.add(welkomeText,BorderLayout.NORTH);
        monitoringBorderPanel.setBackground(new Color(40, 31, 107));
        //mouse label

        JButton WestButton = new JButton();
        monitoringBorderPanel.add(WestButton, BorderLayout.WEST);
        JButton EastButton = new JButton("EAst");
        monitoringBorderPanel.add(EastButton, BorderLayout.EAST);
        //mouse textarea
        //monitoringPanel.add(mousecountText);
        monitoringGridPanel = new JPanel(new GridLayout(4,2));
        //mousescrollpane
        monitoringGridPanel.add(mousecount);
        monitoringGridPanel.add(keyboardcount);
        monitoringGridPanel.add(scrollPaneMouse);
        monitoringGridPanel.add(scrollPaneKey);
        monitoringGridPanel.add(mouseactionfield);
        monitoringGridPanel.add(keycount);

        monitoringBorderPanel.add(monitoringGridPanel,BorderLayout.CENTER);

        mousecountText.addMouseListener(this);
        mouseactionfield.addMouseListener(this);
        keyboardcountText.addKeyListener(this);
        keycount.addKeyListener(this);

        return monitoringBorderPanel;
    }

    private JPanel closePanel(){
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

        return closePanel;
    }

    private JPanel wrongCredentialsPanel(){
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
        returnbutton.setBackground(new Color(209,31,61));
        returnbutton.setForeground(new Color(191,191,191));
        wroncredentialspanel.add(returnbutton);
        add(wroncredentialspanel, BorderLayout.CENTER);

        returnbutton.addActionListener(this);
        return wroncredentialspanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String userValue = usernameText.getText();
        View view = new View();
        /*
        TODO  get user entered username from the usernameText
        String passValue = passwordText.getText();
         */
        if (e.getSource() == loginbutton || e.getSource() == inlogbutton) {
            try {
                //call the database and check the input
                User insert = new User();
                System.out.println(insert.getUserData(userValue));
                //check if username already in db
                if (userValue.equals(insert.getUserData(userValue))) {
                    //if authentic, navigate user to a new page
                    //create instance of the monitoring page
                   //TODO not working closing previous form
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
        if (e.getSource() == exitbutton) {
            //close previouos frame
            gameFrame(view.loginPanel()).dispose();
            view.gameFrame(view.closePanel());
        }
        if(e.getSource() == returnbutton){
            //close previouos frame
            gameFrame(view.wrongCredentialsPanel()).dispose();
            view.gameFrame(view.loginPanel());
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
         keycount.setText("Totaal:"+ count);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        displayInfo(e, "KEY RELEASED: ");
    }
    private void displayInfo(KeyEvent e, String keyStatus){
        int id = e.getID();
        String keyString;

        if (id == KeyEvent.KEY_TYPED) {
            char c = e.getKeyChar();
            keyString = "key character = '" + c + "'";

        } else {
            int keyCode = e.getKeyCode();
            keyString = "key code = " + keyCode
                    + " ("
                    + KeyEvent.getKeyText(keyCode)
                    + ")";
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

        keyboardcountText.append(keyStatus + newline
                + "    " + keyString + newline
                + "    " + modString + newline
                + "    " + actionString + newline
                + "    " + locationString + newline);
        keyboardcountText.setCaretPosition(keyboardcountText.getDocument().getLength());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        displayMouseInfo("Mouse clicked; # of clicks: "+ e.getClickCount());
        count++;
        mouseactionfield.setText("total clicks"+count);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        displayMouseInfo("Mouse pressed; # of clicks: "
                + e.getClickCount());

        mouseactionfield.setText("total clicks"+e.getClickCount());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       displayMouseInfo("Mouse moved"+ e.getClickCount());
    }

    @Override
    public void mouseExited(MouseEvent e) {
    displayMouseInfo("Mouse exited"+ e.getClickCount());
    }

    private void displayMouseInfo(String eventDescription){

        mousecountText.append(eventDescription+ "." + newline);
    }
}
