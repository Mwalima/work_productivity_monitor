package org.monitor.helper;

import javax.swing.*;
import java.awt.*;

public class CustomDialog extends JDialog {

    private final ImageIcon icon = new ImageIcon("./resources/images/logo_small.png");

    public CustomDialog(JFrame parent, String message) {
        super(parent, "Applicatie afsluiten", true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel label = new JLabel(message);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label, BorderLayout.CENTER);

        setPreferredSize(new Dimension(400, 400));
        setIconImage(icon.getImage());
        pack();
        setLocationRelativeTo(parent);
    }
}
