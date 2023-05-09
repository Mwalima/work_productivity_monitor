    package org.monitor;

    import javax.swing.*;
    import java.io.IOException;
    import java.sql.*;


    // Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
    // then press Enter. You can now see whitespace characters in your code.
    public class Monitor extends JFrame {
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
             JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
