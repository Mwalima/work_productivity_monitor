package org.monitor.model;

import org.monitor.Main;

import javax.swing.*;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * For more information go to https://mvnrepository.com/artifact/com.microsoft.sqlserver/mssql-jdbc/12.2.0.jre11
 */
public class Score extends JFrame {
    public Connection connection;
    public PreparedStatement stment;

    private int keystrokes,mousemovements,errors,testscore;

    private Date elapsedTime, createdAt;
    private Statement statement;

    public int getKeystrokes() {
        return keystrokes;
    }

    public void setKeystrokes(int keystrokes) {
        this.keystrokes = keystrokes;
    }

    public int getMousemovements() {
        return mousemovements;
    }

    public void setMousemovements(int mousemovements) {
        this.mousemovements = mousemovements;
    }

    public int getErrors() {
        return errors;
    }

    public void setErrors(int errors) {
        this.errors = errors;
    }

    public int getTestscore() {
        return testscore;
    }

    public void setTestscore(int testscore) {
        this.testscore = testscore;
    }

    public Date getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(Date elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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

    public Integer insertScore() throws SQLException, IOException {
        //create the connection to the db
        Properties properties = new Properties();
        properties.load(Main.class.getClassLoader().getResourceAsStream("application.properties"));
        connection = DriverManager.getConnection(properties.getProperty("url"), properties);

        stment = connection.prepareStatement("INSERT INTO [dbo].[score]([keystrokes],[mousemovements],[errors],[testscore],[elapsedTime],[createdAt])VALUES(?,?,?,?,?);");

        stment.setInt(1, this.getKeystrokes());
        stment.setInt(2, this.getMousemovements());
        stment.setInt(3, this.getErrors());
        stment.setInt(4, this.getTestscore());
        stment.setDate(5, this.getElapsedTime());
        stment.setDate(6, this.getCreatedAt());
        int rowsAffected = stment.executeUpdate();
        return rowsAffected;
    }
}