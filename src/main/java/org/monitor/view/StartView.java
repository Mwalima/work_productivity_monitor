package org.monitor.view;

import org.monitor.View;
import org.monitor.model.DBTestConnection;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

/**
 * The type Start view.
 */
public class StartView extends JFrame {

    private static final long serialVersionUID = 1L;

    /**
     * The Registrate.
     */
    public RegistrationView registrate;

    /**
     * Instantiates a new Start view.
     */
    public StartView(){

        startPanel();
    }


    /**
     * Start panel j panel.
     *
     * @return the j panel
     */
    public JPanel startPanel() {
        //TODO make panel close after 5 sec
        JLabel welkomeText = new JLabel();
        String logintext = "<html><p>Welkom bij de Typ Vaardigheid Monitor</p></html>";
        welkomeText.setText(logintext);
        welkomeText.setFont(new Font("Arial", Font.BOLD, 42));
        welkomeText.setForeground(new Color(10, 0, 0));
        welkomeText.setBounds(600, 180, 900, 600);


        JButton begin = new JButton();
        begin.setText("start");
        begin.setBackground(new Color(0,173,230));
        begin.setBounds(900,600,150,50);
        begin.setFocusPainted(false);
        begin.setFont(new Font("Arial", Font.BOLD, 20));
        begin.setForeground(Color.WHITE);
        begin.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        begin.setOpaque(true);
        begin.addActionListener(e -> {
            registrate = new RegistrationView();
             if( e.getSource()==begin ) {
                 DBTestConnection dbt = new DBTestConnection();
                 dbt.runIfOpened();
                View view = new View();
                view.gameFrame(registrate.registrationPanel());
            }
        });

        JPanel sPanel = new JPanel();
        sPanel.setLayout(null);
        sPanel.add(welkomeText);
        sPanel.setBackground(new Color(255, 255, 255));
        sPanel.add(begin);
        add(sPanel, BorderLayout.CENTER);

        return sPanel;
    }
}
