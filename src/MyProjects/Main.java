package MyProjects;

//import the packages
import javax.swing.*;

class MyFrame extends JFrame{
    void load()
    {
//        new MyFrame();
        this.setTitle("Login");
        this.setSize(350,300); //default value
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //Exit while clicking 'X' Button
        this.setLocationRelativeTo(null); //it set the window to middle
        this.setResizable(false);
    }
}
public class Main {
    public static void main(String[] args) {

        MyFrame m =new MyFrame();
        m.load();
        //Login Form Frame Component
        myLoginComponents LoginComponents = new myLoginComponents(m);
//        operation op = new operation();


    }
}
