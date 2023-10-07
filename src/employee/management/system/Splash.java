package employee.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Splash extends JFrame implements ActionListener{
    Splash(){
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);
        
        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(80,30,1200,60);
        heading.setFont(new Font("serif", Font.PLAIN, 60 ));
        heading.setForeground(Color.WHITE); 
        add(heading);
        
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("icon/splash1.jpg"));
        Image i1 = ic.getImage().getScaledInstance(1100, 700,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel img = new JLabel(i2);
        img.setBounds(50,100,1050,500);
        add(img);
        
        JButton b1 = new JButton("CLICK HERE");
        b1.setBounds(400, 400, 300, 70);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        img.add(b1);
        
        setTitle("Employee Management System");
        setSize(1170,650);
        setLocation(200, 50);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    public void actionPerformed(ActionEvent e){
        setVisible(false);
        new Login();
    }
    public static void main(String[] args) {
        new Splash();
    }
}
