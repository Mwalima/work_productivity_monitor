package org.monitor.model;

import org.monitor.Main;

import javax.swing.*;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import static java.lang.Integer.parseInt;

/**
 * For more information go to https://mvnrepository.com/artifact/com.microsoft.sqlserver/mssql-jdbc/12.2.0.jre11
 */
public class Score extends JFrame {
    public Connection connection;
    public PreparedStatement stment;
    private int userId, keystrokes, mousemovements, testscore;
    private Date createdAt;
    private Time elapsedTime;
    private Statement statement;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

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


    public int getTestscore() {
        return testscore;
    }

    public void setTestscore(int testscore) {
        this.testscore = testscore;
    }

    public Time getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(Time elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer insertScore(String uID, int keystrokes, int mouseclicks, int score, Time elapsedTime) throws SQLException, IOException {

        //convert sting to int
        userId = parseInt(uID);
        setUserId(userId);
        setKeystrokes(keystrokes);
        setMousemovements(mouseclicks);
        setTestscore(score);
        setElapsedTime(elapsedTime);

        Properties properties = new Properties();
        properties.load(Main.class.getClassLoader().getResourceAsStream("application.properties"));
        connection = DriverManager.getConnection(properties.getProperty("url"), properties);

        stment = connection.prepareStatement("INSERT INTO [dbo].[scores]([userId],[keystrokes],[mouseclicks],[score],[elapsedTime],[createdAt])VALUES(?,?,?,?,?,?);");

        stment.setInt(1, this.getUserId());
        stment.setInt(2, this.getKeystrokes());
        stment.setInt(3, this.getMousemovements());
        stment.setInt(4, this.getTestscore());
        stment.setTime(5, this.getElapsedTime());
        stment.setTimestamp(6, new Timestamp(System.currentTimeMillis()));

        int rowsAffected = stment.executeUpdate();
        return rowsAffected;
    }
}