package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Signup extends JFrame implements ActionListener {

    JRadioButton r1;
    JRadioButton r2,m1,m2,m3;
    JButton next;

    JTextField textName, textFname, textemail, textms, textadr, textcity, textpin, textstate;
    JDateChooser dateChooser;



    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    String first = " " + Math.abs(first4);
    Signup(){
        super("Application Form");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(25,10,100,100);
        add(image);

        JLabel label1 = new JLabel("APPLICATION FORM NO." + first);
        label1.setBounds(160,20,600,40);
        label1.setFont(new Font("Raleway",Font.BOLD, 38));
        add(label1);

        JLabel label2 = new JLabel("Page 1.");
        label2.setFont(new Font("Raleway",Font.BOLD, 22));
        label2.setBounds(330,70,600,30);
        add(label2);

        JLabel label3 = new JLabel("Personal Details");
        label3.setFont(new Font("Raleway",Font.BOLD, 22));
        label3.setBounds(290,90,600,30);
        add(label3);

        JLabel labelname = new JLabel("Name:");
        labelname.setFont(new Font("Raleway",Font.BOLD, 20));
        labelname.setBounds(100,190,100,30);
        add(labelname);

        textName = new JTextField();
        textName.setFont(new Font("Raleway",Font.BOLD, 14));
        textName.setBounds(300,190,400,30);
        add(textName);

        JLabel labelfname = new JLabel("Father's Name:");
        labelfname.setFont(new Font("Raleway",Font.BOLD, 20));
        labelfname.setBounds(100,240,200,30);
        add(labelfname);

        textFname = new JTextField();
        textFname.setFont(new Font("Raleway",Font.BOLD, 14));
        textFname.setBounds(300,240,400,30);
        add(textFname);

        JLabel DOB = new JLabel("Date Of Birth:");
        DOB.setFont(new Font("Raleway",Font.BOLD, 20));
        DOB.setBounds(100,340,200,30);
        add(DOB);

        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105, 105, 105));
        dateChooser.setBounds(300,340,400,30);
        add(dateChooser);


        JLabel labelG = new JLabel("Gender");
        labelG.setFont(new Font("Raleway", Font.BOLD, 20));
        labelG.setBounds(100,290,200,30);
        add(labelG);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Raleway", Font.BOLD,14));
        r1.setBackground(new Color(222,255,228));
        r1.setBounds(300,290,60,30);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setBackground(new Color(222,255,228));
        r2.setFont(new Font("Raleway", Font.BOLD,14));
        r2.setBounds(450,290,90,30);
        add(r2);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);
        r1.setSelected(true);
        r2.setSelected(true);

        JLabel labelemial = new JLabel("Email: ");
        labelemial.setFont(new Font("Raleway", Font.BOLD, 20));
        labelemial.setBounds(100,390,200,30);
        add(labelemial);

        textemail = new JTextField();
        textemail.setFont(new Font("Raleway",Font.BOLD, 14));
        textemail.setBounds(300,390,400,30);
        add(textemail);


        JLabel mariedstatus = new JLabel("Marital Status:");
        mariedstatus.setFont(new Font("Raleway", Font.BOLD, 20));
        mariedstatus.setBounds(100,440,200,30);
        add(mariedstatus);
        m1 = new JRadioButton("Married");
        m1.setBounds(300,440,100,30);
        m1.setBackground(new Color(222,255,228));
        m1.setFont(new Font("Raleway", Font.BOLD,14));
        add(m1);
        m2 = new JRadioButton("Unmarried");
        m2.setBackground(new Color(222,255,228));
        m2.setBounds(450,440,100,30);
        m2.setFont(new Font("Raleway", Font.BOLD,14));
        add(m2);
        m3 = new JRadioButton("Other");
        m3.setBackground(new Color(222,255,228));
        m3.setBounds(635,440,100,30);
        m3.setFont(new Font("Raleway", Font.BOLD,14));
        add(m3);
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(m1);
        buttonGroup1.add(m2);
        buttonGroup1.add(m3);



        JLabel adress = new JLabel("Address:");
        adress.setFont(new Font("Raleway", Font.BOLD, 20));
        adress.setBounds(100,490,200,30);
        add(adress);
        textadr = new JTextField();
        textadr.setFont(new Font("Raleway",Font.BOLD, 14));
        textadr.setBounds(300,490,400,30);
        add(textadr);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100,540,200,30);
        add(city);
        textcity = new JTextField();
        textcity.setFont(new Font("Raleway",Font.BOLD, 14));
        textcity.setBounds(300,540,400,30);
        add(textcity);


        JLabel pin = new JLabel("PIN Code:");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(100,590,200,30);
        add(pin);
        textpin = new JTextField();
        textpin.setFont(new Font("Raleway",Font.BOLD, 14));
        textpin.setBounds(300,590,400,30);
        add(textpin);

        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100,640,200,30);
        add(state);
        textstate = new JTextField();
        textstate.setFont(new Font("Raleway",Font.BOLD, 14));
        textstate.setBounds(300,640,400,30);
        add(textstate);

        next = new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD, 14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(620,710,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(new Color(222,255,228));
        setLayout(null);
        setSize(850,800);
        setLocation(360,40);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String foamno = first;
        String name = textName.getText();
        String fname = textFname.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(r1.isSelected()){
            gender = "Male";
        }
        else if(r2.isSelected()){
            gender = "Female";
        }

        String email = textemail.getText();
        String marital = null;
        if(m1.isSelected()){
            marital = "Married";
        }
        else if(m2.isSelected()){
            marital = "Unmarried";
        }
        else if(m3.isSelected()){
            marital = "Other";
        }
        String address = textadr.getText();
        String city = textcity.getText();
        String pincode = textpin.getText();
        String state = textstate.getText();

        try {
            if(textName.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please enter your name");
            } else {
                Con con1 = new Con();
                String q = "insert into signup values('"+foamno+"' , '"+name+"' , '"+fname+"' , '"+dob+"' , '"+gender+"' , '"+email+"' , '"+marital+"' , '"+address+"' , '"+city+"' , '"+pincode+"' , '"+state+"')";
                con1.statement.executeUpdate(q);
                new Signup2(first);
                setVisible(false);
                JOptionPane.showMessageDialog(null, "Signup Successful");
            }

        } catch (Exception E) {
            E.printStackTrace();
        }


    }
    public static void main(String[] args){
        new Signup();
    }
}
