package org.monitor.view;

import org.monitor.View;
import org.monitor.helper.CustomDialog;
import org.monitor.helper.Reminder;
import org.monitor.model.Score;
import org.monitor.model.User;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;

public class MonitorView extends JFrame implements ActionListener, MouseListener, KeyListener, CaretListener {

    public Score insert_user_score = new Score();
    private CustomDialog dialog;
    private Reminder rem;
    public int count = 0;
    public int mouse_count = 0;
    private JLabel username;
    private JLabel score_label;
    private JButton exit_button, stop_button;
    private JTextField keycount, mouseactionfield;
    private JTextArea mousecountText, keyboardcountText, test_text_input_field, test_textfield;
    private JScrollPane scrollPaneKey, scrollPaneMouse;
    JLabel timeLabel = new JLabel();
    private int elpapesdTime;
    private Time elpapesdTimeLocal;
    private int minutes = 0;
    private int mousescore_string = 0;
    private int keyscore_string = 0;
    private int elapesdtime_string = 0;
    private int score_string = 0;
    private int seconds = 0;
    private int hours = 0;
    private int milliseconds = 0;
    private double score = 0.0;
    private String milliseconds_string = String.format("%02d", milliseconds);
    private String seconds_string = String.format("%02d", seconds);
    private String minutes_string = String.format("%02d", minutes);
    private String hours_string = String.format("%02d", hours);
    private String type_tekst = "De test gaat om het zo snel en foutloos na typen van de tekst. Veel vlaggen, liederen waarin Catalonië en Spanje ('puta, puta') de hoofdrol spelen en meer dan genoeg bier om de warmte te trotseren. De fans van Barcelona hebben aan het begin van de zaterdagmiddag hun stek in het centrum van Eindhoven wel gevonden: voor de deur van het hotel waarvandaan het team straks naar het Philips-stadion vertrekt. Af en toe moeten de honderden supporters even inschikken om de stadsbus van lijn elf te laten passeren. 'Een mooi feest', zeggen Mirreia en Marcos uit Barcelona. Ze volgen de favoriet voor de finale van de Champions League al jaren. Op het mannenvoetbal is het stel een beetje uitgekeken. In de vrouwencompetitie kan je voor 20 euro een kaartje krijgen, bij de mannen is dat zeker het dubbele, zegt Marcos. En nooit zijn er problemen, dat telt voor ons ook. Vorig jaar was het stel nog in Turijn, waar Barcelona de beker aan Olympique Lyonnais moest laten. Tegen VFL Wolfsburg hopen ze op meer succes. 'Maar dit is sowieso een mooie dag', zegt Mirreia, bij de vrouwen zien we veel meer voetbal en minder agressie en theater op het veld.";
    final static boolean shouldFill = true;
    final static boolean RIGHT_TO_LEFT = false;
    public static String emailadress, password, userId,userName;
    static final String newline = System.getProperty("line.separator");

    public MonitorView() {}
    public MonitorView(String emailadress, String password) throws HeadlessException, SQLException, IOException {
        this.emailadress = emailadress;
        this.password = password;
    }

