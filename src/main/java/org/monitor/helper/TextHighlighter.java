package org.monitor.helper;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.awt.*;
import java.util.ArrayList;

public class TextHighlighter {

    String type_tekst = "De test gaat om het zo snel en foutloos na typen van de tekst. Veel vlaggen, liederen waarin Catalonië en Spanje ('puta, puta') de hoofdrol spelen en meer dan genoeg bier om de warmte te trotseren. De fans van Barcelona hebben aan het begin van de zaterdagmiddag hun stek in het centrum van Eindhoven wel gevonden: voor de deur van het hotel waarvandaan het team straks naar het Philips-stadion vertrekt. Af en toe moeten de honderden supporters even inschikken om de stadsbus van lijn elf te laten passeren. 'Een mooi feest', zeggen Mirreia en Marcos uit Barcelona. Ze volgen de favoriet voor de finale van de Champions League al jaren. Op het mannenvoetbal is het stel een beetje uitgekeken. In de vrouwencompetitie kan je voor 20 euro een kaartje krijgen, bij de mannen is dat zeker het dubbele, zegt Marcos. En nooit zijn er problemen, dat telt voor ons ook. Vorig jaar was het stel nog in Turijn, waar Barcelona de beker aan Olympique Lyonnais moest laten. Tegen VFL Wolfsburg hopen ze op meer succes. 'Maar dit is sowieso een mooie dag', zegt Mirreia, bij de vrouwen zien we veel meer voetbal en minder agressie en theater op het veld.";

    private void initGUI(){

        final JTextArea textArea = new JTextArea();

        textArea.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {

                if(e.getMark() == e.getDot()){

                    Highlighter hl = textArea.getHighlighter();
                    hl.removeAllHighlights();

                    String pattern = type_tekst;
                    String str[] = pattern.split(" ");
                    ArrayList<String> al = new ArrayList<String>();
                    for(int i =0; i < str.length; i++) {
                        al.add(str[i]);
                    }

                    for (String s : al) {

                        String text = textArea.getText();
                        int index = text.indexOf(s);

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
        });

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(300,200));

        JPanel content = new JPanel(new FlowLayout());
        content.add(scrollPane);

        JFrame frame = new JFrame("Demo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setContentPane(content);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    public static void main(String[] args) {

//        String pattern = "De test gaat om het zo snel en foutloos na typen van de tekst.";
//        String str[] = pattern.split(" ");
//        ArrayList<String> al = new ArrayList<String>();
//        for(int i =0; i < str.length; i++) {
//            al.add(str[i]);
//        }
//        for (String s : al) {
//            System.out.println(s);
//        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TextHighlighter().initGUI();
            }
        });
    }
}
