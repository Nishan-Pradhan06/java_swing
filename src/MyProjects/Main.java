package MyProjects;

//import the packages
import javax.swing.*;

class MyFrame extends JFrame{
    MyFrame()
    {
//        new MyFrame();
        this.setVisible(true); //it visible the window
        this.setSize(400,500); //default value
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //Exit while clicking 'X' Button
        this.setLocationRelativeTo(null); //it set the window to middle
        this.setResizable(false);
    }
}
public class Main {
    public static void main(String[] args) {
        //Login Form Frame Component
        myLoginComponents LoginComponents =new myLoginComponents();
//        new MyFrame().add(LoginComponents.JP); //adding the MyLoginComponents

        StudentInsertComponent studentComponent = new StudentInsertComponent();
        new MyFrame().add(studentComponent.JP);
    }
}
