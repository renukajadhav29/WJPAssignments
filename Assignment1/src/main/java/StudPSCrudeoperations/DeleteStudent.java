package StudPSCrudeoperations;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
			PreparedStatement ps = c.prepareStatement("delete from student where rno = ?");
			ps.setInt(1, rno);
			
			boolean i = ps.execute();
			System.out.println(i+"\n row deleted");
			ps.close();
			c.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}