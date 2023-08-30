package org.monitor.model;

import org.monitor.Main;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Logger;

public class DBConnection {

    private static final Logger log;

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%4$-7s] %5$s %n");
        log =Logger.getLogger(Main.class.getName());
    }

    DBConnection() throws IOException, SQLException {
        log.info("Loading application properties");
        Properties properties = new Properties();
        properties.load(Main.class.getClassLoader().getResourceAsStream("application.properties"));

        log.info("Connecting to the database");
        Connection connection = DriverManager.getConnection(properties.getProperty("url"), properties);
        log.info("Database connection test: " + connection.getCatalog());

        log.info("Create display results");
        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("./querys/select_all_users.sql"));
        Statement statement = connection.createStatement();

        while (scanner.hasNextLine()) {
            statement.execute(scanner.nextLine());
        }
        log.info("Closing database connection");
        connection.close();
    }
}
