package MyHotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateRoom extends JFrame implements ActionListener  {
	
	Choice c1;
	JTextField t1,t2,t3;
	JButton b1,b2,b3;
	UpdateRoom()
	{
		JLabel l1= new JLabel("Update Room Status");
		l1.setFont(new Font("Tahoma",Font.BOLD,20));
		l1.setForeground(Color.BLUE);
		l1.setBounds(30, 20, 250,30);
		add(l1);
		
		JLabel l2= new JLabel("Guest ID");
		l2.setBounds(30, 90, 120,20);
		add(l2);
		
		c1 = new Choice();
		try {
			conn c = new conn();
			ResultSet rs = c.s.executeQuery("select * from customer");
			while(rs.next())
			{
				c1.add(rs.getString("number"));
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}
		c1.setBounds(200,80,150,25);
		add(c1);
		
		JLabel l3= new JLabel("Room Nos");
		l3.setBounds(30, 140, 120,20);
		add(l3);
		
		t1 = new JTextField();
		t1.setBounds(200,140,150,20);
		add(t1);
		
		JLabel l4= new JLabel("Availability");
		l4.setBounds(30, 190, 120,20);
		add(l4);
		
		t2 = new JTextField();
		t2.setBounds(200,190,150,20);
		add(t2);
		
		JLabel l5= new JLabel("Cleaning Status");
		l5.setBounds(30, 240, 120,20);
		add(l5);
		
		t3 = new JTextField();
		t3.setBounds(200,240,150,20);
		add(t3);
		
		b1 = new JButton("Check");
		b1.setBounds(110, 300 ,120,30);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Update");
		b2.setBounds(110, 350 ,120,30);
		b2.addActionListener(this);
		add(b2);
		
		b3 = new JButton("Back");
		b3.setBounds(110, 400 ,120,30);
		b3.addActionListener(this);
		add(b3);
		
		
		ImageIcon i1 = new ImageIcon(this.getClass().getResource("/seventh.jpg"));
		Image i2 = i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l = new JLabel(i3);
		l.setBounds(400, 10,500,400);
		add(l);
		
		setLayout(null);
		setBounds(500,200,980,500);
		setVisible(true);
	}
	
	public static void main(String args[])
	{
		new UpdateRoom().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== b1)
		{
			String room = null;
			String s1 = c1.getSelectedItem();
			conn c=  new conn();
			try {
				ResultSet rs= c.s.executeQuery("select * from customer where number ='"+s1+"'");
				
				while(rs.next())
				{
					t1.setText(rs.getString("room"));
					
					
					room =rs.getString("room");
				}
				ResultSet rs2= c.s.executeQuery("select * from rooms where room_number ='"+room+"'");
				while(rs2.next())
				{
					t2.setText(rs2.getString("available"));
					t3.setText(rs2.getString("status"));
				}
				
			}catch(Exception ae)
			{
				
				
			}
			
		}
		else if(e.getSource() == b2)  
		{
			try {
				conn c= new conn();
				String room = t1.getText();
				String available= t2.getText();
				String status = t3.getText();
				
				String str = "update rooms set available ='"+available+"', status= '"+status+"' where  room ='"+room+"'";
				
				c.s.executeQuery(str);
				JOptionPane.showMessageDialog(null,"Updated Successfully");
			}catch(Exception ae)
			{
				System.out.println(e);
			}
			
		}
		else if(e.getSource() == b3)
		{
			this.setVisible(false);
		}
	}

}
