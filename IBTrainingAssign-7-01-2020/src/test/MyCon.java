package test;
import java.sql.*;
public class MyCon {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from users");  
			while(rs.next())  
				System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
				con.close();  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
