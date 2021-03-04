package MyHotel;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class UpdateCheck extends JFrame implements ActionListener {
	
	JButton b1,b2,b3;
	Choice c1;
	JTextField t1,t2,t3,t4,t5;
	
	UpdateCheck()
	{
		JLabel l1 = new JLabel("Check-in details");
		l1.setFont(new Font("Tahoma",Font.BOLD,20));
		l1.setForeground(Color.BLUE);
		l1.setBounds(50,30,200,30);
		add(l1);
		
		JLabel l2 = new JLabel("Customer-Id");
		l2.setBounds(30,80,100,20);
		add(l2);
		
		c1 =new Choice();
		try {
			conn c = new  conn();
			ResultSet rs = c.s.executeQuery("select * from customer");
			while(rs.next())
			{
				c1.add(rs.getString("number"));
			}
		}catch(Exception e)
		{
			
		}
		c1.setBounds(200,80, 150,25);
		add(c1);
		
		JLabel l3 = new JLabel("Room Number");
		l3.setBounds(30,120,100,20);
		add(l3);
		
		t1= new JTextField();
		t1.setBounds(200, 120, 150, 25);
		add(t1);
		
		JLabel l4 = new JLabel("Name");
		l4.setBounds(30,160,100,20);
		add(l4);
		
		t2= new JTextField();
		t2.setBounds(200, 160, 150, 25);
		add(t2);
		
		JLabel l5 = new JLabel("Check-in");
		l5.setBounds(30,200,100,20);
		add(l5);
		
		t3= new JTextField();
		t3.setBounds(200, 200, 150, 25);
		add(t3);
		
		JLabel l6 = new JLabel("Amount-Paid");
		l6.setBounds(30,240,100,20);
		add(l6);
		
		t4= new JTextField();
		t4.setBounds(200, 240, 150, 25);
		add(t4);
		
		JLabel l7 = new JLabel ("Pending-Money");
		l7.setBounds(30, 280,100,20);
		add(l7);
		
		t5= new JTextField();
		t5.setBounds(200, 280, 150, 25);
		add(t5);
		
		b1= new JButton("Check");
		b1.setBounds(30,340, 100,30);
		b1.addActionListener(this);
		add(b1);
		
		b2= new JButton("Update");
		b2.setBounds(150,340, 100,30);
		b2.addActionListener(this);
		add(b2);
		
		b3= new JButton("Cancel");
		b3.setBounds(270,340, 100,30);
		b3.addActionListener(this);
		add(b3);
		
		ImageIcon i1 = new ImageIcon(this.getClass().getResource("/nine.jpg"));
		JLabel l = new JLabel(i1);
		l.setBounds(400, 50, 500, 300);
		add(l);
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setBounds(500,200,1000,500);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1)
		{
			try {
				String room  =null;
				String deposite = null;
				String cost=null;
				int  wa = 0;
				conn c = new conn();
				String id = c1.getSelectedItem();
				String str = "select * from customer where number = '"+id+"'";
				ResultSet rs = c.s.executeQuery(str);
				while(rs.next())
				{
					t1.setText(rs.getString("room"));
					t2.setText(rs.getString("name"));
					t3.setText(rs.getString("status"));
					t4.setText(rs.getString("deposite"));
					room = rs.getString("room");
					deposite =rs.getString("deposite");
				}
				ResultSet rs2 =  c.s.executeQuery("select * from rooms where room_number ='"+room+"'");
				while(rs2.next())
				{
					cost = rs2.getString("price");
					wa =(Integer.parseInt(cost))-(Integer.parseInt(deposite));
					t5.setText(Integer.toString(wa));
				}
			
			}catch(Exception re)
			{
				System.out.println(re);
			}
		}
		else if(e.getSource()==b2)
		{
			
		}
		else if(e.getSource()==b3)
		{
			this.setVisible(false);
		}
		
	}
	
	public static void main(String args[])
	{
		new UpdateCheck().setVisible(true);
	}

}
