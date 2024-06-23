package MyProjects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class myLoginComponents {
    JPanel JP;
    JLabel uName, uPassword;
    JTextField TF;
    JPasswordField PF;
    JButton BTN;

    Connection c = database.connect();// it establishes connection
    Statement st = null;
    myLoginComponents()
    {
        //Login Design();
        JP = new JPanel();
        JP.setSize(400,300);
//        JP.setBackground(Color.GRAY);
        JP.setLayout(null);
        JP.setForeground(Color.red);


        //text for user name
        uName = new JLabel("User Name: ");//(text-field)
        uName.setFont(new Font("calibri",Font.BOLD,16));//(font-name, style, font-size)
        uName.setBounds(20,20,100,20);//(X-axis,y-axis,width,height)
        JP.add(uName);
        //text-field
        TF = new JTextField();
        TF.setBounds(120,20,240,30);
        JP.add(TF);

        //text for user name
        uPassword = new JLabel("Password: ");//(text-field)
        uPassword.setFont(new Font("calibri",Font.BOLD,16));//(font-name, style, font-size)
        uPassword.setBounds(20,120,100,20);//(X-axis,y-axis,width,height)
        JP.add(uPassword);

        //password field
        PF = new JPasswordField();
        PF.setBounds(120,120,240,30);
        JP.add(PF);


        //button
        BTN= new JButton("Login");
        BTN.setBackground(Color.GREEN);
        BTN.setBounds(135,200,100,40);
        JP.add(BTN);


        //function for button

        BTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginPerformed(e);
                System.out.println("DataBase Connection Successful");
            }
        });
    }
    //database connection function should be here
    private void LoginPerformed(ActionEvent e)
    {
        try{
            st = c.createStatement();
            String user_name = TF.getText();
            String user_password =PF.getText();

            String SqlQuery = "SELECT* FROM loginform WHERE user_name='"+user_name+"' and user_password='"+user_password+"' ";
            ResultSet RS = st.executeQuery(SqlQuery);
            if(RS.next())
            {
                JOptionPane.showMessageDialog(null,"Login Successful"); //if success it will appear a dilogbox with login success message
            }
            else{
                JOptionPane.showMessageDialog(null,"Invalid Credential"); //if user enter the incorrect credential this statement will call || open dilog box with invalid credential
            }
        }catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null,ex);
        }
    }

}
