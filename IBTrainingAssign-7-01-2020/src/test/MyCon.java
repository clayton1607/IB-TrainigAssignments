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
			ResultSet rs=stmt.executeQuery("select custID,custName from customer");  
			while(rs.next())  
				System.out.println(rs.getString(1)+"  "+rs.getString(2));
			
			PreparedStatement pstmt = con.prepareStatement("insert into orders Values(?,?,?,?)");
			pstmt.setInt(1, 108);
			pstmt.setInt(2, 32);
			pstmt.setDate(3,java.sql.Date.valueOf("2020-01-04"));
			pstmt.setInt(4,45);
			
			pstmt.executeUpdate();
			
			pstmt= con.prepareStatement("SELECT custID,orderID,orderDate,orderQty from orders");
			rs= pstmt.executeQuery();
			ResultSetMetaData rsmd= rs.getMetaData();
			
			System.out.println("Total columns: "+rsmd.getColumnCount());  
			System.out.println("Column Name of 1st column: "+rsmd.getColumnName(1));  
			System.out.println("Column Type Name of 1st column: "+rsmd.getColumnTypeName(1));  
			  
			
			CallableStatement callstmt=con.prepareCall("{call insertIntoOrders(?,?,?,?)}");  			
			callstmt.setInt(1,108);  
			callstmt.setInt(2,34);  
			callstmt.setDate(3,java.sql.Date.valueOf("2020-01-04"));
			callstmt.setInt(4,35);
			callstmt.execute(); 
			
			DatabaseMetaData dbmd=con.getMetaData();  
			  
			System.out.println("Driver Name: "+dbmd.getDriverName());  
			System.out.println("Driver Version: "+dbmd.getDriverVersion());  
			System.out.println("UserName: "+dbmd.getUserName());  
			System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());  
			System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());  
			  
			con.setAutoCommit(false);  
			    
			stmt.addBatch("insert into customer values(109,'abhi')");  
			stmt.addBatch("insert into customer values(110,'umesh')");  
			  
			stmt.executeBatch();//executing the batch  
			  
			con.commit();  
			con.close();  
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
