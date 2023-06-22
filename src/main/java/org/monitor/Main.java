    package org.monitor;

    import org.monitor.view.StartView;

    import javax.swing.*;


    // Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
    // then press Enter. You can now see whitespace characters in your code.
    public class Main extends JFrame {

        public static void main(String[] args) {

            try
            {
                //var registration = new RegistrationView();
                var start = new StartView();
                var view = new View();
                //MonitorView monitor = new MonitorView();
                //view.gameFrame(monitor.monitoringPanel());
                view.gameFrame(start.startPanel());
            }
            catch(Exception e)
            {
              //handle exception
             JOptionPane.showMessageDialog(null, e.getMessage());
            }

        }
    }