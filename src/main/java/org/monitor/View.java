package org.monitor;

import javax.swing.*;

public class View extends JFrame {

    private final ImageIcon logo = new ImageIcon("./resources/images/logo_small.png");

    /**
     * guid of the start screen called loginframe
     *
     * @return
     */
    public JComponent getGui(JPanel panel) {
        return panel;
    }

    public JFrame gameFrame(JPanel panel) {
        Main form = new Main();
        form.setDefaultCloseOperation(EXIT_ON_CLOSE);
        form.setExtendedState(JFrame.MAXIMIZED_BOTH);
        form.setTitle("Provincie Zuid-Holland Werk Monitor scherm");
        form.setLocationRelativeTo(null);
        form.getContentPane().add(getGui(panel));//set size of the frame
        form.setIconImage(logo.getImage());
        form.setVisible(true);
        return form;
    }
}
