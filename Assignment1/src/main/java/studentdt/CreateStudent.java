package studentdt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateStudent {

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdacassignments?useSSL=false","root","Sept22");
			Statement stmt = con.createStatement();
			
			boolean flag = stmt.execute("create table student(rno int,name varchar(30),marks float(10,2),dateofbirth varchar(25))");
			System.out.println(flag);
			
			stmt.close();
			con.close();
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		System.out.println("Table created...");
	}

}
