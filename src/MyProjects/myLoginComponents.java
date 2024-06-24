package MyProjects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

// Class to handle login components
public class myLoginComponents {
    MyFrame m; // Reference to the main frame
    JPanel JP; // Panel to hold UI components
    JLabel uName, uPassword, heading; // Labels for username, password, and heading
    JTextField TF; // Text field for username input
    JPasswordField PF; // Password field for password input
    JButton BTN; // Button for login action

    Connection c = database.connect(); // Establish database connection
    Statement st = null;

    // Constructor to initialize login UI components
    myLoginComponents(MyFrame m) {
        this.m = m;

        // Initialize the panel and set its properties
        JP = new JPanel();
        JP.setSize(350, 300);
        JP.setLayout(null); // Using null layout for precise component placement
        m.add(JP); // Add panel to the main frame

        // Heading label
        heading = new JLabel("LOGIN");
        heading.setFont(new Font("calibri", Font.BOLD, 35));
        heading.setBounds(110, 10, 100, 40); // (X, Y, width, height)
        JP.add(heading);

        // Username label and text field
        uName = new JLabel("User Name:");
        uName.setFont(new Font("calibri", Font.BOLD, 16));
        uName.setBounds(20, 65, 100, 20);
        JP.add(uName);
        TF = new JTextField();
        TF.setBounds(120, 60, 200, 30);
        TF.setBorder(BorderFactory.createEmptyBorder()); // Remove default border
        JP.add(TF);

        // Password label and password field
        uPassword = new JLabel("Password:");
        uPassword.setFont(new Font("calibri", Font.BOLD, 16));
        uPassword.setBounds(20, 125, 100, 20);
        JP.add(uPassword);
        PF = new JPasswordField();
        PF.setBounds(120, 120, 200, 30);
        PF.setBorder(BorderFactory.createEmptyBorder()); // Remove default border
        JP.add(PF);

        // Login button
        BTN = new JButton("Login");
        BTN.setBackground(Color.GREEN);
        BTN.setBounds(135, 200, 100, 40);
        BTN.setBorder(BorderFactory.createEmptyBorder()); // Remove default border
        BTN.setFocusPainted(false); // Disable focus painting for cleaner look
        JP.add(BTN);

        // ActionListener for the Login button
        BTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginPerformed(e); // Call method when button is clicked
                System.out.println("DataBase Connection Successful"); // Log connection success to console
            }
        });

        m.setVisible(true); // Make the main frame visible
    }

    // Method to handle login logic
    private void LoginPerformed(ActionEvent e) {
        try {
            st = c.createStatement();
            String user_name = TF.getText(); // Get username from text field
            String user_password = PF.getText(); // Get password from password field

            // SQL query to check credentials
            String SqlQuery = "SELECT * FROM loginform WHERE user_name='" + user_name + "' and user_password='" + user_password + "'";
            ResultSet RS = st.executeQuery(SqlQuery);

            // Check if result set has any data (valid credentials)
            if (RS.next()) {
                JOptionPane.showMessageDialog(null, "Login Successful"); // Show success message
                m.dispose(); // Close the login frame
                // Assuming StudentInsertComponent is another class for further actions
                StudentInsertComponent SIC = new StudentInsertComponent();
                SIC.init(); // Initialize StudentInsertComponent
            } else if (user_name.isEmpty() || user_password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Fields Cannot be Empty"); // Show empty fields message
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Credentials"); // Show invalid credentials message
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex); // Show any exceptions in a dialog
        }
    }
}
