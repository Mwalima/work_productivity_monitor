package org.monitor.helper;

import javax.swing.*;
import java.awt.*;

public class CustomDialog extends JDialog {

    public CustomDialog(JFrame parent, String message) {
        super(parent, "Applicatie afsluiten", true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel label = new JLabel(message);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label, BorderLayout.CENTER);

        setPreferredSize(new Dimension(300, 200));
        pack();
        setLocationRelativeTo(parent);
    }
}
