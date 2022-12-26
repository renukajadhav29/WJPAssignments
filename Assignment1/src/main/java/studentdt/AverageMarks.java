package studentdt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AverageMarks {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdacassignments?useSSL=false","root","Sept22");
			
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery("select avg(marks) from student");
			
			while(rs.next())
			{
				System.out.println("Average marks of students :	"+rs.getFloat(1));
			}
			
			s.close();
			c.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
