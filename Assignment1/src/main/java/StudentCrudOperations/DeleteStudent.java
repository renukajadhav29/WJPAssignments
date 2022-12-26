package StudentCrudOperations;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteStudent {
	
	protected static void deletRecord()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter rollno of student to delete record :");
		int rno=sc.nextInt();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdacassignments?useSSL=false","root","Sept22");
			Statement s = c.createStatement();
			int i = s.executeUpdate("delete from student where rno = "+rno);
			System.out.println(i+" row deleted");
			s.close();
			c.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}