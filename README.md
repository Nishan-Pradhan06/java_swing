<!DOCTYPE html>
<html lang="en">
<head>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Poppins', sans-serif;
        }
    </style>
</head>
<body>

# Student Management System

This Java Swing-based Student Management System implements CRUD functionalities, allowing an admin to manage student records. The application provides interfaces for logging in, inserting student data, viewing records, and performing operations such as creating, updating, deleting, and searching for student records.

## Features

- **Login Form**: Allows admin users to log into the system.
- **Student Insertion**: Enables admins to add new student records.
- **View Data**: Displays all student records in a table.
- **Operations**: Admins can search for a student by ID, and update or delete student records.

## Screenshots

### Login Form UI
![Login Form](src/assets/Screenshot%202024-06-23%20222010.png)

### Student Insertion UI
![Student Insertion](src/assets/Screenshot%202024-06-23%20221856.png)

### View Data UI
![View Data](src/assets/Screenshot%202024-07-02%20204600.png)

### Operation UI
![Operation](src/assets/Screenshot%202024-07-02%20191652.png)

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- A database setup (MySQL, PostgreSQL, etc.)
- JDBC driver for the database

### Setting Up the Project

1. **Clone the repository**:
    ```bash
    git clone https://github.com/your-username/student-management-system.git
    cd student-management-system
    ```

2. **Database Configuration**:
    - Create a database named `student_management`.
    - Create a table named `students_data` with the following columns:
        ```sql
        CREATE TABLE students_data (
            std_id INT PRIMARY KEY AUTO_INCREMENT,
            std_name VARCHAR(50),
            std_roll INT,
            std_address VARCHAR(100),
            std_gender VARCHAR(10),
            std_phone VARCHAR(15),
            std_email VARCHAR(50)
        );
        ```

3. **Configure Database Connection**:
    - Update the `database.java` file with your database connection details:
        ```java
        package MyProjects;

        import java.sql.*;
        import javax.swing.JOptionPane;

        public class database {
            final static String DB_URL = "jdbc:mysql://localhost:3306/student_management";
            final static String user = "root";
            final static String password = "";
            
            public static Connection connect() {
                try {
                    Connection c = DriverManager.getConnection(DB_URL, user, password);
                    return c;
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                    return null;
                }
            }
        }
        ```

4. **Run the Application**:
    - Compile and run the main class:
        ```bash
        javac Main.java
        java Main
        ```

## Class Descriptions

### Main.java

```java
package MyProjects;

public class Main {
    public static void main(String[] args) {
        MyFrame m = new MyFrame();
        m.load();
        // Login Form Frame Component
        myLoginComponents LoginComponents = new myLoginComponents(m);
    }
}
