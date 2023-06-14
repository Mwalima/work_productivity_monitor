package org.monitor;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {

    private final ImageIcon icon = new ImageIcon("./resources/images/logo_small.png");

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
        Image image = icon.getImage();

        form.setIconImage(image);
        form.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //form.setSize(1680,1680);
        form.setExtendedState(JFrame.MAXIMIZED_BOTH);
        form.setTitle("Provincie Zuid-Holland Werk Monitor scherm");
        form.setLocationRelativeTo(null);
        form.setIconImage(icon.getImage());
        form.getContentPane().add(getGui(panel));//set size of the frame
        form.setVisible(true);
        return form;
    }
}
