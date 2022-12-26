package StudPSCrudeoperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateRecords {
	protected static void updateStudent()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Emter the rollno of student which you want to update : ");
		int rno=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter name : ");
		String name=sc.nextLine();
		System.out.println("Enter marks : ");
		float marks=sc.nextFloat();
		sc.nextLine();
		System.out.println("Enter date of birth name: ");
		String dob=sc.nextLine();
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdacassignments?useSSL=false","root","Sept22");
			PreparedStatement ps = c.prepareStatement("update student set name=?,marks=?,dateofbirth=? where rno =?");
			
			ps.setString(1, name);
			ps.setFloat(2, marks);
			ps.setString(3, dob);
			ps.setInt(4, rno);
			
			int i = ps.executeUpdate();
			System.out.println(i+"row updated");
			
			ps.close();
			c.close();
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
}
