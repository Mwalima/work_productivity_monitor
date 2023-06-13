package org.monitor.helper;

import java.util.TimerTask;
import java.util.Timer;


public class Reminder {
    Timer timer;

    public Reminder(int seconds) {
        timer = new Timer();
        timer.schedule(new RemindTask(), seconds * 3000);
    }

    public class RemindTask extends TimerTask {
        public void run() {
            timer.cancel(); //Terminate the timer thread
            System.exit(1);
        }
    }
}

