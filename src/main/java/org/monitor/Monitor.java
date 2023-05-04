    package org.monitor;

    import javax.swing.*;
    import java.io.IOException;
    import java.sql.*;

    import java.util.Properties;
    import java.util.logging.Logger;
    import io.github.cdimascio.dotenv.Dotenv;
    import org.monitor.model.User;

    // Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
    // then press Enter. You can now see whitespace characters in your code.
    public class Monitor extends JFrame {

        private static final Logger log;

        static {
            System.setProperty("java.util.logging.SimpleFormatter.format", "[%4$-7s] %5$s %n");
            log =Logger.getLogger(Monitor.class.getName());
        }
        //User user;
        public Monitor() {
            add(new Model());
        }

        public static void main(String[] args) throws SQLException, IOException {
            try
            {
                View view = new View();
                view.loginFrame();
            }
            catch(Exception e)
            {
                //handle exception
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
