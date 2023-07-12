package org.monitor.helper;

import javax.swing.*;
import java.awt.*;

/**
 * The type Custom dialog.
 */
public class CustomDialog extends JDialog {

    private static final long serialVersionUID = 1L;


    /**
     * Instantiates a new Custom dialog.
     *
     * @param parent  the parent
     * @param message the message
     */
    public CustomDialog(JFrame parent, String message) {
        super(parent, "Applicatie afsluiten", true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel label = new JLabel(message);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label, BorderLayout.CENTER);

        ImageIcon icon = new ImageIcon("./resources/images/logo.png");
        setIconImage(icon.getImage());

        setPreferredSize(new Dimension(600, 400));

        pack();
        setLocationRelativeTo(parent);
    }
}
