package employee.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
import java.sql.*;

public class RemoveEmp extends JFrame implements ActionListener{
    Choice cempId;
    JButton dlt, back;
    
    RemoveEmp(){
        setLayout(null);
        
        JLabel ei = new JLabel("Employee Id");
        ei.setBounds(50,50,100,30);
        add(ei);
        
        cempId = new Choice();
        cempId.setBounds(200,50,150,30);
        add(cempId);
        
        try {
            Conn c = new Conn();
            String query = "select*from employee";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                cempId.add(rs.getString("empid"));
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel lbname = new JLabel("Name");
        lbname.setBounds(50,100,100,30);
        add(lbname);
        
        JLabel labelname = new JLabel();
        labelname.setBounds(200,100,100,30);
        add(labelname);
        
        JLabel lbphone = new JLabel("Phone");
        lbphone.setBounds(50,150,100,30);
        add(lbphone);
        
        JLabel labelphone = new JLabel();
        labelphone.setBounds(200,150,100,30);
        add(labelphone);
        
        JLabel lbemail = new JLabel("Email");
        lbemail.setBounds(50,200,100,30);
        add(lbemail);
        
        JLabel labelemail = new JLabel();
        labelemail.setBounds(200,200,150,30);
        add(labelemail);
        
        try {
            Conn c = new Conn();
            String query = "select*from employee where empid = '"+cempId.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelname.setText(rs.getString("name"));
                labelphone.setText(rs.getString("phone"));
                labelemail.setText(rs.getString("email"));
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
  
        cempId.addItemListener(new ItemListener(){

            @Override
            public void itemStateChanged(ItemEvent ie) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                 try {
            Conn c = new Conn();
            String query = "select*from employee where empid = '"+cempId.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelname.setText(rs.getString("name"));
                labelphone.setText(rs.getString("phone"));
                labelemail.setText(rs.getString("email"));
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
            }
            
    });
        dlt = new JButton("Delete");
        dlt.setBounds(80,300,100,20);
        dlt.setBackground(Color.BLACK);
        dlt.setForeground(Color.WHITE);
        dlt.addActionListener(this);
        add(dlt);
        
        back = new JButton("Back");
        back.setBounds(220,300,100,20);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("icon/Delete.jpg"));
        Image i1 = ic.getImage().getScaledInstance(600, 400,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel img = new JLabel(i2);
        img.setBounds(0,0,1000,400);
        add(img);
        
        setTitle("Employee Management System");
        setSize(1000,400);
        setLocation(300,150);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==dlt) {
            try {
                Conn c = new Conn();
                String query = "delete from employee where empid = '"+cempId.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Information Deleted");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
            new Home();
        }
        
    }
    public static void main(String[] args) {
        new RemoveEmp();
    }
}
