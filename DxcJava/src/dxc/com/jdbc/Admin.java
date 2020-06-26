package dxc.com.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Admin 
{
	public void login(BufferedReader buff) 
	{
		try 
		{
		   System.out.println("enter username");
			String name=buff.readLine();
			System.out.println("enter password");
			
			
			
			String pswrd=buff.readLine();
			if(name.equals("Admin")&&pswrd.equals("admin123"))
			{
				System.out.println("sucessfully logged in");
			}
			else
			{
				System.out.println("invalid username and password");
			}
		}
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
	}
	public void addaccountant(BufferedReader buff) throws  Exception {

		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/FeeDB", "root", "Harindradevi@1996");
		
		PreparedStatement stmtInsert = con.prepareStatement("insert into accountant values(?,?,?,?)");
		System.out.println("enter the name");
		stmtInsert.setString(1, buff.readLine());
		System.out.println("enter the password");
		stmtInsert.setString(2, buff.readLine());
		System.out.println("enter the email");
		stmtInsert.setString(3, buff.readLine());
		System.out.println("enter the contact_number");
		stmtInsert.setString(4, buff.readLine());

		System.out.println(stmtInsert.executeUpdate() + " No of Records Inserted");

		
	}
	public void viewaccountant(BufferedReader buff) throws Exception 
	{

		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/FeeDB", "root", "Harindradevi@1996");
		
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from accountant");
		while(rs.next())
			System.out.println(rs.getString(1)+ " " +rs.getString(2)+ " " +rs.getString(3)+ " "+rs.getString(4));
		con.close();
	}

}