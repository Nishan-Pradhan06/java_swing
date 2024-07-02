package MyProjects;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class operation extends JFrame{
    JPanel JP;
    JLabel searchById, fName, Lname, email, Gender;
    JTextField searchByIdTF, fnameTF, lnameTF, emailTF;
    JButton updateBtn, deleteBtn, displayBtn;
    Connection connection = database.connect();
    Statement st = null;

     operation()
    {
        this.setTitle("Operation");
        this.setSize(400, 550); //default value
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //Exit while clicking 'X' Button
        this.setLocationRelativeTo(null); //it set the window to middle
        this.setResizable(false);
        this.setVisible(true);

    }

   void  init() {
        JP = new JPanel();
        JP.setSize(400, 550);
        JP.setLayout(null);
        add(JP);

        //student name
        searchById = new JLabel("Search By Id: ");
        searchById.setFont(new Font("calibri", Font.BOLD, 16));
        searchById.setBounds(20, 20, 100, 35);
        JP.add(searchById);

        searchByIdTF = new JTextField();
        searchByIdTF.setBounds(120, 20, 110, 30);
        searchByIdTF.setBorder(BorderFactory.createEmptyBorder()); // Remove default border
        JP.add(searchByIdTF);

       displayBtn = new JButton("Search");
       displayBtn.setBackground(Color.GRAY);
       displayBtn.setBounds(250, 20, 110, 30);
       displayBtn.setBorder(BorderFactory.createEmptyBorder()); // Remove default border
       displayBtn.setFocusPainted(false); // Disable focus painting for cleaner look
       JP.add(displayBtn);

        //First name label and field
        fName = new JLabel("First Name: ");
        fName.setFont(new Font("calibri", Font.BOLD, 16));
        fName.setBounds(20,140,100,35);
        JP.add(fName);

        fnameTF = new JTextField();
        fnameTF.setBounds(120, 80, 240, 30);
        fnameTF.setBorder(BorderFactory.createEmptyBorder()); // Remove default border
        JP.add(fnameTF);

       //Last Name label and field
       fName = new JLabel("Last Name: ");
       fName.setFont(new Font("calibri", Font.BOLD, 16));
       fName.setBounds(20,140,100,35);
       JP.add(fName);

       fnameTF = new JTextField();
       fnameTF.setBounds(120,140,240,30);
       fnameTF.setBorder(BorderFactory.createEmptyBorder()); // Remove default border
       JP.add(fnameTF);


        displayBtn = new JButton("Display");
        displayBtn.setBackground(Color.BLUE);
        displayBtn.setBounds(20, 440, 340, 40);
        displayBtn.setBorder(BorderFactory.createEmptyBorder()); // Remove default border
        displayBtn.setFocusPainted(false); // Disable focus painting for cleaner look
        JP.add(displayBtn);

        //function for Submit Button


    }
}