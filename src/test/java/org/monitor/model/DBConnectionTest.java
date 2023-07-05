package org.monitor.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.monitor.Main;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * The type Db connection test.
 */
class DBConnectionTest {

    @Test
    void shouldShowDatabaseConnection()throws IOException, SQLException{
        Properties properties = new Properties();
        properties.load(Main.class.getClassLoader().getResourceAsStream("application.properties"));
        Connection connection = DriverManager.getConnection(properties.getProperty("url"), properties);
        Assertions.assertTrue(true,connection.getCatalog());
    }

    /**
     * Should show database result.
     *
     * @throws IOException  the io exception
     * @throws SQLException the sql exception
     */
    @Test
    void shouldShowDatabaseResult()throws IOException, SQLException{
        Properties properties = new Properties();
        properties.load(Main.class.getClassLoader().getResourceAsStream("application.properties"));      ;
        Connection connection = DriverManager.getConnection(properties.getProperty("url"), properties);
        Statement statement = connection.createStatement();
        String result = "";

        ResultSet rs = statement.executeQuery("SELECT * FROM [dbo].[users]");
        while (rs.next()) {
            String firstname = rs.getString("firstname");
            String lastname = rs.getString("lastname");
            result = firstname + ", " + lastname;

            //System.out.println(firstname + ", " + lastname);
        }
        Assertions.assertEquals(1,result);
    }
}