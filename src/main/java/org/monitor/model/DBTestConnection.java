package org.monitor.model;

import org.monitor.Main;

import javax.swing.*;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;


public class DBTestConnection {

    public void runIfOpened()  {
        Properties properties = new Properties();
        Connection connection = null;
        try {
            properties.load(Main.class.getClassLoader().getResourceAsStream("application.properties"));
            connection = DriverManager.getConnection(properties.getProperty("url"), properties);
            connection.getMetaData();

        } catch (SQLException e) {
            int result = JOptionPane.showConfirmDialog(null, "Database is niet bereikbaar, stuur een email naar de admin: m.peltenburg@gmail.com", "Confirm Exit",
                    JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION)
                System.exit(0);
            throw new RuntimeException(e);
        } catch (IOException e) {
            int result = JOptionPane.showConfirmDialog(null, "er is geen internet verbinding", "Confirm Exit",
                    JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION)
                System.exit(0);
            throw new RuntimeException(e);
        }
    }

    public void runIfValid()throws SQLException, IOException
    {
        Properties properties = new Properties();
        properties.load(Main.class.getClassLoader().getResourceAsStream("application.properties"));
        Connection connection = DriverManager.getConnection(properties.getProperty("url"), properties);
        if (connection.isValid(2)) {
            connection.getMetaData();
        }
        else {
            int result = JOptionPane.showConfirmDialog(null, "Database is niet bereikbaar, stuur een email naar de admin: m.peltenburg@gmail.com", "Confirm Exit",
                    JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION)
                System.exit(0);
        }
    }
    public void connectedTest() {
        Properties properties = new Properties();
        Connection connection = null;
        String sql = "select * from INFORMATION_SCHEMA.TABLES";
        Statement statement = null;
        ResultSet result = null;        System.out.println(result+" records affected");

        try {
            properties.load(Main.class.getClassLoader().getResourceAsStream("application.properties"));
            connection = DriverManager.getConnection(properties.getProperty("url"), properties);
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

