package employee.management.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{
    JTextField tf1, tf2;
    Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel uname = new JLabel("Username");
        uname.setBounds(40,20,100,30);
        add(uname);
        tf1 = new JTextField();
        tf1.setBounds(150,20,150,30);
        add(tf1);
        
        JLabel pass = new JLabel("Password");
        pass.setBounds(40,70,100,30);
        add(pass);
        tf2 = new JTextField();
        tf2.setBounds(150,70,150,30);
        add(tf2);
        
        JButton li = new JButton("LogIn");
        li.setBounds(150,120,150,30);
        li.addActionListener(this);
        add(li);
        
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("icon/Login.png"));
        Image i1 = ic.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel img = new JLabel(i2);
        img.setBounds(350,0,200,200);
        add(img);
        
        setTitle("Employee Management System");
        setSize(600,300);
        setLocation(450,200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e){
        try {
            String uname = tf1.getText();
            String pass = tf2.getText();
            Conn c = new Conn();
            String query = "select * from login where username = '"+uname+"' and password = '"+pass+"'";
            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()) {
                setVisible(false);
                new Home();
            }
            else{
                JOptionPane.showMessageDialog(null,"Invalid usernsme or  password");
                setVisible(false);
            }
        }
        catch (Exception ae) {
            ae.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}
