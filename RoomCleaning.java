package MyHotel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

import net.proteanit.sql.DbUtils;


public class RoomCleaning extends JFrame implements ActionListener
{
	
	Choice cb1;
	JCheckBox c1; 
	JTable t;
	JButton b1, b2,  b3;
	
	RoomCleaning()
	{
		JLabel l1 =new JLabel("Room Cleaning");
		l1.setBounds(320, 20,200,30);
		l1.setFont(new Font("Tahoma",Font.BOLD,20));
		add(l1);
		
		JLabel l2 =new JLabel("BED TYPE :-");
		l2.setBounds(100,450,100,30);
		add(l2);
		
		JLabel l3 =new JLabel("Room No");
		l3.setBounds(50,45,100,30);
		add(l3);
		
		
		JLabel l4 =new JLabel("Status");
		l4.setBounds(210,45,100,30);
		add(l4);
		
		JLabel l5 =new JLabel("Cleaning-st");
		l5.setBounds(370,45,100,30);
		add(l5);
		
		
		JLabel l6 =new JLabel("Price");
		l6.setBounds(530,45,100,30);
		add(l6);
		
		JLabel l7 =new JLabel("Bed Type");
		l7.setBounds(670,45,100,30);
		add(l7);
		
		cb1 = new Choice();
		try {
			conn c = new conn();
			ResultSet rs = c.s.executeQuery("select * from rooms where status ='Not Cleaned' ");
			while(rs.next())
			{
				cb1.add(rs.getString("room_number"));
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}
		cb1.setBounds(200,450,150,30);
		add(cb1);
		
		c1 = new JCheckBox("Cleaned");
		c1.setBounds(600,450,150,30);
		add(c1);
		
		t= new JTable();
		t.setBounds(10,80,765,300);
		add(t);
		
		b1 = new JButton ("Update");
		b1.setBounds(200,500,100,30);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton ("Cancel");
		b2.setBounds(500,500,100,30);
		b2.addActionListener(this);
		add(b2);
		
		b3 = new JButton ("Search");
		b3.setBounds(350,400,100,30);
		b3.addActionListener(this);
		add(b3);
		
		setBounds(500,200,800,600);
		setLayout(null);
		setVisible(true);
		
	}
	public static void main(String args[])
	{
		new RoomCleaning().setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String type = (String) cb1.getSelectedItem();
		String str =null;
		
		if(e.getSource()==b3)
		{
			try {
				conn c =new conn();
					
				str = "select * from rooms where status ='Not Cleaned'";
				
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
		else if(e.getSource()==b1)
		{
			try {
				conn c =new conn();
				if(c1.isSelected())
				{
					
					 str = "update rooms set status= 'Cleaned' where  room_number ='"+type+"'";
				}
				else
				{
					str= "update rooms set status= 'Not Cleaned' where  room_number ='"+type+"'";

				}
				
				c.s.executeQuery(str);
				
				
			}catch(Exception ea)
			{
				System.out.println(ea);
			}
			
			JOptionPane.showMessageDialog(null,"Updated Successfully");
			
		}
		}
	
	}
	
		// TODO Auto-generated method stub
		
	
