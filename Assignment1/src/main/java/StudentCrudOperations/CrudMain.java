package StudentCrudOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CrudMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/cdacassignments?useSSL=false&allowPublicKeyRetrieval=true","root","Sept22");
		
			
			sc = new Scanner(System.in);
			boolean flag =true;
			do {
				System.out.println("0 to exit");
				System.out.println("1 Insert record into students table");
				System.out.println("2 show records");
				System.out.println("3 to update data");
				System.out.println("4 to delete data");
				
				System.out.println("Enter your choice : ");
				byte choice = sc.nextByte();
				
				switch(choice)
				{
				case 0 : 
					flag = false;
					break;
				
				case 1 : 
					Insert.insertData();
					break;
				
				case 2 : 
					ShowStudents.showRecords();
					break;
				
				case 3 :
					UpdateRecords.updateStudent();
					break;
				
				case 4 : 
					DeleteStudent.deletRecord();
					break;

				default : 
					System.out.println("Enter Valid Choice");
				}
			}while(flag);
		
		
		
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("done...");
		
	}

}
