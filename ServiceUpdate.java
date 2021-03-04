package MyHotel;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ServiceUpdate extends JFrame {
	
	JButton b1,b2,b3,b4;
	ServiceUpdate()
	{
		b1 = new JButton("Update Room Cleaning Status");
		b1.setBounds(40,20,300,30);
		add(b1);
		
		b2 = new JButton("Update Driver Availabity Status");
		b2.setBounds(40,100,300,30);
		add(b2);
		
		b3 = new JButton("Food Status Update");
		b3.setBounds(40,180,300,30);
		add(b3);
		
		b4= new JButton("Other Issues to be noted");
		b4.setBounds(40,260,300,30);
		add(b4);
	
	
	
	
		
	setBounds(700,200,400,400);
	setLayout(null);
	setVisible(true);
	}
	
	public static void main(String args[])
	{
		new ServiceUpdate().setVisible(true);
	}
}
