package MyHotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CheckOut extends JFrame implements ActionListener  {
	
	JLabel l1,l2;
	Choice c1;
	JTextField t1;
	JButton b1,b2,b3;
	
	CheckOut()
	{
		
		
		JLabel l1 =new JLabel ("Check out");
		l1.setFont(new Font("Tahoma",Font.PLAIN,20));
		l1.setBounds(30,20,100,30);
		l1.setForeground(Color.BLUE);
		add(l1);
		
		JLabel l2 =new JLabel ("Customer id");
		l2.setBounds(30,70,100,30);
		add(l2);
		
		c1 = new Choice();
		try {
			conn c = new conn();
			ResultSet rs =c.s.executeQuery("select * from customer");
			while(rs.next())
			{
				c1.add(rs.getString("number"));
			}
					
		}catch(Exception e)
		{
			System.out.println(e);
		}
		c1.setBounds(150,70, 150, 30);
		add(c1);
		
		JLabel l3 =new JLabel ("Room Number");
		l3.setBounds(30,110,100,30);
		add(l3);
		
		t1 = new JTextField();
		t1.setBounds(150, 110, 150,30);
		add(t1);
		
		b1 = new JButton("Checkout");
		b1.setBounds(30, 180, 100 ,30);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Back");
		b2.setBounds(180, 180, 100 ,30);
		b2.addActionListener(this);
		add(b2);
		ImageIcon i1 = new ImageIcon(this.getClass().getResource("/tick.png"));
		Image i2 = i1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		b3= new JButton(i3);
		b3.setBounds(310,70,20,20);
		b3.addActionListener(this);
		add(b3);
		
		
		ImageIcon i11 = new ImageIcon(this.getClass().getResource("/sixth.jpg"));
		Image i22 = i11.getImage().getScaledInstance(400,250,Image.SCALE_DEFAULT);
		ImageIcon i33 = new ImageIcon(i22);
		JLabel l22 = new JLabel(i33);
		l22.setBounds(350, 10, 400, 250);
		add(l22);
		
		setLayout(null);
		setBounds(500,200,800,320);
		setVisible(true);
		
	}
	
	public static void main(String argd[])
	{
		new CheckOut().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String room_no= null;
		String s =c1.getSelectedItem();
		int price=0;
		
		// TODO Auto-generated method stub
		if(e.getSource()==b1)
		{
			String str ="select * from customer where number='"+s+"'";
			conn c = new conn();
			try {
				ResultSet rs = c.s.executeQuery(str);
				while(rs.next())
				{
					t1.setText(rs.getString("room"));
					room_no = rs.getString("room");
				}
				
				String st2 ="update customer set status='CO' where number ='"+s+"'";
				c.s.executeQuery(st2);
				
				String st= "update rooms set available='Available', status ='Not Cleaned' where room_number ='"+room_no+"'";
				c.s.executeQuery(st);
				
			}catch (Exception ae)
			{
				System.out.println(ae);
			}
			JOptionPane.showMessageDialog(null,"Sucessfully checked out");
		}
		else if(e.getSource()==b2)
		{
			this.setVisible(false);
		}
		else if(e.getSource()==b3)
		{
			
			conn c =new conn();
			try {
				String str = "select * from customer where number='"+s+"'";
				ResultSet rs = c.s.executeQuery(str);
				while(rs.next())
				{
					t1.setText(rs.getString("room"));
				}
			}catch(Exception ae)
			{
				System.out.println(ae);
			}
		}
		
	}

}
