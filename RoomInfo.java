package MyHotel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

import net.proteanit.sql.DbUtils;


public class RoomInfo extends JFrame implements ActionListener
{
	
	JComboBox cb1;
	JCheckBox c1; 
	JTable t;
	JButton b1, b2;
	
	RoomInfo()
	{
		JLabel l1 =new JLabel("Room Info");
		l1.setBounds(320, 30,200,30);
		l1.setFont(new Font("Tahoma",Font.BOLD,20));
		add(l1);
		
		JLabel l2 =new JLabel("BED TYPE :-");
		l2.setBounds(100,80,100,30);
		add(l2);
		
		JLabel l3 =new JLabel("Room No");
		l3.setBounds(50,130,100,30);
		add(l3);
		
		
		JLabel l4 =new JLabel("Status");
		l4.setBounds(210,130,100,30);
		add(l4);
		
		JLabel l5 =new JLabel("Cleaning-st");
		l5.setBounds(370,130,100,30);
		add(l5);
		
		
		JLabel l6 =new JLabel("Price");
		l6.setBounds(530,130,100,30);
		add(l6);
		
		JLabel l7 =new JLabel("Bed Type");
		l7.setBounds(670,130,100,30);
		add(l7);
		
		String str[]= {"Single Bed","Double Bed"};
		cb1 = new JComboBox(str);
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
		new RoomInfo().setVisible(true);
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
					
					 str = "select * from rooms where bed_type='"+type+"' and available ='Available'";
				}
				else
				{
					str = "select * from rooms where bed_type='"+type+"'";

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
	


