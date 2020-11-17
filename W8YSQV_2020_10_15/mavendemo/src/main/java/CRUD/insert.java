package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class insert {

	public static void main(String args[]){  
		try{  
			Scanner be = new Scanner(System.in);
			String name;
			String breed;
			int age;
			String owner;
			System.out.println("Kérem adja meg a macska nevét:");
			name=be.nextLine();
			System.out.println("Kérem adja meg a macska fajtáját:");
			breed=be.nextLine();
			System.out.println("Kérem adja meg a macska életkorát:");
			age=be.nextInt();
			System.out.println("Kérem adja meg a gazdája nevét:");
			owner=be.nextLine();
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/cats?serverTimezone=UTC","W8YSQV","password");  
			String sql="Insert into cats (`name`,`breed`,`age`,`owner`) Values (?,?,?,?);";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, breed);
			pstmt.setInt(3, age);
			pstmt.setString(4, owner);
			pstmt.executeUpdate();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from cats;");
			while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));  
			con.close();  
			}catch(Exception e){ System.out.println(e);}
	}
	
}
