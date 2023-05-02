    package org.monitor;

    import com.formdev.flatlaf.FlatLightLaf;

    import javax.swing.*;
    import java.io.IOException;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;
    import java.sql.Statement;
    import java.util.Properties;
    import java.util.Scanner;
    import java.util.logging.Logger;
    import io.github.cdimascio.dotenv.Dotenv;

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
            Dotenv dotenv = Dotenv.load();
//            dotenv.get("AZ_RESOURCE_GROUP");
            try
            {
                View view = new View();
                view.welkomeFrame();
            }
            catch(Exception e)
            {
                //handle exception
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

            log.info("Loading application properties");
            Properties properties = new Properties();
            properties.load(Monitor.class.getClassLoader().getResourceAsStream("application.properties"));

            log.info("Connecting to the database");
            Connection connection = DriverManager.getConnection(properties.getProperty("url"), properties);
            log.info("Database connection test: " + connection.getCatalog());

            log.info("Create display results");
            Scanner scanner = new Scanner(Monitor.class.getClassLoader().getResourceAsStream("./querys/select_all.sql"));
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
