package MyHotel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class details extends JFrame {
	
	details()
	{
		
	JLabel l1 =new JLabel("Developed By:-");
	l1.setFont(new Font("Tahoma",Font.BOLD,20));
	l1.setForeground(Color.BLUE);
	l1.setBounds(30, 30, 200,30);
	add(l1);
	
	JLabel l2 =new JLabel("SUBHRANTA");
	l2.setFont(new Font("Tahoma",Font.BOLD,20));
	l2.setForeground(Color.BLUE);
	l2.setBounds(200, 30, 250,30);
	add(l2);
	
	JLabel l3 =new JLabel("THANK YOU");
	l3.setBounds(270,150,500,200);
	l3.setForeground(Color.BLUE);
	Font f = new Font("Arial",Font.BOLD,70);
	l3.setFont(f);
	add(l3);
	
	setBounds(500,250,900,400);
	setLayout(null);
	setVisible(true);
	
	while(true)
	{
		l3.setVisible(false);
		try {
			Thread.sleep(500);
		}
		catch(Exception e){
			
		}
		l3.setVisible(true);
		try {
			Thread.sleep(500);
		}
		catch(Exception e){
			
		}
		
	}
	}
	
	public static void main(String args[])
	{
		new details().setVisible(true);
	}

}
