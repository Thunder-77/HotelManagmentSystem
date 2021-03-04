package MyHotel;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import java.applet.*;


public class Login extends JFrame implements ActionListener {
	
	JLabel l1,l2;
	JTextField t1,t2;
	JButton b1,b2;
	
	Login(){
		
		 l1 = new JLabel("Username");
		 l1.setBounds(40,20,100,30);
		 add(l1);
		 
		 l2 = new JLabel("Password");
		 l2.setBounds(40,70,100,30);
		 add(l2);
		 
		 t1 =  new JTextField();
		 t1.setBounds(150,20,150,30);
		 add(t1);
		 
		 t2 = new JPasswordField();
		 t2.setBounds(150,70,150,30);
		 add(t2);
		 
		 b1 = new JButton("Login");
		 b1.addActionListener(this);
		 b1.setBackground(Color.black);
		 b1.setForeground(Color.white);
		 b1.setBounds(40,140,120,30);
		 add(b1);
		 
		 b2 = new JButton("Cancel");
		 b2.setBackground(Color.black);
		 b2.setForeground(Color.white);
		 b2.addActionListener(this);
		 b2.setBounds(180,140,120,30);
		 add(b2);
		 
		 ImageIcon i1 = new ImageIcon(this.getClass().getResource("/second.jpg"));
		 Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
		 ImageIcon i3 =new ImageIcon(i2);
		 JLabel l3 = new JLabel(i3);
		 l3.setBounds(350, 10,200, 200);
		 add(l3);
 
		 getContentPane().setBackground(Color.white);
		 
		 
		 
		 
		 
		 
		 setLayout(null);
		 setBounds(600,300,600,300);
		 setDefaultCloseOperation(3);
		 setVisible(true);
	}

	
	public static void main(String args[])
	{
		new Login(); 
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==b1)
		{
		String username =t1.getText();
		String password =t2.getText();
		conn c = new conn();
		
		String str ="select* from login where username = '"+username+"' and password = '"+password+"'";
		try {
			ResultSet r= c.s.executeQuery(str);
			
			if(r.next())
			{
				new Dashboard().setVisible(true);
				this.setVisible(false);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Invalid username or password");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		}
		else if(ae.getSource()==b2){
			System.exit(0);
			
		}
		
	}

}
