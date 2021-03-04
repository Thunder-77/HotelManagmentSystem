package MyHotel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTextFieldUI;
import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;

public class AddCustomer extends JFrame implements ActionListener{
	
	JTextField f1,f2,f3,f4,f5;
	JComboBox b1;
	Choice c1;
	JRadioButton r1,r2;
	JButton bu1,bu2;
	
	AddCustomer()
	{
		JLabel l1 =new JLabel("NEW CUSTOMER FORM");
		l1.setBounds(100, 20, 300, 30);
		l1.setForeground(Color.BLUE);
		l1.setFont(new Font("Tahoma",Font.PLAIN, 20));
		add(l1);
		
		JLabel l2 =new JLabel("ID");
		l2.setBounds(35, 80, 100, 20);
		add(l2);
		
		String str[] = {"Passport","Driving Liscense","Addhar Card", "PanCard", "Voter-Id Card"};
		b1 = new JComboBox(str);
		b1.setBounds(150, 80, 150,20);
		add(b1);
		
		
		
		JLabel l3 =new JLabel("Number");
		l3.setBounds(35, 120, 100, 20);
		add(l3);
		
		f1 = new JTextField();
		f1.setBounds(150,120,150,20);
		add(f1);
		
		JLabel l4 =new JLabel("Name");
		l4.setBounds(35, 160, 100, 20);
		add(l4);
		
		f2 = new JTextField();
		f2.setBounds(150,160,150,20);
		add(f2);
		
		JLabel l5 =new JLabel("Gender");
		l5.setBounds(35, 200, 100, 20);
		add(l5);
		
		r1= new JRadioButton("Male");
		r1.setBounds(150,200,70,20);
		add(r1);
		
		r2 = new JRadioButton("Female");
		r2.setBounds(230,200,70,20);
		add(r2);
		
		JLabel l6 =new JLabel("Country");
		l6.setBounds(35, 240, 100, 20);
		add(l6);
		
		f3 = new JTextField();
		f3.setBounds(150,240,150,20);
		add(f3);
		
		JLabel l7 =new JLabel("Room Number");
		l7.setBounds(35, 280, 100, 20);
		add(l7);
		
		c1= new Choice();
		try {
			conn c = new conn();
			String st = "select * from rooms where available ='Available'";
			ResultSet rs =c.s.executeQuery(st);
			while(rs.next()) {
				c1.add(rs.getString("room_number"));
			}
		}catch (Exception e)
		{
			System.out.println(e);
		}
		c1.setBounds(150 ,280, 150,20);
		add(c1);
		
		
		JLabel l8 =new JLabel("Checked In");
		l8.setBounds(35, 320, 100, 20);
		add(l8);
		
		
		f4=new JTextField();
		f4.setBounds(150, 320, 150,20);
		add(f4);
			
		
		JLabel l9 =new JLabel("Deposite");
		l9.setBounds(35, 360, 100, 20);
		add(l9);
		

		f5=new JTextField();
		f5.setBounds(150, 360, 150,20);
		add(f5);
		
		bu1 = new JButton("Add Customer");
		bu1.setBounds(35, 410, 120,30);
		bu1.addActionListener(this);
		add(bu1);
		
		bu2 = new JButton("Cancel");
		bu2.setBounds(170, 410, 120,30);
		bu2.addActionListener(this);
		add(bu2);
		
		ImageIcon i1 = new ImageIcon(this.getClass().getResource("/fifth.png"));
		Image i2 = i1.getImage().getScaledInstance(300,400,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l = new JLabel(i3);
		l.setBounds(400, 50,300,400);
		add(l);
		
		setLayout(null);
		setBounds(550,200,800,550);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String id= (String)b1.getSelectedItem();
		String number= f1.getText();
		String name = f2.getText();
		String gender = null;
		if(r1.isSelected())
		{
			gender = "Male";
		}
		else if(r2.isSelected())
		{
			gender = "Female";
		}
		String country = f3.getText();
		String room = c1.getSelectedItem();
		
		String status =f4.getText();
		String deposit =f5.getText();
		
		// TODO Auto-generated method stub
		if(e.getSource() ==bu1)
		{
			try {
				conn c  = new conn();
				String str="insert into customer values('"+id +"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+status+"','"+deposit+"')";
				String str2="update rooms set available='Occupied'where room_number ='"+room+"'";
				c.s.executeUpdate(str2);
				c.s.executeUpdate(str);
				String cnf ="Room Succesfully booked for "+name+" ";
				JOptionPane.showMessageDialog(null,cnf);
			}catch(Exception ae)
			{
				System.out.println(ae);
			}
			
		}
		else
		{
			this.setVisible(false);
		}
	}
	
	public static void main( String args[])
	{
		new AddCustomer().setVisible(true);
	}

}
