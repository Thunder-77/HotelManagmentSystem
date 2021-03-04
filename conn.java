package MyHotel;

import java.sql.*;

public class conn {
	
	Connection c;
	Statement s;
	
	public conn(){
		
		try {
			Class.forName("org.postgresql.Driver");
			c= DriverManager.getConnection("jdbc:postgresql://localhost:5432/HotelManagment","postgres","Subhranta77");
			s= c.createStatement();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	

}
