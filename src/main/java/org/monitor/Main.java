    package org.monitor;

    import org.monitor.view.StartView;
    import javax.swing.*;

    public class Main extends JFrame {

        public static void main(String[] args) {

            try
            {
                var start = new StartView();
                var view = new View();
                view.gameFrame(start.startPanel());
            }
            catch(Exception e)
            {
              //handle exception
             JOptionPane.showMessageDialog(null, e.getMessage());
            }

        }
    }