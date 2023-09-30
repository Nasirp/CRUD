package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CrudOperation {
	

	public static void main(String[] args)  {
    Scanner sc = new Scanner(System.in);
    int choice;
      try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud_javs", "root", "");
		Statement st = con.createStatement();
		
		do {
			System.out.println("1. Insert value");
			System.out.println("2. Delete Value");
			System.out.println("3. Display Value");
			System.out.println("Enter your choice");
			choice=sc.nextInt();
			switch(choice) {
			case 1:
				st.executeUpdate("insert into information values(2,'sohail',22, 'sohail70@gmail.com')");
				System.out.println("successfully inserted");
				break;
			case 2:
				st.executeUpdate("delete from  information where id=1");
				System.out.println("successfully Deleted");
				break;
			case 3:
				ResultSet rs = st.executeQuery("select * from information");
				while(rs.next()) {
					
					System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getInt(3)+"\t\t"+rs.getString(4));
				}
				break;
			}
		} while(choice!=4);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      
    }


}
