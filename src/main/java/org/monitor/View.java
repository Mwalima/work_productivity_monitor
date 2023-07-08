package org.monitor;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {

    private static final long serialVersionUID = 1L;

    private Main form;
    /**
     *
     * @param panel
     * @return
     */
    public JComponent getGui(JPanel panel) {
        return panel;
    }

    public JFrame gameFrame(JPanel panel) {
        form = new Main();

        //TODO get icon working
        ImageIcon icon = new ImageIcon("/resources/images/logo.png");
        Image img = icon.getImage();

        form.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //form.setSize(1680,1680);
        form.setExtendedState(JFrame.MAXIMIZED_BOTH);
        form.setTitle("Provincie Zuid-Holland Werk Monitor scherm");
        form.setLocationRelativeTo(null);
        form.setIconImage(img);
        form.getContentPane().add(getGui(panel));//set size of the frame
        form.setVisible(true);
        return form;
    }
}
