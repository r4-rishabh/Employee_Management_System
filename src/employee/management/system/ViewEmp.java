package employee.management.system;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;


public class ViewEmp extends JFrame implements ActionListener{
    JTable table;
    Choice empId;
    JButton Search, print, update, back;
    
    ViewEmp(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel search = new JLabel("Search id");
        search.setBounds(20,20,80,20);
        add(search);
        
        empId = new Choice();
        empId.setBounds(100,20,150,20);
        add(empId);
        
        table = new JTable();
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select*from employee");
            while(rs.next()){
                empId.add(rs.getString("empid"));
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select*from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            while(rs.next()){
                empId.add(rs.getString("empid"));
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);
        
        Search = new JButton("Search");
        Search.setBounds(20,70,80,20);
        Search.addActionListener(this);
        add(Search);
        
        update = new JButton("Update");
        update.setBounds(120,70,80,20);
        update.addActionListener(this);
        add(update);
        
        print = new JButton("Print");
        print.setBounds(220,70,80,20);
        print.addActionListener(this);
        add(print);
        
        back = new JButton("Back");
        back.setBounds(320,70,80,20);
        back.addActionListener(this);
        add(back);
        
        
        setTitle("Employee Managemenet System");
        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==Search) {
            String query = "select*from employee where empid = '"+empId.getSelectedItem()+"'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==update){
            setVisible(false);
            new UpdateEmp(empId.getSelectedItem());
        }
        else if(ae.getSource()==print){
            try {
               table.print();
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
        new ViewEmp();
    }
}
