/*
 * Created by JFormDesigner on Mon May 08 17:28:59 CEST 2023
 */

package org.monitor;

import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 * @author linuxpc
 */
public class Register extends JPanel {
    public Register() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Mwalima
        ResourceBundle bundle = ResourceBundle.getBundle("strings");
        label2 = new JLabel();
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        scrollPane2 = new JScrollPane();
        textArea2 = new JTextArea();
        textField2 = new JTextField();
        textField3 = new JTextField();

        //======== this ========
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .
        EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmDes\u0069gner \u0045valua\u0074ion" , javax. swing .border . TitledBorder. CENTER ,javax . swing
        . border .TitledBorder . BOTTOM, new java. awt .Font ( "D\u0069alog", java .awt . Font. BOLD ,12 ) ,
        java . awt. Color .red ) , getBorder () ) );  addPropertyChangeListener( new java. beans .PropertyChangeListener ( )
        { @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062order" .equals ( e. getPropertyName () ) )
        throw new RuntimeException( ) ;} } );
        setLayout(new GridLayout(4, 4, 10, 10));

        //---- label2 ----
        label2.setText(bundle.getString("Register.label2.text"));
        add(label2);

        //---- label1 ----
        label1.setText(bundle.getString("Register.label1.text"));
        add(label1);
        add(scrollPane1);

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(textArea2);
        }
        add(scrollPane2);
        add(textField2);
        add(textField3);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Mwalima
    private JLabel label2;
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JScrollPane scrollPane2;
    private JTextArea textArea2;
    private JTextField textField2;
    private JTextField textField3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
