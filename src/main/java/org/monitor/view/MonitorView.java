package org.monitor.view;

import org.monitor.View;
import org.monitor.helper.CustomDialog;
import org.monitor.helper.Reminder;
import org.monitor.helper.Stopwatch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MonitorView extends JFrame implements ActionListener, MouseListener, KeyListener  {

    public int count = 0;
    private JLabel mousecounttextfield;
    private JButton exit_button,score_button;
    private JTextField keycount, mouseactionfield;
    private JTextArea mousecountText, keyboardcountText, test_text_input_field, test_textfield;
    private JPanel monitoringGridPanel, counterGridPanel,testGridPanel;
    private JScrollPane scrollPaneKey, scrollPaneMouse;
    JLabel timeLabel = new JLabel();

    private int elpapesdTime = 0;
    private int minutes = 0;
    private int seconds = 0;
    private int hours = 0;
    private int milliseconds = 0;
    private boolean started = false;
    private String milliseconds_string = String.format("%02d", milliseconds);
    private String seconds_string = String.format("%02d", seconds);
    private String minutes_string = String.format("%02d", minutes);
    private String hours_string = String.format("%02d", hours);
    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;

    static final String newline = System.getProperty("line.separator");

    public JPanel monitoringPanel() {
        /**
         * grid layout
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

        timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string + ":" + milliseconds_string);
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1,new Color(0,173,230),new Color(0,173,230)));
        timeLabel.setBackground(Color.WHITE);
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);

        //score panel
        score_button = new JButton("Score");
        score_button.setBounds(200, 200, 250, 150);
        score_button.setFont(new Font("Arial", Font.PLAIN, 20));
        score_button.setBorder(BorderFactory.createBevelBorder(1,new Color(0,173,230),new Color(0,173,230)));
        score_button.setFocusable(false);

        //exit button
        exit_button = new JButton("Exit");
        exit_button.setBounds(200, 200, 250, 150);
        exit_button.setFont(new Font("Arial", Font.PLAIN, 20));
        exit_button.setBorder(BorderFactory.createBevelBorder(1,new Color(0,173,230),new Color(0,173,230)));
        exit_button.setFocusable(false);

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
        mousecounttextfield = new JLabel();
        mousecounttextfield.setText("Mouse monitor");
        mousecounttextfield.setForeground(Color.BLACK);
        mousecounttextfield.setBounds(600, 450, 200, 20);
        mouseactionfield = new JTextField(15);
        mouseactionfield.setBounds(400, 500, 200, 28);

        keyboardcountText.setEditable(false);
        scrollPaneKey = new JScrollPane(keyboardcountText);
        scrollPaneKey.setPreferredSize(new Dimension(100, 300));

        //test tekst area
        test_textfield = new JTextArea("De test gaat om het zo snel en foutloos na typen van de tekst.\n\n" + "Veel vlaggen, liederen waarin Catalonië en Spanje („puta, puta”)" + "de hoofdrol spelen en meer dan genoeg bier om de warmte te trotseren. " + "De fans van Barcelona hebben aan het begin van de zaterdagmiddag hun stek " + "in het centrum van Eindhoven wel gevonden: voor de deur van " + "het hotel waarvandaan het team straks naar het Philips-stadion vertrekt. " + "Af en toe moeten de honderden supporters even inschikken om de stadsbus van lijn elf te laten passeren." + "" + "„Een mooi feest”, zeggen Mirreia en Marcos uit Barcelona. Ze volgen de favoriet " + "voor de finale van de Champions League al jaren. " + "Op het mannenvoetbal is het stel een beetje uitgekeken. „In de vrouwencompetitie kan " + "je voor 20 euro een kaartje krijgen, bij de mannen " + "is dat zeker het dubbele”, zegt Marcos. „En nooit zijn er problemen, dat telt voor ons ook.”" + "Vorig jaar was het stel nog in Turijn, waar Barcelona de beker aan Olympique Lyonnais moest laten." + "Tegen VFL Wolfsburg hopen ze op meer succes. „Maar dit is sowieso een mooie dag”, zegt Mirreia, „bij de vrouwen " + "zien we veel meer voetbal en minder agressie en theater op het veld”.");
        test_textfield.setWrapStyleWord(true);
        test_textfield.setColumns(10);
        test_textfield.setRows(5);
        test_textfield.setLineWrap(true);
        test_textfield.setWrapStyleWord(true);
        test_textfield.setFont(new Font("Arial", Font.BOLD, 18));
        test_textfield.setEditable(false);
        test_textfield.setBounds(400, 700, 200, 100);
        JScrollPane scrollPane_test = new JScrollPane(test_textfield);
        scrollPane_test.setPreferredSize(new Dimension(100, 200));

        test_text_input_field = new JTextArea();
        test_text_input_field.setWrapStyleWord(true);
        test_text_input_field.setBounds(400, 900, 200, 100);
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
            //natural height, maximum width
            c.fill = GridBagConstraints.HORIZONTAL;
        }

        c.fill = GridBagConstraints.PAGE_START;
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(0,0,10,0);
        monitoringBorderPanel.add(welkomeText,c);

        //add the timer on beneath and left
        c.fill = GridBagConstraints.BOTH;;
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.insets = new Insets(10,0,0,0);
        monitoringBorderPanel.add(timeLabel,c);

        //add the scorefield on beneath of the title and center
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.insets = new Insets(10,10,0,0);
        monitoringBorderPanel.add(score_button,c);

       //add the exit_button on beneath of the title and right
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 2;
        c.gridy = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.insets = new Insets(10,10,0,0);
        monitoringBorderPanel.add(exit_button,c);

        //add the scrollPaneMouse on beneath of the button row
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 3;
        c.weightx = 1.0;
        c.weighty = 1.0;
        monitoringBorderPanel.add(scrollPaneMouse,c);

        //add the exit_button on beneath of the title and right
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 2;
        c.gridy = 3;
        c.weightx = 1.0;
        c.weighty = 1.0;
        monitoringBorderPanel.add(scrollPaneKey,c);

        //add the mouseactionfield on beneath of the title and right
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 4;
        c.weightx = 1.0;
        c.weighty = 1.0;
        monitoringBorderPanel.add(mouseactionfield,c);

        //add the keycount on beneath of the title and right
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 4;
        c.weightx = 1.0;
        c.weighty = 1.0;
        monitoringBorderPanel.add(keycount,c);

        //add the keycount on beneath of the title and right
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 3;
        c.weightx = 1.0;
        c.weighty = 1.0;
        monitoringBorderPanel.add(scrollPane_test,c);

        //add the keycount on beneath of the title and right
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 6;
        c.gridwidth = 3;
        c.weightx = 1.0;
        c.weighty = 1.0;
        monitoringBorderPanel.add(scrollPaneInput,c);

        //listners
        test_text_input_field.addMouseListener(this);
        test_text_input_field.addKeyListener(this);

        mouseactionfield.addMouseListener(this);
        keyboardcountText.addKeyListener(this);
        mousecountText.addMouseListener(this);
        keycount.addKeyListener(this);
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
        if(e.getSource() == test_text_input_field ){
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

        Stopwatch st = new Stopwatch();
        st.start();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        displayMouseInfo("Mouse clicked; # of clicks: " + e.getClickCount());
        count++;
        mouseactionfield.setText("total mouse action:" + count);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        displayMouseInfo("Mouse pressed; # of clicks: " + e.getClickCount());
        count++;
        mouseactionfield.setText("total mouse action:" + count);

        if(e.getSource() == test_text_input_field ){
            start();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) {

        displayMouseInfo("Mouse moved" + e.getClickCount());
    }

    @Override
    public void mouseExited(MouseEvent e) {

        displayMouseInfo("Mouse exited" + e.getClickCount());
        if(e.getSource() == test_text_input_field ){
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
            milliseconds = (elpapesdTime);
            if (milliseconds > 99) {
                milliseconds = 0;
            }
            hours_string = String.format("%02d", hours);
            minutes_string = String.format("%02d", minutes);
            seconds_string = String.format("%02d", seconds);
            milliseconds_string = String.format("%02d", milliseconds);

            timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string + ":" + milliseconds_string);
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
        //test_text_input_field.setText("");
        keyboardcountText.setText("");

        if (e.getSource() == exit_button) {
            Reminder rem = new Reminder(1);
            var test = new JFrame();
            test.setVisible(false);
            test.dispose();

            CustomDialog dialog = new CustomDialog(view.gameFrame(this.monitoringPanel()), "De applicatie sluit over 3 seconden");
            dialog.setVisible(true);
        }

    }
}
