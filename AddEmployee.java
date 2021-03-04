package MyHotel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;

public class AddEmployee extends JFrame implements ActionListener {
	
	JTextField t1,t2,t3,t4,t5,t6,t7,t8;
	JRadioButton r1,r2;
	JComboBox c1,c2;
	JButton b1;
	
	
	AddEmployee()
	{
		JLabel name =new JLabel("Name");
		name.setFont(new Font("Tahoma",Font.PLAIN,17));
		name.setBounds(60,30,120,30);
		add(name);
		
		t1= new JTextField();
		t1.setBounds(200,30,150,30);
		add(t1);
		
		
		
		JLabel age =new JLabel("Age");
		age.setFont(new Font("Tahoma",Font.PLAIN,17));
		age.setBounds(60,80,120,30);
		add(age);
		
		t2= new JTextField();
		t2.setBounds(200,80,150,30);
		add(t2);
		
		
		
		JLabel Gender =new JLabel("Gender");
		Gender.setFont(new Font("Tahoma",Font.PLAIN,17));
		Gender.setBounds(60,130,120,30);
		add(Gender);
		
		r1 = new JRadioButton("Male");
		r1.setBounds(200,130,70,30);
		r1.setBackground(Color.white);
		r1.setFont(new Font("Thoma",Font.BOLD,15));
		r2 = new JRadioButton("Female");
		r2.setBackground(Color.white);
		r2.setFont(new Font("Thoma",Font.BOLD,15));
		r2.setBounds(280,130,80,30);
		add(r1);
		add(r2);
		
		
		
		
		JLabel job =new JLabel("Job");
		job.setFont(new Font("Tahoma",Font.PLAIN,17));
		job.setBounds(60,180,120,30);
		add(job);
		
		String str[] = {"Front Desk clearks","Porters","Housekeeping","Kitchen staff","Room Services","Waiters","Bartenders","Managers","Accountants"};
		c1 = new JComboBox(str);
		c1.setBackground(Color.white);
		c1.setBounds(200, 180, 150, 30);
		add(c1);
		
		
		
		
		JLabel salary =new JLabel("Salary");
		salary.setFont(new Font("Tahoma",Font.PLAIN,17));
		salary.setBounds(60,230,120,30);
		add(salary);
		
		t5= new JTextField();
		t5.setBounds(200,230,150,30);
		add(t5);
		
		
		
		
		JLabel phone =new JLabel("Phone");
		phone.setFont(new Font("Tahoma",Font.PLAIN,17));
		phone.setBounds(60,280,120,30);
		add(phone);
		
		t6= new JTextField();
		t6.setBounds(200,280,150,30);
		add(t6);
		
		
		
		JLabel adhar =new JLabel("Aadhar ");
		adhar.setFont(new Font("Tahoma",Font.PLAIN,17));
		adhar.setBounds(60,330,120,30);
		add(adhar);
		
		t7= new JTextField();
		t7.setBounds(200,330,150,30);
		add(t7);
		
		
		
		JLabel email =new JLabel("Email");
		email.setFont(new Font("Tahoma",Font.PLAIN,17));
		email.setBounds(60,380,120,30);
		add(email);
		
		t8= new JTextField();
		t8.setBounds(200,380,150,30);
		add(t8);
		
		
		ImageIcon i1 = new ImageIcon(this.getClass().getResource("/tenth.jpg"));
		Image i2 = i1.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i3);
		l1.setBounds(400, 70, 500, 400);
		add(l1);
		
		JLabel  l2 = new JLabel ("Add Employee details");
		l2.setForeground(Color.blue);
		l2.setBounds(500,30, 300,30);
		l2.setFont(new Font("Tahoma",Font.PLAIN,30));
		add(l2);
		    
		b1= new JButton("Submit");
		b1.setBounds(100, 430, 150,30);
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.addActionListener(this);
		add(b1);
		
		getContentPane().setBackground(Color.white);
		setLayout(null);
		setBounds(400,200,900,520);
	}
	
	public static void main(String args[])
	{
		 new AddEmployee().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String name = t1.getText();
		String age = t2.getText();
		String salary = t5.getText();
		String phone = t6.getText();
		String adhar = t7.getText();
		String email = t8.getText();
		
		String gender =null;
		if(r1.isSelected())
		{
			gender ="Male";
		}
		else if(r1.isSelected())
		{
			gender = "Female";
		}

		
		String job = (String)c1.getSelectedItem();
		conn c =new conn();
		
		String str="insert into employee values('"+name +"','"+age +"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+adhar+"','"+email+"')";
		try {
			c.s.executeUpdate(str);
			JOptionPane.showMessageDialog(null,"New employee Added");
			this.setVisible(false);
			
		}catch(Exception e1)
		{
			System.out.println(e1);
			
		}
	}
	
		
		// TODO Auto-generated method stub
		
	}
	
	


