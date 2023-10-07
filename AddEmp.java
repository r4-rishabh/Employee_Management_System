package employee.management.system;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;



public class AddEmp extends JFrame implements ActionListener{
    Random ran = new Random();
    int no = ran.nextInt(9999);
    
    JButton add, bck;
    JLabel heading, lname, fname, dob, sal, addr, phn, email, edu, des, adhar, id, empid ;
    JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8;
    JComboBox hedu;
    JDateChooser dcdob;

    AddEmp(){
        setLayout(null);
        
        heading = new JLabel("Add Employee Details");
        heading.setForeground(Color.BLACK);
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
        
        lname = new JLabel("Name");
        lname.setBounds(50,150,150,30);
        lname.setFont(new Font("serif", Font.PLAIN, 20));
        add(lname);
        
        tf1 = new JTextField();
        tf1.setBounds(140,150,150,30);
        add(tf1);
        
        fname = new JLabel("Father's Name");
        fname.setBounds(400,150,150,30);
        fname.setFont(new Font("serif", Font.PLAIN, 20));
        add(fname);
        
        tf2 = new JTextField();
        tf2.setBounds(550,150,150,30);
        add(tf2);
        
        dob = new JLabel("DOB");
        dob.setBounds(50,200,150,30);
        dob.setFont(new Font("serif", Font.PLAIN, 20));
        add(dob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(140,200,150,30);
        add(dcdob);
        
        sal = new JLabel("Salary");
        sal.setBounds(400,200,150,30);
        sal.setFont(new Font("serif", Font.PLAIN, 20));
        add(sal);
        
        tf3 = new JTextField();
        tf3.setBounds(550,200,150,30);
        add(tf3);
        
        addr = new JLabel("Address");
        addr.setBounds(50,250,150,30);
        addr.setFont(new Font("serif", Font.PLAIN, 20));
        add(addr);
        
        tf4 = new JTextField();
        tf4.setBounds(140,250,150,30);
        add(tf4);
        
        phn = new JLabel("Phone No.");
        phn.setBounds(400,250,150,30);
        phn.setFont(new Font("serif", Font.PLAIN, 20));
        add(phn);
        
        tf5 = new JTextField();
        tf5.setBounds(550,250,150,30);
        add(tf5);
        
        email = new JLabel("Email");
        email.setBounds(50,300,150,30);
        email.setFont(new Font("serif", Font.PLAIN, 20));
        add(email);
        
        tf6 = new JTextField();
        tf6.setBounds(140,300,150,30);
        add(tf6);
        
        edu = new JLabel("Highest Edu.");
        edu.setBounds(400,300,150,30);
        edu.setFont(new Font("serif", Font.PLAIN, 20));
        add(edu);
        
        String courses[] = {"SELECT", "BSC", "BCOM", "BA", "BTECH", "MSC", "MCOM", "MA", "MTECH", "PHD"};
        hedu = new JComboBox(courses);
        hedu.setBounds(550,300,150,30);
        add(hedu);
        
        des = new JLabel("Dsgn.");
        des.setBounds(50,350,150,30);
        des.setFont(new Font("serif", Font.PLAIN, 20));
        add(des);
        
        tf7 = new JTextField();
        tf7.setBounds(140,350,150,30);
        add(tf7);
        
        adhar = new JLabel("Adhaar No.");
        adhar.setBounds(400,350,150,30);
        adhar.setFont(new Font("serif", Font.PLAIN, 20));
        add(adhar);
        
        tf8 = new JTextField();
        tf8.setBounds(550,350,150,30);
        add(tf8);
        
        empid = new JLabel("Employee Id");
        empid.setBounds(50,400,150,30);
        empid.setFont(new Font("serif", Font.PLAIN, 20));
        add(empid);
        
        id = new JLabel("" + no);
        id.setBounds(180,400,150,30);
        id.setFont(new Font("serif", Font.PLAIN, 20));
        add(id);
        
        add  = new JButton("Add Details");
        add.setBounds(200,500,150,40);
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add(add);
        add.addActionListener(this);
        
        bck  = new JButton("Back");
        bck.setBounds(400,500,150,40);
        bck.setBackground(Color.black);
        bck.setForeground(Color.white);
        add(bck);
        bck.addActionListener(this);
        
        setTitle("Employee Management System");
        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==add) {
            String name = tf1.getText();
            String fname = tf2.getText();
            String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String salary = tf3.getText();
            String address = tf4.getText();
            String phone = tf5.getText();
            String email = tf6.getText();
            String education = (String)hedu.getSelectedItem();
            String designation = tf7.getText();
            String addhar = tf8.getText();
            String empid = id.getText();
            
            try {
                Conn conn = new Conn();
                String query = "insert into employee values('"+name+"', '"+fname+"', '"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+designation+"','"+addhar+"','"+empid+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new Home();
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
            new Home();
        }
    }
    public static void main(String[] args) {
        new AddEmp();
    }
}
