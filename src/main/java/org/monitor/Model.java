package org.monitor;

import org.monitor.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.SQLException;

public class Model extends JPanel implements ActionListener {

    public Model() {
        monitor();
    }

    public void monitor() {
        addKeyListener(new TAdapter());
        setFocusable(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


    static class TAdapter implements KeyListener {
        private boolean monitoring;

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if (monitoring) {
                key += 1;
            }
        }
        @Override
        public void keyReleased(KeyEvent e) {
        }
    }
}

