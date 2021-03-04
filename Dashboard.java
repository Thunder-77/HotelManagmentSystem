package MyHotel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;

import javax.swing.*;;

public class Dashboard extends JFrame implements ActionListener {
	
	Font f = new Font("Arial",Font.BOLD,15);
	JMenuBar mb;
	JMenu m1,m2;
	JMenuItem i1,i2,i3,i5,i4;
	JButton b1,b2;
	Dashboard()
	{
		mb = new JMenuBar();
		
		mb.setBackground(Color.black);
		add(mb);
		
		m1 = new JMenu(" Hotel Managment");
		m1.setFont(f);
		m1.setForeground(Color.white);
		mb.add(m1);
		
		m2 = new JMenu("Admin");
		m2.setFont(f);
		m2.setForeground(Color.white);
		mb.add(m2);

		
		i1= new JMenuItem("Reception");
		i1.addActionListener(this);
		m1.add(i1);
		
		i5= new JMenuItem("Developed by");
		i5.addActionListener(this);
		m1.add(i5);
		
		
		
		i2= new JMenuItem("Add Employees");
		i2.addActionListener(this);
		m2.add(i2);
		
		i3= new JMenuItem("Add Rooms");
		i3.addActionListener(this);
		m2.add(i3);
		
		i4= new JMenuItem("Add Drivers");
		i4.addActionListener(this);
		m2.add(i4);
		
		mb.setBounds(0,0,1950,40);
		
		
		
		
		ImageIcon i1 = new ImageIcon(this.getClass().getResource("/third.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1950,1000,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i3);
		l1.setBounds(0,0, 1950, 1000);
		add(l1);
		
		JLabel l2 =new JLabel("KING'S LIFE WELCOMES YOU");
		l2.setBounds(750, 70, 600, 50);
		l2.setForeground(Color.white);
		l2.setFont(new Font("Arial",Font.BOLD,30));
		l1.add(l2);
		
		
		
		
		setLayout(null);
		setBounds(0,0,1950,1020);
		setVisible(true);
		
	}
	
	public static void main(String args[])
	{
		new Dashboard().setVisible(true);
			
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		
		if(ae.getActionCommand().equals("Reception"))
		{
			new Reception().setVisible(true);
		}
		else if(ae.getActionCommand().equals("Add Employees"))
			{
			new AddEmployee().setVisible(true);
			}
		else if(ae.getActionCommand().equals("Add Rooms"))
		{
			new AddRooms().setVisible(true);
		}
		else if(ae.getActionCommand().equals("Add Drivers"))
		{
			new AddDriver().setVisible(true);
		}
		else if(ae.getActionCommand().equals("Developed by"))
			{
				new details().setVisible(true);
			}
	}
	
	

}
