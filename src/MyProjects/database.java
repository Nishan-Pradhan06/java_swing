package MyProjects;

import java.sql.*;
import javax.swing.JOptionPane;
//import javax.swing.*;

public class database {
    final static String DB_URL = "jdbc:mysql://localhost:3306/MyProjects";
    final static String user = "root";
    final static String password = "";

    public static Connection connect() {
        try {
            Connection c = DriverManager.getConnection(DB_URL, user, password);
            System.out.println("🎉Database is connected Successfully..🎉");
            return c;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
            return null;
        }
    }
}