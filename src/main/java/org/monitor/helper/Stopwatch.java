package org.monitor.helper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stopwatch implements ActionListener {


    JButton startButton = new JButton("start");
    JButton resetButton = new JButton("reset");
    JButton stopButton = new JButton("Stop");
    JLabel timeLabel = new JLabel();

    private JLabel seclbl, minlbl, hrslbl, time_elapsed_label;
    private int elpapesdTime = 0;
    private int minutes = 0;
    private int seconds = 0;
    private int hours = 0;
    private int milliseconds = 0;
    private boolean started = false;
    private String milliseconds_string = String.format("%02d", milliseconds);
    private String seconds_string = String.format("%02d", seconds);
    private String minutes_string = String.format("%02d", minutes);
    private String hours_string = String.format("%02d", hours);

    Timer timer = new Timer(10, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            elpapesdTime += 1000;
            hours = (elpapesdTime / 3600000);
            minutes = (elpapesdTime / 60000) % 60;
            seconds = (elpapesdTime / 1000) % 60;
            milliseconds = (elpapesdTime);
            if (milliseconds > 99) {
                milliseconds = 0;
            }
            hours_string = String.format("%02d", hours);
            minutes_string = String.format("%02d", minutes);
            seconds_string = String.format("%02d", seconds);
            milliseconds_string = String.format("%02d", milliseconds);

            timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string + ":" + milliseconds_string);
        }
    });

    public void run() {

        timer.start();
    }

    public JPanel timer() {
        JPanel stopwatchPanel = new JPanel();
        stopwatchPanel.setBounds(100, 100, 100, 100);

        timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string + ":" + milliseconds_string);
        timeLabel.setBounds(100, 100, 200, 100);
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 35));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);

        seclbl = new JLabel();
        minlbl = new JLabel();
        hrslbl = new JLabel();
        time_elapsed_label = new JLabel("Time elapsed");
        time_elapsed_label.setBounds(400, 400, 200, 100);

        startButton = new JButton("Start");
        startButton.setBounds(100, 200, 100, 50);
        startButton.setFont(new Font("Arial", Font.PLAIN, 20));
        startButton.setFocusable(false);

        stopButton = new JButton("Stop");
        stopButton.setBounds(200, 200, 100, 50);
        stopButton.setFont(new Font("Arial", Font.PLAIN, 20));
        stopButton.setFocusable(false);

        stopwatchPanel.add(startButton);
        stopwatchPanel.add(stopButton);

        stopwatchPanel.add(timeLabel);
        stopwatchPanel.add(time_elapsed_label);

        startButton.addActionListener(this);
        stopButton.addActionListener(this);

        return stopwatchPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            start();
        }
        if (e.getSource() == stopButton) {
            stop();
        }
    }

    public void start() {

        timer.start();
    }

    public void stop() {

        timer.stop();
    }
}
