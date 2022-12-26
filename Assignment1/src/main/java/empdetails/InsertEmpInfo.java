package empdetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Set;

public class InsertEmpInfo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdacassignments?useSSL=false","root","Sept22");
			
			c.setAutoCommit(false);
			
			PreparedStatement ps = c.prepareStatement("insert into employeeinfo values(?,?,?,?)");
			
			System.out.println("Enter empid : ");
			int id = sc.nextInt();
			
			sc.nextLine();
			System.out.println("Enter name : ");
			String name = sc.nextLine();
			
			System.out.println("Enter salary : ");
			float salary = sc.nextFloat();
			
			System.out.println("Enter joining date : ");
			String j_date = sc.next();
			
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setFloat(3, salary);
			ps.setString(4, j_date);
			int j = executeUpdate();
			
			
			ps = c.prepareStatement("insert into empaddress values(?,?,?,?)");
			
			System.out.println("Enter Address id : ");
			String aid = sc.next();
		
			System.out.println("Enter city : ");
			String city = sc.next();
			
			System.out.println("Enter country : ");
			String country = sc.next();
			
			System.out.println("Enter Employee id : ");
			int eid = sc.nextInt();
			
			ps.setString(1, aid);
			ps.setString(2, city);
			ps.setString(3, country);
			ps.setInt(4, eid);
			
			int i = ps.executeUpdate();
			
			if(i == 1 && j == 1)
			{
				c.commit();
				System.out.print("Commited");
			}
			else
			{
				c.rollback();
				System.out.println("Rollback");
			}
			
			
			ps.close();
			c.close();
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}

	private static int executeUpdate() {
		// TODO Auto-generated method stub
		return 0;
	}

}
