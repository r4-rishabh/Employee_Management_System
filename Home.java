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


public class Home extends JFrame implements ActionListener{
    JButton view, remove, update, add;
    Home(){
        setLayout(null);
        
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("icon/Homeimg.jpg"));
        Image i1 = ic.getImage().getScaledInstance(1120, 630,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel img = new JLabel(i2);
        img.setBounds(0,0,1120,630);
        add(img);
        
        JLabel heading = new JLabel("HOME");
        heading.setForeground(Color.WHITE);
        heading.setBounds(330,20,400,40);
        heading.setFont(new Font("TAHOMA", Font.BOLD, 30));
        img.add(heading);
        
        add = new JButton("Add Employee");
        add.setBounds(150,100,150,40);
        add.addActionListener(this);
        img.add(add);
        
        view = new JButton("View Employee");
        view.setBounds(450,100,150,40);
        view.addActionListener(this);
        img.add(view);
        
        remove = new JButton("Remove Employee");
        remove.setBounds(150,200,150,40);
        remove.addActionListener(this);
        img.add(remove);
        
        update = new JButton("Update Employee");
        update.setBounds(450,200,150,40);
        update.addActionListener(this);
        img.add(update);
        
        setTitle("Employee Management System");
        setSize(1120,630);
        setLocation(250,100);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==add) {
           new AddEmp();
        }
        else if(e.getSource()==view){
            new ViewEmp();
        }
        else if(e.getSource()==update){
            setVisible(false);
            new ViewEmp();
        }
        else{
            setVisible(false);
            new RemoveEmp();
        }
        
    }
    public static void main(String[] args) {
        new Home();
    }
    
}
