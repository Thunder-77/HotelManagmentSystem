package MyHotel;

import java.awt.*;
import java.awt.event.*;
import java.text.*;


import javax.swing.*;
import javax.swing.border.Border;

public class HotelManagmentSystem extends JFrame implements ActionListener {


	HotelManagmentSystem(){
		//setBounds(300,300,400,400);
		setSize(1366,565);
		
		setLocation(300,300);
		
		//ImageIcon i1= new ImageIcon(this.getClass().getResource("/first.jpg"));
		//JLabel l1 =new JLabel(i1);
		//l1.setBounds(0,0,1366,565);
		//add(l1);
		
		JLabel l2 =new JLabel("Hotel Managment System");
		l2.setBounds(270,150,1000,200);
		l2.setForeground(Color.BLUE);
		Font f = new Font("Arial",Font.BOLD,70);
		l2.setFont(f);
		add(l2);
		
		JButton b1 =new JButton("Next");
		b1.setBackground(Color.white);
		b1.setForeground(Color.black);
		b1.setBounds(1030, 430, 150, 30);
		b1.addActionListener(this);
		add(b1);
		
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(3);
		while(true)
		{
			l2.setVisible(false);
			try {
				Thread.sleep(500);
			}
			catch(Exception e){
				
			}
			l2.setVisible(true);
			try {
				Thread.sleep(500);
			}
			catch(Exception e){
				
			}
			
		}
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		new Login().setVisible(true);
		this.setVisible(false);
	}
	
		
	
	
	public static void main(String args[])
	{
		new HotelManagmentSystem();
		
	}

}
 