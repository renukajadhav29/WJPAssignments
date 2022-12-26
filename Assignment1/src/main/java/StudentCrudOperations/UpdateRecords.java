package StudentCrudOperations;

import java.sql.Connection;
import java.sql.DriverManager;
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
			Statement s = c.createStatement();
			int i = s.executeUpdate("update student set name='"+name+"', marks="+marks+",dateofbirth='"+dob+"' where rno = "+rno);
			System.out.println(i+" row updated");
			s.close();
			c.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
