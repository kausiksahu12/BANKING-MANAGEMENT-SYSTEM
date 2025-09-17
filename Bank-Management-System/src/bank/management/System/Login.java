// Create Login page for the bank that here the  card number and pin for sign in. here click the signup page where create the acount.
// JFrame:
// A top-level window with a title and a border.
// It is the main window container in Swing where you can add buttons, text fields, etc.

// JLabel:
// A GUI display area for a short text string or an image/icon.
// Used for labeling components (like "Enter Name", "Enter PIN").

// JTextField:
// A text box that allows the user to enter a single line of text input (like name, email, etc.).

// JPasswordField:
// A text field specifically for entering passwords.
// The characters are hidden (shown as ••• instead of actual characters).

// JButton:
// A clickable button that performs an action when pressed (like "Login", "Submit").

// ImageIcon:
// A class to load and display images (icons, logos, etc.) inside buttons, labels, or frames.

// ActionEvent:
// An event generated when a user performs an action on a component (e.g., clicking a button).

// getSource():
// A method that tells which component triggered the event (useful when you have multiple buttons).

// statement.executeQuery(q):
// Used to run a SELECT SQL query on the database and returns the ResultSet containing records.
// Example: statement.executeQuery("SELECT * FROM login");

// JOptionPane.showMessageDialog(null, "Invalid Card Number");
// Displays a small popup dialog box with a message for the user.
// Here, it shows "Invalid Card Number" if login fails.

// setVisible(false);
// Hides the current window/frame. Commonly used to close the login window after success/failure.

// e.printStackTrace();
// Prints the error/exception details in the console. Useful for debugging.

// javax.swing.*;
// A package that contains classes for building graphical user interfaces (Swing components).

// import java.awt.*;
// A package that contains classes for GUI components like colors, fonts, layouts, etc.

// import java.awt.event.ActionEvent;
// Provides classes to handle events like button clicks, mouse movements, etc.

// import java.awt.event.ActionListener;
// An interface used to receive and handle ActionEvents (e.g., button click action).

// import java.sql.ResultSet;
// A table of data returned by executing SQL queries using executeQuery().
// You can loop through ResultSet to read data row by row.

package bank.management.system;
// import all the packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
// Jframe
public class Login extends JFrame implements ActionListener {
    JLabel label1, label2, label3;
    JTextField textField2;
    JPasswordField passwordField3;

    JButton button1,button2,button3;
    Login(){
        super("Bank Management System");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,10,100,100);
        add(image);

        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
        Image ii2 = ii1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel iimage = new JLabel(ii3);
        iimage.setBounds(630,350,100,100);
        add(iimage);

        label1 = new JLabel("WELCOME TO ATM");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("AvantGarde", Font.BOLD, 38));
        label1.setBounds(230,125,450,40);
        add(label1);

        label2 = new JLabel("Card No:");
        label2.setFont(new Font("Ralway", Font.BOLD, 28));
        label2.setForeground(Color.WHITE);
        label2.setBounds(150,190,375,30);
        add(label2);

        textField2 = new JTextField(15);
        textField2.setBounds(325,190,230,30);
        textField2.setFont(new Font("Arial", Font.BOLD,14));
        add(textField2);

        label3 = new JLabel("PIN: ");
        label3.setFont(new Font("Ralway", Font.BOLD, 28));
        label3.setForeground(Color.WHITE);
        label3.setBounds(150,250,375,30);
        add(label3);

        passwordField3 = new JPasswordField(15);
        passwordField3.setBounds(325,250,230,30);
        passwordField3.setFont(new Font("Arial", Font.BOLD, 14));
        add(passwordField3);

        button1 = new JButton("SIGN IN");
        button1.setFont(new Font("Arial", Font.BOLD, 14));
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.BLACK);
        button1.setBounds(300,300,100, 30);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("CLEAR");
        button2.setFont(new Font("Arial", Font.BOLD, 14));
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.BLACK);
        button2.setBounds(430,300,100, 30);
        button2.addActionListener(this);
        add(button2);

        button3 = new JButton("SIGN UP");
        button3.setFont(new Font("Arial", Font.BOLD, 14));
        button3.setForeground(Color.WHITE);
        button3.setBackground(Color.BLACK);
        button3.setBounds(300,350,230, 30);
        button3.addActionListener(this);
        add(button3);

        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("icon/backbg.png"));
        Image iii2 = iii1.getImage().getScaledInstance(850,480,Image.SCALE_DEFAULT);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel iiimage = new JLabel(iii3);
        iiimage.setBounds(0,0,850,480);
        add(iiimage);


        setLayout(null);
        setSize(850,480);
        setLocation(450,200);
        setUndecorated(true);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if (e.getSource()==button1){
                Con c = new Con();
                String cardno = textField2.getText();
                String pin = passwordField3.getText();
                String q = "select * from login where card_number = '"+cardno+"' and pin = '"+pin+"'";
                ResultSet resultSet = c.statement.executeQuery(q);
                if(resultSet.next()){
                    setVisible(false);
                    new main_Class(pin);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Card Number");
                }


            }else if (e.getSource() == button2){
                textField2.setText("");
                passwordField3.setText("");
            }else if (e.getSource() == button3){
                new Signup();
                setVisible(false);

            }
        }catch (Exception E){
            E.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}