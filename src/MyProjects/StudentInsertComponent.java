package MyProjects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Logger;

public class StudentInsertComponent extends JFrame{
    JPanel JP;
    JLabel stdName, rollNo,stdAddress, gender, phoneNo, email,heading;
    JTextField rollNoTF, nameTF, addressTF, phoneTF,emailTF;
    JButton SubmitBtn, OperationBtn, displayBtn;
    JComboBox <String> JCB;

    String[] genders={"Male","Female"};

    Connection connection = database.connect();
    Statement st = null;

    void init()
    {
        this.setSize(400,550); //default value
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //Exit while clicking 'X' Button
        this.setLocationRelativeTo(null); //it set the window to middle
        this.setResizable(false);

    }


    StudentInsertComponent()
    {
        JP = new JPanel();
        JP.setSize(400,550);
        JP.setLayout(null);
        this.add(JP);


//        heading = new JLabel("INSERT STUDENTS");
//        heading.setFont(new Font("calibri", Font.BOLD,16));
//        heading.setBounds(20,20,100,35);
//        JP.add(heading);

        //student name
        stdName = new JLabel("Name: ");
        stdName.setFont(new Font("calibri", Font.BOLD,16));
        stdName.setBounds(20,20,100,35);
        JP.add(stdName);

        nameTF= new JTextField();
        nameTF.setBounds(120,20,240,30);
        nameTF.setBorder(BorderFactory.createEmptyBorder()); // Remove default border
        JP.add(nameTF);

        //roll text label and field
        rollNo = new JLabel("Roll No: ");
        rollNo.setFont(new Font("calibri", Font.BOLD,16));
        rollNo.setBounds(20,80,100,35);
        JP.add(rollNo);

        rollNoTF= new JTextField();
        rollNoTF.setBounds(120,80,240,30);
        rollNoTF.setBorder(BorderFactory.createEmptyBorder()); // Remove default border
        JP.add(rollNoTF);


        //address
        stdAddress = new JLabel("Address: ");
        stdAddress.setFont(new Font("calibri", Font.BOLD,16));
        stdAddress.setBounds(20,140,100,35);
        JP.add(stdAddress);

        addressTF= new JTextField();
        addressTF.setBounds(120,140,240,30);
        addressTF.setBorder(BorderFactory.createEmptyBorder()); // Remove default border
        JP.add(addressTF);


        //Gender
        gender = new JLabel("Gender: ");
        gender.setFont(new Font("calibri", Font.BOLD,16));
        gender.setBounds(20,200,100,35);
        JP.add(gender);

        JCB= new JComboBox<>(genders);
        JCB.setBounds(120,200,240,30);
        JCB.setBorder(BorderFactory.createEmptyBorder()); // Remove default border
        JP.add(JCB);

        //phone num
        phoneNo = new JLabel("Phone No: ");
        phoneNo.setFont(new Font("calibri", Font.BOLD,16));
        phoneNo.setBounds(20,260,100,35);
        JP.add(phoneNo);

        phoneTF= new JTextField();
        phoneTF.setBounds(120,260,240,30);
        phoneTF.setBorder(BorderFactory.createEmptyBorder()); // Remove default border
        JP.add(phoneTF);

        //email
        email = new JLabel("Email: ");
        email.setFont(new Font("calibri", Font.BOLD,16));
        email.setBounds(20,320,100,35);
        JP.add(email);

        emailTF= new JTextField();
        emailTF.setBounds(120,320,240,30);
        emailTF.setBorder(BorderFactory.createEmptyBorder()); // Remove default border
        JP.add(emailTF);


        //submit button
        SubmitBtn = new JButton("Submit");
        SubmitBtn.setBackground(Color.green);
        SubmitBtn.setBounds(20,380,160,40);
        SubmitBtn.setBorder(BorderFactory.createEmptyBorder()); // Remove default border
        SubmitBtn.setFocusPainted(false); // Disable focus painting for cleaner look
        JP.add(SubmitBtn);

        //operation button
        OperationBtn = new JButton("Operation");
        OperationBtn.setBackground(Color.PINK);
        OperationBtn.setBounds(200,380,160,40);
        OperationBtn.setBorder(BorderFactory.createEmptyBorder()); // Remove default border
        OperationBtn.setFocusPainted(false); // Disable focus painting for cleaner look
        JP.add(OperationBtn);

        //display button
        displayBtn = new JButton("Display");
        displayBtn.setBackground(Color.BLUE);
        displayBtn.setBounds(20,440,340,40);
        displayBtn.setBorder(BorderFactory.createEmptyBorder()); // Remove default border
        displayBtn.setFocusPainted(false); // Disable focus painting for cleaner look
        JP.add(displayBtn);

        //function for Submit Button

        SubmitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SubmitPerformed(e);
                System.out.println("Submit Button Clicked Successful");
            }
        });

        //function for Operation Button

        OperationBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//
                System.out.println("Operation Button Clicked Successful");
            }
        });
        //display button
        displayBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//
                dispose();
                view v = new view();
            }
        });
        this.setVisible(true);
    }
    //Submit button logic
    private void SubmitPerformed(ActionEvent e){
        String stdName, stdAdd,stdGen,stdEmail,stdPhone;
        int stdRoll;

        try {
            st = connection.createStatement();
            if (("".equals(rollNoTF.getText())) && ("".equals(nameTF.getText())) &&("".equals(addressTF.getText()))&&("".equals(phoneTF.getText())) && ("".equals(emailTF.getText())))
            {
                JOptionPane.showMessageDialog(new JFrame(),"Fill all the details!","Dialog",JOptionPane.ERROR_MESSAGE);
            }
            else {
                stdName =nameTF.getText();
                stdAdd =addressTF.getText();
                stdGen =(String) JCB.getSelectedItem();
                stdEmail =emailTF.getText();
                stdRoll =Integer.parseInt(rollNoTF.getText());
                stdPhone =phoneTF.getText();
                String SqlQuery = "INSERT INTO students_data(std_name,std_roll,std_address,std_gender,std_phone,std_email) VALUES ('"+stdName+"','"+stdRoll+"','"+stdAdd+"','"+stdGen+"','"+stdPhone+"','"+stdEmail+"')";
                st.executeUpdate(SqlQuery);
                JOptionPane.showMessageDialog(rootPane,"Successfully Registered","Dialog",JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog( rootPane, ex);
        }

    }

    private void ViewData(ActionEvent e)
    {

    }

}
