package org.monitor.helper;

import java.util.TimerTask;
import java.util.Timer;


/**
 * The type Reminder.
 */
public class Reminder {
    /**
     * The Timer.
     */
    Timer timer;

    /**
     * Instantiates a new Reminder.
     *
     * @param seconds the seconds
     */
    public Reminder(int seconds) {
        timer = new Timer();
        timer.schedule(new RemindTask(), seconds * 3000);
    }

    /**
     * The type Remind task.
     */
    public class RemindTask extends TimerTask {
        public void run() {
            timer.cancel(); //Terminate the timer thread
            System.exit(1);
        }
    }
}

