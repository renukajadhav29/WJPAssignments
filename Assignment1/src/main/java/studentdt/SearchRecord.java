package studentdt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SearchRecord {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter rollno of student to see info of student : ");
		int rno = sc.nextInt();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdacassignments?useSSL=false","root","Sept22");
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from student where rno="+rno);
			
			if(rs.next())
			{
				rs.beforeFirst();
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getFloat(3)+"  "+rs.getString(4));
				}
			}
			else {
				System.out.println("Record not present");
			}
			
			s.close();
			con.close();
		} catch (ClassNotFoundException | SQLException  e) {
			e.printStackTrace();
		}
	}

}
