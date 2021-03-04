package MyHotel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

import net.proteanit.sql.DbUtils;


public class PickUpServices extends JFrame implements ActionListener
{
	
	Choice cb1;
	JCheckBox c1; 
	JTable t;
	JButton b1, b2;
	
	PickUpServices()
	{
		JLabel l1 =new JLabel("Pick Up Services");
		l1.setBounds(320, 30,200,30);
		l1.setFont(new Font("Tahoma",Font.BOLD,20));
		add(l1);
		
		JLabel l2 =new JLabel("BED TYPE :-");
		l2.setBounds(100,80,100,30);
		add(l2);
		
		JLabel l3 =new JLabel("Name");
		l3.setBounds(40,130,100,30);
		add(l3);
		
		
		JLabel l4 =new JLabel("Age");
		l4.setBounds(150,130,100,30);
		add(l4);
		
		JLabel l5 =new JLabel("Gender");
		l5.setBounds(260,130,100,30);
		add(l5);
		
		
		JLabel l6 =new JLabel("Brand");
		l6.setBounds(370,130,100,30);
		add(l6);
		
		JLabel l7 =new JLabel("Model");
		l7.setBounds(480,130,100,30);
		add(l7);
		
		JLabel l8 =new JLabel("Available");
		l8.setBounds(590,130,100,30);
		add(l8);
		
		JLabel l9 =new JLabel("Location");
		l9.setBounds(700,130,100,30);
		add(l9);
		
		cb1 = new Choice();
		try {
			conn c = new conn();
			ResultSet rs = c.s.executeQuery("select * from drivers");
			while(rs.next())
			{
				cb1.add(rs.getString("model"));
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}
		cb1.setBounds(200,80,150,30);
		add(cb1);
		
		c1 = new JCheckBox("Available");
		c1.setBounds(600,80,150,30);
		add(c1);
		
		t= new JTable();
		t.setBounds(10, 160,765,300);
		add(t);
		
		b1 = new JButton ("Search");
		b1.setBounds(200,500,100,30);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton ("Cancel");
		b2.setBounds(500,500,100,30);
		b2.addActionListener(this);
		add(b2);
		
		setBounds(500,200,800,600);
		setLayout(null);
		setVisible(true);
		
	}
	public static void main(String args[])
	{
		new PickUpServices().setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String type = (String) cb1.getSelectedItem();
		String str =null;
		
		if(e.getSource()==b1)
		{
			try {
				conn c =new conn();
				if(c1.isSelected())
				{
					
					 str = "select * from drivers where model='"+type+"' and available ='Available'";
				}
				else
				{
					str = "select * from drivers where model='"+type+"'";

				}
				
				ResultSet rs = c.s.executeQuery(str);
				
				t.setModel(DbUtils.resultSetToTableModel(rs));
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
	
		// TODO Auto-generated method stub
		
	}
	
