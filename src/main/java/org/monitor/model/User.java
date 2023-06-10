package org.monitor.model;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import org.monitor.Main;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * For more information go to https://mvnrepository.com/artifact/com.microsoft.sqlserver/mssql-jdbc/12.2.0.jre11
 */
public class User extends JFrame {
    public Connection connection;
    public PreparedStatement stment;
    private Integer phonenumber;
    private String firstname, lastname, streetname, postalcode, cityname, country, emailadress, housenumber;
    private String password;
    private boolean registred = true;
    private Statement statement;

    public User() {
        //            Dotenv dotenv = Dotenv.load();
        //            dotenv.get("AZ_RESOURCE_GROUP");
    }

    public User(Integer phonenumber, String housenumber, String firstname, String lastname, String streetname, String postalcode, String cityname, String country, String password, boolean registred) throws HeadlessException {
        this.phonenumber = phonenumber;
        this.housenumber = housenumber;
        this.firstname = firstname;
        this.lastname = lastname;
        this.streetname = streetname;
        this.postalcode = postalcode;
        this.cityname = cityname;
        this.country = country;
        this.password = password;
        this.registred = registred;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getStreetname() {
        return streetname;
    }

    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getHousenumber() {
        return housenumber;
    }

    public void setHousenumber(String housenumber) {
        this.housenumber = housenumber;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(Integer phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmailadress() {
        return emailadress;
    }

    public void setEmailadress(String emailadress) {
        this.emailadress = emailadress;
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


    /**
     * @throws SQLException
     * @throws IOException
     */
    public Integer getLatesdId() throws SQLException, IOException {
        //log.info("get id");
        //create the connection to the db
        Properties properties = new Properties();
        properties.load(Main.class.getClassLoader().getResourceAsStream("application.properties"));
        connection = DriverManager.getConnection(properties.getProperty("url"), properties);

        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select max(id) from [dbo].[users]");

        resultSet.next();
        int myMaxId = resultSet.getInt(1);
        System.out.println(myMaxId);
        return myMaxId;
    }

    public Integer insertUser() throws SQLException, IOException {
        //create the connection to the db
        Properties properties = new Properties();
        properties.load(Main.class.getClassLoader().getResourceAsStream("application.properties"));
        connection = DriverManager.getConnection(properties.getProperty("url"), properties);

        stment = connection.prepareStatement("INSERT INTO [dbo].[users]([firstname],[lastname],[streetname],[postalcode],[housenumber],[city],[country],[phonenumber],[emailadress],[password],[registred]) VALUES (?,?,?,?,?,?,?,?,?,?,?);");
        //stment.setInt(1, this.getLatesdId());
        stment.setString(1, this.getFirstname());
        stment.setString(2, this.getLastname());
        stment.setString(3, this.getStreetname());
        stment.setString(4, this.getPostalcode());
        stment.setString(5, this.getHousenumber());
        stment.setString(6, this.getCityname());
        stment.setString(7, this.getCountry());
        stment.setInt(8, this.getPhonenumber());
        stment.setString(9, this.getEmailadress());
        stment.setString(10, this.getPassword());
        stment.setBoolean(11, this.isRegistred());
        int rowsAffected = stment.executeUpdate();
        return rowsAffected;
    }

    /**
     * @param email
     * @return
     * @throws SQLException
     * @throws IOException  check if user is already registred
     */

    public Integer getUserData() throws SQLException, IOException {
        Properties properties = new Properties();
        properties.load(Main.class.getClassLoader().getResourceAsStream("application.properties"));

        String emailValue = this.getEmailadress();
        String passwordValue = this.getPassword();

        System.out.println(emailValue);
        System.out.println(passwordValue);

        int rowsAffected=0;

        connection = DriverManager.getConnection(properties.getProperty("url"), properties);

        try (PreparedStatement pstatement = connection.prepareStatement("SELECT * FROM [dbo].[users] WHERE [emailadress] LIKE ? AND [password] LIKE ?")) {
            // WHERE [emailadress] LIKE '%leitje%' AND [password] LIKE '%1234%'

            pstatement.setString(1, "%" + emailValue + "%");
            pstatement.setString(2, "%" + passwordValue + "%");
            ResultSet resultSet = pstatement.executeQuery();

            while (resultSet.next()) {
                rowsAffected = 1;
                return rowsAffected;
            }
        } catch (SQLServerException se) {
            do {
                System.out.println("SQL STATE: " + se.getSQLState());
                System.out.println("ERROR CODE: " + se.getErrorCode());
                System.out.println("MESSAGE: " + se.getMessage());
                System.out.println();
            } while (se != null);
        }
        return rowsAffected;
    }
}

