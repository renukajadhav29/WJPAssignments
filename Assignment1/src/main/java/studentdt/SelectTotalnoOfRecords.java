package studentdt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTotalnoOfRecords {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdacassignments?useSSL=false","root","Sept22");
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select count(rno) from student");
			
			while(rs.next())
			{
				System.out.println("Total Records Present in table : "+rs.getInt(1));
			}
			
			s.close();
			con.close();
		} catch (ClassNotFoundException | SQLException  e) {
			e.printStackTrace();
		}
		
	}

}
