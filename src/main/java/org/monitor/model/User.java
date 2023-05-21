package org.monitor.model;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import org.monitor.Main;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Logger;
import io.github.cdimascio.dotenv.Dotenv;
import org.monitor.View;

import javax.swing.*;

public class User extends JFrame {
        private static final Logger log = null;
        private Integer id;
        private String username;
        private String password;
        private boolean registred;
        public Connection connection;

        public PreparedStatement stment;

        public User(){
            //            Dotenv dotenv = Dotenv.load();
//            dotenv.get("AZ_RESOURCE_GROUP");

        }
        public User(Integer id, String username, String password, boolean registred) {
            this.id = id;
            this.username = username;
            this.password = password;
            this.registred = registred;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setDescription(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public boolean isRegistred() {
            return registred;
        }

        public void setRegistred(boolean registred) {
            this.registred = registred;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    ", registred=" + registred +
                    '}';
        }
        public void insertUser(User this) throws SQLException, IOException {
        log.info("Insert data");
        //create the connection to the db
        Properties properties = new Properties();
        properties.load(Main.class.getClassLoader().getResourceAsStream("application.properties"));
        connection = DriverManager.getConnection(properties.getProperty("url"), properties);

            stment = connection.prepareStatement("INSERT INTO [dbo].[users](id,username,password,registred) VALUES (?, ?, ?, ?);");
            stment.setInt(1, this.getId());
            stment.setString(2, this.getUsername());
            stment.setString(3, this.getPassword());
            stment.setBoolean(4, this.isRegistred());
            stment.executeUpdate();
    }

    /**
     *
     * @param email
     * @return
     * @throws SQLException
     * @throws IOException
     * check if user is already registred
     */

    public String getUserData(String email)throws SQLException,IOException {
        Properties properties = new Properties();
        properties.load(Main.class.getClassLoader().getResourceAsStream("application.properties"));
        String usernameValue = null;
        connection = DriverManager.getConnection(properties.getProperty("url"), properties);


        try (PreparedStatement pstatement = connection.prepareStatement("SELECT * FROM [dbo].[users] WHERE [username] LIKE ?");){

            pstatement.setString(1, "%" + email + "%");
            ResultSet resultSet = pstatement.executeQuery();

            while (resultSet.next()) {
                usernameValue = resultSet.getString("username");
                System.out.println(resultSet.getString("username") + " " + resultSet.getString("password"));
                //String passwordValue = resultSet.getString("password");
            }
        } catch (SQLServerException se) {
            do {
                System.out.println("SQL STATE: " + se.getSQLState());
                System.out.println("ERROR CODE: " + se.getErrorCode());
                System.out.println("MESSAGE: " + se.getMessage());
                System.out.println();
            }
            while (se != null);
            return null;
        }
        return usernameValue;
    }
}
