package MyHotel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Room  extends JFrame implements ActionListener{
	
	JTable t1;
	JButton b1,b2;
	Room()
	{
		t1=new JTable();
		t1.setBounds(0, 40, 500, 400);
		add(t1);
		
		b1= new JButton("Load data");
		b1.setBounds(100,460,120,30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		add(b1);
		
		b2 =new JButton("Back");
		b2.setBounds(300,460,120,30);
		b2.setBackground(Color.WHITE);
		b2.setForeground(Color.BLACK);
		b2.addActionListener(this);
		add(b2);
		
		JLabel l =new JLabel ("Room no");
		l.setBounds(20,10,70,20);
		add(l);
		
		JLabel l2 =new JLabel ("Status");
		l2.setBounds(125,10,70,20);
		add(l2);
		
		JLabel l3 =new JLabel ("Cl.Status");
		l3.setBounds(220,10,70,20);
		add(l3);
		
		JLabel l4 =new JLabel ("Price");
		l4.setBounds(335,10,70,20);
		add(l4);
		
		JLabel l5 =new JLabel ("Type");
		l5.setBounds(420,10,70,20);
		add(l5);
		
		
		ImageIcon i1 = new ImageIcon(this.getClass().getResource("/eight.jpg"));
		Image i2 = i1.getImage().getScaledInstance(600,600, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2); 
		JLabel l1 = new JLabel(i3);
		l1.setBounds(500,0,550, 590);
		add(l1);
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setVisible(true);
		setBounds(450,200,1100,600);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1)
		{
			try
			{
				conn c = new conn();
				String str ="select * from rooms";
				ResultSet rs = c.s.executeQuery(str);
				t1.setModel(DbUtils.resultSetToTableModel(rs));
			}catch(Exception ae)
			{
				System.out.print(ae);
				
			}
			
		}
		else if(e.getSource()==b2)
		{
			this.setVisible(false);
		}
		
	}
	
	public static void main(String args[])
	{
		new Room().setVisible(true);

	}

}
