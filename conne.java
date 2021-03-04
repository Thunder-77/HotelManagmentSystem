package MyHotel;
import java.sql.*;

public class conne {
	
	private final String url= "jdbc:postgresql://localhost:5432/HotelManagment";
	private final String user = "postgres";
	private final String password ="Subhranta77";
	
	private void connect(){
		
		Connection connection;
		
		try
		{
			Class.forName("org.postgresql.Driver");
			connection= DriverManager.getConnection(url,user,password);
			if(connection != null)
			{
				System.out.println("Successfully connected to data bases");
			}
			else {
				System.out.println("data bases not connected");
			}
		}
		catch(Exception ae){
			ae.printStackTrace();
			
		}
		
	}
	
	public static void main(String args[])
	{
		conne sqlconnect = new conne();
		sqlconnect.connect();
	}
	

}
