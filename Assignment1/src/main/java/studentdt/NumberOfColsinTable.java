package studentdt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class NumberOfColsinTable {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdacassignments?useSSL=false","root","Sept22");
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from student");
			
			ResultSetMetaData rsmd = rs.getMetaData();
			
			int colcount = rsmd.getColumnCount();
			
			System.out.println("Total number of columns in student table is : "+colcount);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
