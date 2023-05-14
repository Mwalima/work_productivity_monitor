package org.monitor.model;

import org.monitor.Main;

import javax.management.monitor.Monitor;
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
        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("./querys/select_all.sql"));
        Statement statement = connection.createStatement();

        while (scanner.hasNextLine()) {
            statement.execute(scanner.nextLine());
        }

		/*
		Todo todo = new Todo(1L, "configuration", "congratulations, you have set up JDBC correctly!", true);
        insertData(todo, connection);
        todo = readData(connection);
        todo.setDetails("congratulations, you have updated data!");
        updateData(todo, connection);
        deleteData(todo, connection);
		*/
        log.info("Closing database connection");
        connection.close();
    }
}
