package CRUD;

import java.sql.*;

public class Select {
	
	public static void main(String args[]){  
		try{  
		Class.forName("com.mysql.cj.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/cats?serverTimezone=UTC","W8YSQV","password");  
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from cats");  
		while(rs.next())  
		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));  
		con.close();  
		}catch(Exception e){ System.out.println(e);}  
		
		System.out.println("\n");
		
		try{ 
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/cats?serverTimezone=UTC","W8YSQV","password");  
		con.setAutoCommit(false);
		PreparedStatement pstmt = con.prepareStatement("Select * from cats where age>?");
		pstmt.setInt(1, 1);
		ResultSet rs = pstmt.executeQuery();
		con.commit();
		while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));  
			con.close();
		}catch(Exception e){ System.out.println(e);}
		
		System.out.println("\n");
		
		try{ 
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/cats?serverTimezone=UTC","W8YSQV","password");  
			con.setAutoCommit(false);
			PreparedStatement pstmt = con.prepareStatement("Select * from cats where age>?");
			pstmt.setInt(1, 5);
			ResultSet rs = pstmt.executeQuery();
			con.commit();
			while(rs.next())  
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));  
				con.close();
			}catch(Exception e){ System.out.println(e);}
	}  
}
