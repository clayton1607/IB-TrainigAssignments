package thirdAssign;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class MyCon extends Thread{
	public void run() {
		Connection con=null;
		Statement stmt = null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
			
			stmt=con.createStatement();  
			rs=stmt.executeQuery("select custID,custName from customer");
			while(rs.next())  
				System.out.println(rs.getString(1)+"  "+rs.getString(2));
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		finally {
//			if (con!=null) {
//				con.close();
//				stmt.close();
//				try {
//					rs.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//				
//		}
	}
}
public class ConnectionLeak {
	public static void main(String[] args) {
		int n= 300;
		for (int i=0; i<n;i++) {
			MyCon mc= new MyCon();
			mc.start();
		}
				
	}
}
//com.mysql.jdbc.exceptions.MySQLNonTransientConnectionException: Data source rejected establishment of connection,  message from server: "Too many connections"
//	at com.mysql.jdbc.SQLError.createSQLException(SQLError.java:921)
//	at com.mysql.jdbc.MysqlIO.doHandshake(MysqlIO.java:1070)
//	at com.mysql.jdbc.Connection.createNewIO(Connection.java:2775)
//	at com.mysql.jdbc.Connection.<init>(Connection.java:1555)
//	at com.mysql.jdbc.NonRegisteringDriver.connect(NonRegisteringDriver.java:285)
//	at java.sql.DriverManager.getConnection(DriverManager.java:664)
//	at java.sql.DriverManager.getConnection(DriverManager.java:247)
//	at thirdAssign.MyCon.run(ConnectionLeak.java:19)
