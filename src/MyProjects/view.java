package MyProjects;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        this.setVisible(true);
    }
    public  void loadData()
    {
        try
        {
            st = connection.createStatement();
            DefaultTableModel tableModel = new DefaultTableModel(new String[] {"Id","Roll no","Name","Address","Gender","Phone","Email"},0);
            JTable table = new JTable();
            JScrollPane JSP = new JScrollPane(table);
            JButton tableBtn= new JButton("Back");

            JPanel panel =new JPanel(new BorderLayout());
            panel.add(JSP,BorderLayout.CENTER);
            panel.add(tableBtn,BorderLayout.SOUTH);
            add(panel);

            String sql = "SELECT * FROM students_data";
            ResultSet resultSet = st.executeQuery(sql);

            String id, rollno, name,address, gender, phone, email;
            while (resultSet.next())
            {
                id = resultSet.getString("Std Id");
                rollno = resultSet.getString("Roll No");
                name = resultSet.getString("Full Name");
                address = resultSet.getString("Address");
                gender = resultSet.getString("Gender");
                phone = resultSet.getString("Phone");
                email = resultSet.getString("Email");

                tableModel.addRow(new Object[]{id,rollno,name,address,gender,phone,email});
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
