    package org.monitor;

    import javax.swing.*;
    import java.io.IOException;
    import java.sql.*;


    // Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
    // then press Enter. You can now see whitespace characters in your code.
    public class Main extends JFrame {
        public static void main(String[] args) {
            try
            {
                var view = new View();
                view.gameFrame(view.registrationPanel());
            }
            catch(Exception e)
            {
              //handle exception
             JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
