package MyProjects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class operation extends JFrame{
    JPanel JP;
    JLabel searchById, fullName, email, gender,stdAddress,phoneNo,rollNo;
    JTextField searchByIdTF, nameTF, emailTF,addressTF,phoneTF,rollNoTF;
    JComboBox <String> JCB;

    String[] genders={"Male","Female"};

    JButton updateBtn, deleteBtn, searchBtn,backBtn;
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

        searchBtn = new JButton("Search");
        searchBtn.setBackground(Color.GRAY);
        searchBtn.setBounds(250, 20, 110, 30);
        searchBtn.setBorder(BorderFactory.createEmptyBorder()); // Remove default border
        searchBtn.setFocusPainted(false); // Disable focus painting for cleaner look
       JP.add(searchBtn);

       //roll text label and field
       rollNo = new JLabel("Roll No: ");
       rollNo.setFont(new Font("calibri", Font.BOLD,16));
       rollNo.setBounds(20,80,100,35);
       JP.add(rollNo);

       rollNoTF= new JTextField();
       rollNoTF.setBounds(120,80,240,30);
       rollNoTF.setBorder(BorderFactory.createEmptyBorder()); // Remove default border
       JP.add(rollNoTF);

        //First name label and field
       fullName = new JLabel("First Name: ");
       fullName.setFont(new Font("calibri", Font.BOLD, 16));
       fullName.setBounds(20,140,100,35);
       JP.add(fullName);

       nameTF = new JTextField();
       nameTF.setBounds(120,140,240,30);
       nameTF.setBorder(BorderFactory.createEmptyBorder()); // Remove default border
       JP.add(nameTF);


       //address
       stdAddress = new JLabel("Address: ");
       stdAddress.setFont(new Font("calibri", Font.BOLD,16));
       stdAddress.setBounds(20,200,100,35);
       JP.add(stdAddress);

       addressTF= new JTextField();
       addressTF.setBounds(120,200,240,30);
       addressTF.setBorder(BorderFactory.createEmptyBorder()); // Remove default border
       JP.add(addressTF);


       //Gender
       gender = new JLabel("Gender: ");
       gender.setFont(new Font("calibri", Font.BOLD,16));
       gender.setBounds(20,260,100,35);
       JP.add(gender);

       JCB= new JComboBox<>(genders);
       JCB.setBounds(120,260,240,30);
       JCB.setBorder(BorderFactory.createEmptyBorder()); // Remove default border
       JP.add(JCB);

       //phone num
       phoneNo = new JLabel("Phone No: ");
       phoneNo.setFont(new Font("calibri", Font.BOLD,16));
       phoneNo.setBounds(20,320,100,35);
       JP.add(phoneNo);

       phoneTF= new JTextField();
       phoneTF.setBounds(120,320,240,30);
       phoneTF.setBorder(BorderFactory.createEmptyBorder()); // Remove default border
       JP.add(phoneTF);

       //email
       email = new JLabel("Email: ");
       email.setFont(new Font("calibri", Font.BOLD,16));
       email.setBounds(20,380,100,35);
       JP.add(email);

       emailTF= new JTextField();
       emailTF.setBounds(120,380,240,30);
       emailTF.setBorder(BorderFactory.createEmptyBorder()); // Remove default border
       JP.add(emailTF);

       //update button
       updateBtn = new JButton("Update");
       updateBtn.setBackground(Color.green);
       updateBtn.setBounds(20, 440, 100, 40);
       updateBtn.setBorder(BorderFactory.createEmptyBorder()); // Remove default border
       updateBtn.setFocusPainted(false); // Disable focus painting for cleaner look
       JP.add(updateBtn);

       //delete button
       deleteBtn = new JButton("Delete");
       deleteBtn.setBackground(Color.RED);
       deleteBtn.setBounds(140, 440, 100, 40);
       deleteBtn.setBorder(BorderFactory.createEmptyBorder()); // Remove default border
       deleteBtn.setFocusPainted(false); // Disable focus painting for cleaner look
       JP.add(deleteBtn);

       //back button
       backBtn = new JButton("Back");
       backBtn.setBackground(Color.GRAY);
       backBtn.setBounds(260, 440, 100, 40);
       backBtn.setBorder(BorderFactory.createEmptyBorder()); // Remove default border
       backBtn.setFocusPainted(false); // Disable focus painting for cleaner look
       JP.add(backBtn);

        //function for Submit Button
        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchPerformed();
            }
        });

        //update data btn
        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateData();
            }
        });

        //delete data button
       deleteBtn.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               deleteData();
           }
       });

        //back data btn
       backBtn.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               dispose();
               StudentInsertComponent SIC = new StudentInsertComponent();
               SIC.init();
           }
       });
    }

    //search logic performed
    void searchPerformed()
    {
        String id;
        int flag =0;
        try {
            st = connection.createStatement();
            id = searchByIdTF.getText();
            if ("".equals(id))
            {
                JOptionPane.showMessageDialog(new JFrame(),"Enter Id!","Dialog",JOptionPane.ERROR_MESSAGE);
            }
            else {
                String sql = "SELECT* FROM students_data WHERE std_id= " +id;
                ResultSet RS = st.executeQuery(sql);
                while(RS.next())
                {
//                    std_name,std_roll,std_address,std_gender,std_phone,std_email
                    nameTF.setText(RS.getString("std_name"));
                    emailTF.setText(RS.getString("std_email"));
                    addressTF.setText(RS.getString("std_address"));
                    phoneTF.setText(RS.getString("std_phone"));
                    rollNoTF.setText(RS.getString("std_roll"));
                    JCB.setSelectedItem(RS.getString("std_gender"));
                    flag =1;
                }
                if (flag==0)
                {
                    JOptionPane.showMessageDialog(new JFrame(),"Id not Found!","Dialog",JOptionPane.ERROR_MESSAGE);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    //update logic performed
    void updateData()
    {
        String id,name,address,gender,phone,email;
        int roll,flag =0;
        id =searchByIdTF.getText();
        try {
            st = connection.createStatement();
            String sql ="SELECT* FROM students_data WHERE std_id=?";
            PreparedStatement PS = connection.prepareStatement(sql);
            PS.setString(1,id);
            ResultSet RS = PS.executeQuery();
            while (RS.next()) {
                name = nameTF.getText();
                address = addressTF.getText();
                gender = (String) JCB.getSelectedItem();
                email = emailTF.getText();
                roll = Integer.parseInt(rollNoTF.getText());
                phone = phoneTF.getText();
                String SqlQuery = "UPDATE students_data set std_name='" + name + "',std_roll='" + roll + "',std_address='" + address + "',std_gender='" + gender + "',std_email='" + email + "',std_phone='" + phone + "' WHERE std_id='"+id+"'";
                st.executeUpdate(SqlQuery);
                JOptionPane.showMessageDialog(rootPane, "Data Updated.!", "Dialog", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    void deleteData()
    {
        String id;
        int flag =0;
        id =searchByIdTF.getText();
        try {
            st = connection.createStatement();
            String sql ="SELECT* FROM students_data WHERE std_id=?";
            PreparedStatement PS = connection.prepareStatement(sql);
            PS.setString(1,id);
            ResultSet RS = PS.executeQuery();
            while (RS.next()) {

                String SqlQuery = "DELETE FROM students_data WHERE std_id='"+id+"'";
                st.executeUpdate(SqlQuery);
                JOptionPane.showMessageDialog(rootPane, "Data Deleted.!", "Dialog", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}