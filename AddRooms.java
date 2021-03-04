package MyHotel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AddRooms extends JFrame implements ActionListener {
	
	
	JTextField t1,t2;
	JComboBox c1,c2,c3;
	JButton b1,b2;
	
	AddRooms()
	{
		
		
		JLabel l1 =new JLabel("Add Rooms");
		l1.setFont(new Font("Tahoma",Font.BOLD,18));
		l1.setBounds(200,20,100,20);
		add(l1);
		
		JLabel room = new JLabel("Room Number");
		room.setFont(new Font("Tahoma",Font.PLAIN,16));
		room.setBounds(60,80,120,30);
		add(room);
		
		t1 = new JTextField();
		t1.setBounds(200, 80, 120,30);
		add(t1);
		
		JLabel available = new JLabel("Available");
		available.setFont(new Font("Tahoma",Font.PLAIN,16));
		available.setBounds(60,130,120,30);
		add(available);
		
		c1= new JComboBox(new String[] {"Available" , "Occupaied"});
		c1.setBounds(200, 130, 120,30);
		add(c1);
		
		
		
		JLabel status = new JLabel("Cleaning Status");
		status.setFont(new Font("Tahoma",Font.PLAIN,16));
		status.setBounds(60,180,120,30);
		
		add(status);
		
		c2= new JComboBox(new String[] {"Cleaned" , "Not Cleaned"});
		c2.setBounds(200, 180, 120,30);
		add(c2);
		
		
		
		JLabel price = new JLabel("Price");
		price.setFont(new Font("Tahoma",Font.PLAIN,16));
		price.setBounds(60,230,120,30);
		add(price);
		
		t2 = new JTextField();
		t2.setBounds(200, 230, 120,30);
		add(t2);
		
		
		
		JLabel type = new JLabel("Bed Type");
		type.setFont(new Font("Tahoma",Font.PLAIN,16));
		type.setBounds(60,280,120,30);
		add(type);
		
		c3= new JComboBox(new String[] {"Single Bed" , "Double Bed"});
		c3.setBounds(200, 280, 120,30);
		add(c3);
		
		b1 =new JButton("Add Rooms");
		b1.setBounds(60,330, 120, 30);
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.addActionListener(this);
		add(b1);
		
		b2 =new JButton("Cancel");
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.setBounds(200,330, 120, 30);
		b2.addActionListener(this);
		add(b2);
		
		ImageIcon i1 = new ImageIcon(this.getClass().getResource("/twelve.jpg"));
		
		JLabel l = new JLabel(i1);
		l.setBounds(400, 30, 500, 350);
		add(l);
		
		setForeground(Color.WHITE);
		setBounds(450,200,950,470);
		
		setLayout(null);
		setVisible(true);
		
		
		
	}
	
	public static void main(String args[])
	{
		new AddRooms().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == b1)
		{
			String roomno =t1.getText();
			String available = (String)c1.getSelectedItem();
			String status = (String)c2.getSelectedItem();
			String price = t2.getText();
			String type =(String)c3.getSelectedItem();
			
			conn c =new conn();
			String str="insert into rooms values('"+roomno+"','"+available+"','"+status+"','"+price+"','"+type+"')";
			try {
				c.s.executeUpdate(str);
				JOptionPane.showMessageDialog(null,"New room Added");
				this.setVisible(false);
				
			}catch(Exception e1)
			{
				System.out.println(e1);
				
			}
			
			
		}
		
		if(e.getSource() == b2)
		{
			this.setVisible(false);
		}
		
	}

}
