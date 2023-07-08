package org.monitor.model;
import org.monitor.Main;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.*;
import java.util.Properties;

import static java.lang.Integer.parseInt;

/**
 * The type Score.
 */
public class Score extends JFrame {    

    private static final long serialVersionUID = 1L;
    
    private int userId, keystrokes, mousemovements;
    private double testscore; 
    private Time elapsedTime;

    private void writeObject(ObjectOutputStream stream)
        throws IOException {
    stream.defaultWriteObject();
}

private void readObject(ObjectInputStream stream)
        throws IOException, ClassNotFoundException {
    stream.defaultReadObject();
}
    /**
     * Gets user id.
     *
     * @return the user id
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets user id.
     *
     * @param userId the user id
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Gets keystrokes.
     *
     * @return the keystrokes
     */
    public int getKeystrokes() {
        return keystrokes;
    }

    /**
     * Sets keystrokes.
     *
     * @param keystrokes the keystrokes
     */
    public void setKeystrokes(int keystrokes) {
        this.keystrokes = keystrokes;
    }

    /**
     * Gets mousemovements.
     *
     * @return the mousemovements
     */
    public int getMousemovements() {
        return mousemovements;
    }

    /**
     * Sets mousemovements.
     *
     * @param mousemovements the mousemovements
     */
    public void setMousemovements(int mousemovements) {
        this.mousemovements = mousemovements;
    }

    /**
     * Gets testscore.
     *
     * @return the testscore
     */
    public double getTestscore() {
        return testscore;
    }

    /**
     * Sets testscore.
     *
     * @param testscore the testscore
     */
    public void setTestscore(double testscore) {
        this.testscore = testscore;
    }

    /**
     * Gets elapsed time.
     *
     * @return the elapsed time
     */
    public Time getElapsedTime() {
        return elapsedTime;
    }

    /**
     * Sets elapsed time.
     *
     * @param elapsedTime the elapsed time
     */
    public void setElapsedTime(Time elapsedTime) {
        this.elapsedTime = elapsedTime;
    }


    /**
     * Insert score integer.
     *
     * @param uID         the u id
     * @param keystrokes  the keystrokes
     * @param mouseclicks the mouseclicks
     * @param score       the score
     * @param elapsedTime the elapsed time
     * @return the integer
     * @throws SQLException the sql exception
     * @throws IOException  the io exception
     */
    public Integer insertScore(String uID, int keystrokes, int mouseclicks, double score, Time elapsedTime) throws SQLException, IOException {

        //convert sting to int
        userId = parseInt(uID);
        setUserId(userId);
        setKeystrokes(keystrokes);
        setMousemovements(mouseclicks);
        setTestscore(score);
        setElapsedTime(elapsedTime);

        Properties properties = new Properties();
        properties.load(Main.class.getClassLoader().getResourceAsStream("application.properties"));
        Connection connection = DriverManager.getConnection(properties.getProperty("url"), properties);
          
        PreparedStatement stment = connection.prepareStatement("INSERT INTO [dbo].[scores]([userId],[keystrokes],[mouseclicks],[score],[elapsedTime],[createdAt])VALUES(?,?,?,?,?,?);");

        stment.setInt(1, this.getUserId());
        stment.setInt(2, this.getKeystrokes());
        stment.setInt(3, this.getMousemovements());
        stment.setDouble(4, this.getTestscore());
        stment.setTime(5, this.getElapsedTime());
        stment.setTimestamp(6, new Timestamp(System.currentTimeMillis()));

        int rowsAffected = stment.executeUpdate();
        return rowsAffected;
    }
}