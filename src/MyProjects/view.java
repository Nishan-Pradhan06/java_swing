package MyProjects;

import javax.swing.*;
import java.sql.Connection;
import java.sql.Statement;

public class view extends JFrame {
    Connection connection = database.connect();
    Statement st = null;

    public view()
    {
        this.setSize(800,600); //default value
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //Exit while clicking 'X' Button
        this.setLocationRelativeTo(null); //it set the window to middle
        this.setResizable(false);
    }



}
