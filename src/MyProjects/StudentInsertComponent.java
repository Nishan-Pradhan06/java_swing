package MyProjects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentInsertComponent {
    JPanel JP;
    JLabel stdName, rollNo,stdAddress, gender, phoneNo, email,heading;
    JTextField rollNoTF, nameTF, addressTF, phoneTF,emailTF;
    JButton SubmitBtn, OperationBtn;
    JComboBox <String> JCB;

    String[] genders={"Male","Female"};

    StudentInsertComponent()
    {
        JP = new JPanel();
        JP.setSize(400,500);
        JP.setLayout(null);

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
        JP.add(nameTF);

        //roll text label and field
        rollNo = new JLabel("Roll No: ");
        rollNo.setFont(new Font("calibri", Font.BOLD,16));

        rollNo.setBounds(20,80,100,35);
        JP.add(rollNo);

        rollNoTF= new JTextField();
        rollNoTF.setBounds(120,80,240,30);
        JP.add(rollNoTF);


        //address
        stdAddress = new JLabel("Address: ");
        stdAddress.setFont(new Font("calibri", Font.BOLD,16));
        stdAddress.setBounds(20,140,100,35);
        JP.add(stdAddress);

        addressTF= new JTextField();
        addressTF.setBounds(120,140,240,30);
        JP.add(addressTF);


        //Gender
        gender = new JLabel("Gender: ");
        gender.setFont(new Font("calibri", Font.BOLD,16));
        gender.setBounds(20,200,100,35);
        JP.add(gender);

        JCB= new JComboBox<>(genders);
        JCB.setBounds(120,200,240,30);
        JP.add(JCB);

        //phone num
        phoneNo = new JLabel("Phone No: ");
        phoneNo.setFont(new Font("calibri", Font.BOLD,16));
        phoneNo.setBounds(20,260,100,35);
        JP.add(phoneNo);

        phoneTF= new JTextField();
        phoneTF.setBounds(120,260,240,30);
        JP.add(phoneTF);

        //email
        email = new JLabel("Email: ");
        email.setFont(new Font("calibri", Font.BOLD,16));
        email.setBounds(20,320,100,35);
        JP.add(email);

        emailTF= new JTextField();
        emailTF.setBounds(120,320,240,30);
        JP.add(emailTF);


        //submit button
        SubmitBtn = new JButton("Submit");
        SubmitBtn.setBackground(Color.green);
        SubmitBtn.setBounds(20,380,160,40);
        JP.add(SubmitBtn);

        //operation button
        OperationBtn = new JButton("Operation");
        OperationBtn.setBackground(Color.PINK);
        OperationBtn.setBounds(200,380,160,40);
        JP.add(OperationBtn);

        //function for Submit Button

        SubmitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                LoginPerformed(e);
                System.out.println("Submit Button Clicked Successful");
            }
        });

        //function for Operation Button

        OperationBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                LoginPerformed(e);
                System.out.println("Operation Button Clicked Successful");
            }
        });
    }
}