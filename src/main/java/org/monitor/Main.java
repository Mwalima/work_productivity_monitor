    package org.monitor;

    import org.monitor.view.StartView;
    import javax.swing.*;



    public class Main extends JFrame {
        private static StartView start;
        private static View view;

        public static void main(String[] args) {

            try
            {
               start = new StartView();
                View view = new View();
                view.gameFrame(start.startPanel());
            }
            catch(Exception e)
            {
              //handle exception
             JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }