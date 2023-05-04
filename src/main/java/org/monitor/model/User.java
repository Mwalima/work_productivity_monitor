package org.monitor.model;

import org.monitor.Monitor;
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

        public PreparedStatement preparedStatement;

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
        properties.load(Monitor.class.getClassLoader().getResourceAsStream("application.properties"));
        connection = DriverManager.getConnection(properties.getProperty("url"), properties);

        preparedStatement = connection.prepareStatement("INSERT INTO [dbo].[users](id,username,password,registred) VALUES (?, ?, ?, ?);");
        preparedStatement.setInt(1, this.getId());
        preparedStatement.setString(2, this.getUsername());
        preparedStatement.setString(3, this.getPassword());
        preparedStatement.setBoolean(4, this.isRegistred());
        preparedStatement.executeUpdate();
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
        properties.load(Monitor.class.getClassLoader().getResourceAsStream("application.properties"));
        connection = DriverManager.getConnection(properties.getProperty("url"), properties);

        preparedStatement = connection.prepareStatement("SELECT * FROM [dbo].[users] WHERE [username] LIKE ?");
        preparedStatement.setString(1, "%" + email + "%");
        ResultSet resultSet = preparedStatement.executeQuery();

        String usernameValue = " ";


        /*
        TODO Create good redirect if user add wrong credentials
         */
        if (!resultSet.isBeforeFirst()) {
            System.out.println("No data");
            View view = new View();
            view.wrongCredentialsFrame();


        } else {
            while (resultSet.next()) {
                usernameValue = resultSet.getString("username");
                //String passwordValue = resultSet.getString("password");
            }
            return usernameValue;
       }
       return usernameValue;
    }

}
