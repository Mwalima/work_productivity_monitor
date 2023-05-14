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
    private JButton login,exit;
    private JPanel loginPanel, monitoringBorderPanel,monitoringGridPanel,closePanel;
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
        loginForm();
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
        Main form = new Main();
        form.setDefaultCloseOperation(EXIT_ON_CLOSE);
        form.setSize(800, 800);
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
//        welkomeText.setBounds(200, 28, 450, 200);

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

        JButton WestButton = new JButton("West");
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

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 800);
        setTitle("Provincie Zuid-Holland Werk Monitor scherm 2");
        setLocationRelativeTo(null);
        getContentPane().add(monitoringBorderPanel);
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
        setSize(800, 800);
        setTitle("Provincie Zuid-Holland Werk Monitor scherm 3");
        setLocationRelativeTo(null);
        add(closePanel);
        setIconImage(logo.getImage());
        setVisible(true);
    }

    public void wrongCredentialsFrame(){
        Main formwroncred = new Main();
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

        formwroncred.setSize(800, 800);
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
                //check if username already in db
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
        //key action part
        mousecountText.setText("");
        keyboardcountText.setText("");
        //Return the focus to the typing area.
        keyboardcountText.requestFocusInWindow();
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

    /*
     * We have to jump through some hoops to avoid
     * trying to print non-printing characters
     * such as Shift.  (Not only do they not print,
     * but if you put them in a String, the characters
     * afterward won't show up in the text area.)
     */
    private void displayInfo(KeyEvent e, String keyStatus){
        //You should only rely on the key char if the event
        //is a key typed event.
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
        mouseactionfield.setText("total clicks"+e.getClickCount());
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