    public JPanel monitoringPanel() throws SQLException, IOException {
        /**
         * gridbag layout
         * _________________________________________
         * __-stopwatch____|____score____|__exitbutton___
         * _____mouse-activity___|___Key-activity____
         * _______counter__ |____Counter_____________
         * _______Teskst field________________________
         */
        JLabel welkomeText = new JLabel();
        String logintext = "Start de vaardigheidstest";
        welkomeText.setText(logintext);
        welkomeText.setFont(new Font("Arial", Font.BOLD, 24));
        welkomeText.setForeground(new Color(6, 6, 6));
        welkomeText.setBounds(200, 28, 450, 200);
        welkomeText.setHorizontalTextPosition(SwingConstants.RIGHT);

        username = new JLabel();
        User getuserfromdb = new User();
        getuserfromdb.setEmailadress(emailadress);
        getuserfromdb.setPassword(password);
        try {
            this.userName = getuserfromdb.getUserName().get(1);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        username.setText("Welkom bij de test:"+this.userName);

        username.setFont(new Font("Arial", Font.PLAIN, 14));
        username.setForeground(new Color(6, 6, 6));
        username.setBounds(200, 28, 450, 200);

        timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1, new Color(0, 173, 230), new Color(0, 173, 230)));
        timeLabel.setBackground(Color.WHITE);
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);

        //score panel
        score_label = new JLabel("mouse score:" + mousescore_string + " keyboard score:" + keyscore_string + " elapsed time:" + elapesdtime_string + " score:" + score_string);
        score_label.setFont(new Font("Arial", Font.PLAIN, 20));
        score_label.setBorder(BorderFactory.createBevelBorder(1, new Color(0, 173, 230), new Color(0, 173, 230)));
        score_label.setBackground(Color.WHITE);
        score_label.setOpaque(true);
        score_label.setHorizontalAlignment(JTextField.CENTER);

        //exit button
        exit_button = new JButton("Exit");
        exit_button.setBounds(200, 200, 250, 150);
        exit_button.setFont(new Font("Arial", Font.PLAIN, 20));
        exit_button.setBorder(BorderFactory.createBevelBorder(1, new Color(0, 173, 230), new Color(0, 173, 230)));
        exit_button.setFocusable(false);

        //big stop button
        stop_button = new JButton("Stop");
        stop_button.setBounds(200, 200, 250, 150);
        stop_button.setFont(new Font("Arial", Font.PLAIN, 20));
        stop_button.setBorder(BorderFactory.createBevelBorder(1, new Color(0, 173, 230), new Color(0, 173, 230)));
        stop_button.setFocusable(false);

        mousecountText = new JTextArea();
        mousecountText.setWrapStyleWord(true);
        mousecountText.setBounds(500, 200, 200, 300);

        scrollPaneMouse = new JScrollPane(mousecountText);
        scrollPaneMouse.setPreferredSize(new Dimension(100, 300));
        mousecountText.setEditable(false);

        keyboardcountText = new JTextArea();
        keyboardcountText.setWrapStyleWord(true);
        keyboardcountText.setBounds(200, 200, 200, 300);

        keyboardcountText.setEditable(false);
        scrollPaneKey = new JScrollPane(keyboardcountText);
        scrollPaneKey.setPreferredSize(new Dimension(100, 300));

        //add counter fields
        JLabel keycounttext = new JLabel();
        keycounttext.setText("counter");
        keycounttext.setForeground(new Color(191, 191, 191));
        keycounttext.setBounds(200, 500, 200, 20);
        keycount = new JTextField(15);
        keycount.setBounds(200, 550, 200, 28);

        //add mouse counter fields
        JLabel mousecounttextfield = new JLabel();
        mousecounttextfield.setText("Mouse monitor");
        mousecounttextfield.setForeground(Color.BLACK);
        mousecounttextfield.setBounds(600, 450, 200, 20);
        mouseactionfield = new JTextField(15);
        mouseactionfield.setBounds(400, 500, 200, 28);

        //set the settings for the diplayed text
        keyboardcountText.setEditable(false);
        scrollPaneKey = new JScrollPane(keyboardcountText);
        scrollPaneKey.setPreferredSize(new Dimension(100, 300));

        //test tekst area
        test_textfield = new JTextArea(type_tekst);
        test_textfield.setWrapStyleWord(true);
        test_textfield.setColumns(10);
        test_textfield.setRows(5);
        test_textfield.setLineWrap(true);
        test_textfield.setFont(new Font("Arial", Font.BOLD, 18));
        test_textfield.setEditable(false);
        test_textfield.setBounds(400, 700, 200, 100);
        JScrollPane scrollPane_test = new JScrollPane(test_textfield);
        scrollPane_test.setPreferredSize(new Dimension(100, 200));

        test_text_input_field = new JTextArea();
        test_text_input_field.setWrapStyleWord(true);
        test_text_input_field.setBounds(400, 900, 200, 100);
        test_text_input_field.setFont(new Font("Arial", Font.BOLD, 18));
        JScrollPane scrollPaneInput = new JScrollPane(test_text_input_field);
        scrollPaneInput.setPreferredSize(new Dimension(100, 200));

        //add the layout in gridbag why the most difficult one?
        JPanel monitoringBorderPanel = new JPanel();
        monitoringBorderPanel.setLayout(new GridBagLayout());
        monitoringBorderPanel.setBackground(new Color(255, 255, 255));

        //specify the GridBagConstraints
        GridBagConstraints c = new GridBagConstraints();
        if (RIGHT_TO_LEFT) {
            monitoringBorderPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
        if (shouldFill) {
            c.fill = GridBagConstraints.HORIZONTAL;
        }
        //add welkomtekst tekstfield to gridbag
        c.fill = GridBagConstraints.PAGE_START;
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(0, 0, 10, 0);
        monitoringBorderPanel.add(welkomeText, c);

        //add username tekstfield to gridbag
        c.fill = GridBagConstraints.PAGE_END;
        c.gridx = 2;
        c.gridy = 0;
        c.insets = new Insets(10, 10, 10, 0);
        monitoringBorderPanel.add(username, c);

        //add the timer on beneath and left
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.insets = new Insets(10, 0, 0, 0);
        monitoringBorderPanel.add(timeLabel, c);

        //add the scorefield on beneath of the title and center
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.insets = new Insets(10, 10, 0, 0);
        monitoringBorderPanel.add(score_label, c);

        //add the exit_button on beneath of the title and right
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 2;
        c.gridy = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.insets = new Insets(10, 10, 0, 0);
        monitoringBorderPanel.add(exit_button, c);

        //add the scrollPaneMouse on beneath of the button row
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 3;
        c.weightx = 1.0;
        c.weighty = 1.0;
        monitoringBorderPanel.add(scrollPaneMouse, c);

        //add the stop_button on beneath of the title and right
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 3;
        c.weightx = 1.0;
        c.weighty = 1.0;
        monitoringBorderPanel.add(stop_button, c);

        //add the exit_button on beneath of the title and right
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 2;
        c.gridy = 3;
        c.weightx = 1.0;
        c.weighty = 1.0;
        monitoringBorderPanel.add(scrollPaneKey, c);

        //add the mouseactionfield on beneath of the title and right
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 4;
        c.weightx = 1.0;
        c.weighty = 1.0;
        monitoringBorderPanel.add(mouseactionfield, c);

        //add the keycount on beneath of the title and right
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 4;
        c.weightx = 1.0;
        c.weighty = 1.0;
        monitoringBorderPanel.add(keycount, c);

        //add the keycount on beneath of the title and right
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 3;
        c.weightx = 1.0;
        c.weighty = 1.0;
        monitoringBorderPanel.add(scrollPane_test, c);

        //add the keycount on beneath of the title and right
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 6;
        c.gridwidth = 3;
        c.weightx = 1.0;
        c.weighty = 1.0;
        monitoringBorderPanel.add(scrollPaneInput, c);

        //listners
        test_text_input_field.addMouseListener(this);
        test_text_input_field.addKeyListener(this);
        test_text_input_field.addCaretListener(this);
        mouseactionfield.addMouseListener(this);
        keyboardcountText.addKeyListener(this);
        mousecountText.addMouseListener(this);
        keycount.addKeyListener(this);
        stop_button.addActionListener(this);
        exit_button.addActionListener(this);

        return monitoringBorderPanel;
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
        if (e.getSource() == test_text_input_field) {
            start();
        }
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
        mouse_count++;
        mouseactionfield.setText("total mouse action:" + mouse_count);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        displayMouseInfo("Mouse pressed; # of clicks: " + e.getClickCount());
        mouse_count++;
        mouseactionfield.setText("total mouse action:" + mouse_count);
        if (e.getSource() == test_text_input_field) {
            start();
        }
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
        if (e.getSource() == test_text_input_field) {
            stop();
        }
    }

    private void displayMouseInfo(String eventDescription) {
        mousecountText.append(eventDescription + "." + newline);
    }

    Timer timer = new Timer(10, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            elpapesdTime += 1000;
            hours = (elpapesdTime / 3600000);
            minutes = (elpapesdTime / 60000) % 60;
            seconds = (elpapesdTime / 1000) % 60;
            //milliseconds = (elpapesdTime);
            if (milliseconds > 99) {
                milliseconds = 0;
            }
            hours_string = String.format("%02d", hours);
            minutes_string = String.format("%02d", minutes);
            seconds_string = String.format("%02d", seconds);
            // milliseconds_string = String.format("%02d", milliseconds);
            timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
        }
    });

    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        View view = new View();
        //key action part
        mousecountText.setText("");
        keyboardcountText.setText("");

        try {
            //closing action
            if (e.getSource() == exit_button) {
                //set the delay of the timer times 3
                Reminder rem = new Reminder(1);
                //try to close privious JFrame
                JFrame test = new JFrame();
                test.setVisible(false);
                test.dispose();
                //show the dialog
                dialog = new CustomDialog(view.gameFrame(this.monitoringPanel()), "De applicatie sluit over 3 seconden");
                dialog.setFont(new Font("Arial", Font.BOLD, 18));
                dialog.setVisible(true);
            }
            if (e.getSource() == stop_button) {
                //get the current userid to insert it properly into the db
                User getuserfromdb = new User();
                getuserfromdb.setEmailadress(emailadress);
                getuserfromdb.setPassword(password);
                this.userId = getuserfromdb.getUserName().get(0);

                //converting localtime to time because of SQL datatype datatime
                LocalTime totaltime = LocalTime.parse(hours_string + ":" + minutes_string + ":" + seconds_string);
                Time time = Time.valueOf(totaltime);
                //convert time to seconds
                elpapesdTimeLocal = time;

                int time_converter = (((hours * 60) + (minutes)));
                //count is het aantal characters van de tekst

                if(count() > 0) {
                    double convert = (double)time_converter / 60;
                    score = (double) (count() / convert);
                }else{
                    score = (double) 0.0;
                }

                String total = String.format("Mouse score: %s| Keyboard score: %s | Elapsed time: %s |Score in WPM: %s", this.mouse_count, this.count, elpapesdTimeLocal, score);
                insert_user_score.insertScore(this.userId, this.count, this.mouse_count, score, elpapesdTimeLocal);
                score_label.setText(total);
            }

        } catch (SQLException ea) {
            throw new RuntimeException(ea);
        } catch (IOException ea) {
            throw new RuntimeException(ea);
        }
    }

    @Override
    public void caretUpdate(CaretEvent e) {

        if (e.getSource() == test_text_input_field) {
            //check where the word ends
            if (e.getMark() == e.getDot()) {

                Highlighter hl = test_text_input_field.getHighlighter();
                hl.removeAllHighlights();

                //get the tekst split into array put into arraylist count and add to arraylist serpartely charecters
                String pattern = type_tekst;
                String str[] = pattern.split(" ");
                ArrayList<String> al = new ArrayList<String>();

                for (int i = 0; i < str.length; i++) {
                    al.add(str[i]);
                }

                for (String s : al) {
                    //the charcters one by one
                    String text = test_text_input_field.getText();
                    int index = text.indexOf(s);
                    //loop and check if tekst match then paint
                    while (index >= 0) {
                        try {
                            Object o = hl.addHighlight(index, index + s.length(), DefaultHighlighter.DefaultPainter);
                            index = text.indexOf(s, index + s.length());
                        } catch (BadLocationException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public int count(){
        //cout the charecters of the tekst.
        //https://www.speedtypingonline.com/typing-equations
        int counter = 0;
        String pattern = type_tekst;
        String str[] = pattern.split(" ");
        ArrayList<String> al = new ArrayList<String>();

        for (int i = 0; i < str.length; i++) {
            al.add(str[i]);
        }

        for (String s : al) {
            //the charcters one by one
            String text = test_text_input_field.getText();
            int index = text.indexOf(s);
            while (index >= 0) {
                index = text.indexOf(s, index + s.length());
                counter++;
            }
        }

        return counter/5;
    }
}
