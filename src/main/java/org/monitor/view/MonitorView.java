package org.monitor.view;

import org.monitor.View;
import org.monitor.helper.CustomDialog;
import org.monitor.helper.Reminder;
import org.monitor.helper.Stopwatch;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class MonitorView extends JFrame implements ActionListener, MouseListener, KeyListener,TextListener  {

    public int count = 0;
    private JLabel keyboardcount,mousecounttextfield,mousecount;
    private JButton exit_button;
    private JTextField keycount, mouseactionfield;
    private JTextArea mousecountText, keyboardcountText, test_text_input_field, test_textfield;
    private JPanel monitoringGridPanel, testGridPanel;
    private JScrollPane scrollPaneKey, scrollPaneMouse;
    private Border raisedbevel;

    static final String newline = System.getProperty("line.separator");

    public JPanel monitoringPanel() {
        JLabel welkomeText = new JLabel();
        String logintext = "<html><h1 style=\"color:white;font-size:25px;margin-left:200px;\n" + "  width: 100%;\n" + "  padding: 10px;\">Start de vaardigheidstest</h1></html>";
        welkomeText.setText(logintext);
        welkomeText.setFont(new Font("Arial", Font.BOLD, 20));
        welkomeText.setForeground(new Color(245, 239, 239));
        welkomeText.setBounds(200, 28, 450, 200);
        welkomeText.setHorizontalTextPosition(SwingConstants.RIGHT);

        exit_button = new JButton("Exit");
        exit_button.setBounds(200, 200, 100, 50);
        exit_button.setFont(new Font("Arial", Font.PLAIN, 20));
        exit_button.setFocusable(false);

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
        keyboardcount.setBounds(600, 150, 200, 20);

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

        JPanel monitoringBorderPanel = new JPanel();
        monitoringBorderPanel.setLayout(new BorderLayout());
        monitoringBorderPanel.add(welkomeText, BorderLayout.NORTH);
        monitoringBorderPanel.setBackground(new Color(255, 255, 255));

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

        monitoringGridPanel = new JPanel(new GridLayout(5, 2));
        //add test area to jframe
        testGridPanel = new JPanel(new GridLayout(2, 1));

        //instantiate the stopwatch class
        Stopwatch st = new Stopwatch();
        JPanel timer = st.timer();

        //mousescrollpane
        monitoringGridPanel.add(mousecount);
        monitoringGridPanel.add(keyboardcount);
        monitoringGridPanel.add(scrollPaneMouse);
        monitoringGridPanel.add(scrollPaneKey);
        monitoringGridPanel.add(mouseactionfield);
        monitoringGridPanel.add(keycount);
        monitoringGridPanel.add(timer);
        monitoringGridPanel.add(exit_button);

        //set border
        raisedbevel = BorderFactory.createMatteBorder(10, 30, 30, 30, new Color(255, 255, 255));
        monitoringBorderPanel.setBorder(raisedbevel);

        testGridPanel.add(scrollPane_test);
        testGridPanel.add(scrollPaneInput);

        monitoringBorderPanel.add(monitoringGridPanel, BorderLayout.CENTER);
        monitoringBorderPanel.add(testGridPanel, BorderLayout.SOUTH);

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
        mouseactionfield.setText("total mouse action:" + count);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        displayMouseInfo("Mouse pressed; # of clicks: " + e.getClickCount());
        count++;
        mouseactionfield.setText("total mouse action:" + count);
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

    public void textValueChanged(TextEvent e) {
        TextComponent tc = (TextComponent) e.getSource();
        System.out.println("Typed value in TextComponent " + tc.getText());
//        Stopwatch st = new Stopwatch();
//        st.start();
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
