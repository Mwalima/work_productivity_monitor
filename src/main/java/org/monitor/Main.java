package org.monitor;

import org.monitor.model.DBTestConnection;
import org.monitor.view.StartView;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;


public class Main extends JFrame {
    private static StartView start;
    private static View view;
    private static final long serialVersionUID = 1L;

    public static void main(String[] args) throws IOException, SQLException {
        start = new StartView();
        view = new View();
        view.gameFrame(start.startPanel());
        DBTestConnection dbt = new DBTestConnection();
        dbt.runIfOpened();
    }
}