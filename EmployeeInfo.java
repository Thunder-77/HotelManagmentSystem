package MyHotel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import net.proteanit.sql.*;

public class EmployeeInfo extends JFrame implements ActionListener {
	JTable t1;
	JButton b1,b2;
	
	EmployeeInfo()
	{	
		t1 = new JTable();
		t1.setBounds(0,40,1000,500);
		add(t1);
		
		JLabel l1= new JLabel("Name");
		l1.setBounds(40,10,70,20);
		add(l1);
		
		JLabel l2= new JLabel("Age");
		l2.setBounds(170,10,70,20);
		add(l2);
		
		JLabel l3= new JLabel("Gender");
		l3.setBounds(290,10,70,20);
		add(l3);
		
		JLabel l4= new JLabel("Role");
		l4.setBounds(410,10,70,20);
		add(l4);
		
		JLabel l5= new JLabel("Salary");
		l5.setBounds(530,10,70,20);
		add(l5);
		
		JLabel l6= new JLabel("Mobile nos");
		l6.setBounds(650,10,70,20);
		add(l6);
		
		JLabel l7= new JLabel("Adhar");
		l7.setBounds(770,10,70,20);
		add(l7);
		
		JLabel l8= new JLabel("Email ID");
		l8.setBounds(890,10,70,20);
		add(l8);
		
		
		b1=new JButton("Load Data");
		setBackground(Color.BLACK);
		setForeground(Color.WHITE);
		b1.setBounds(350,560,120,30);
		b1.addActionListener(this);
		add(b1);
		
		b2=new JButton("Back");
		b2.setBounds(530,560,120,30);
		b2.addActionListener(this);
		add(b2);
		
		
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setBounds(450,200,1000,650);
		setVisible(true);
	}
	@Override 
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1)
		{
			try {
				conn c =new conn();
				String str = "select * from employee";
				ResultSet rs = c.s.executeQuery(str);
				
				t1.setModel(DbUtils.resultSetToTableModel(rs));
			}catch(Exception ea)
			{
				System.out.println(ea);
			}
			
		}
		else if(e.getSource()==b2)
		{
			this.setVisible(false);
		}
	
	}
	
	public static void main(String args[])
	{
		new EmployeeInfo().setVisible(true);
	}

}
