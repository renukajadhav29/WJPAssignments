package StudentCrudOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Insert {
	
	protected static void insertData()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Student rollno : ");
		int rno=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Student Name : ");
		String name=sc.nextLine();
		System.out.println("Enter Marks : ");
		float marks=sc.nextFloat();
		System.out.println("Enter date of birth: ");
		String dob=sc.next();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdacassignments?useSSL=false","root","Sept22");
			Statement s = c.createStatement();
			int i = s.executeUpdate("insert into student values("+rno+",'"+name+"',"+marks+",'"+dob+"')");
			System.out.println(i+" row inserted");
			
			s.close();
			c.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}