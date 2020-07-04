package studentFee;

import java.io.BufferedReader;

import java.io.IOException;
import java.sql.*;




public class Admin {
	public static void showMessage(String Message)
	{
		System.out.println(Message);
	}

	public void login(BufferedReader buff) throws Exception {
		// TODO Auto-generated method stub
		showMessage("enter the USERNAME");
		String user_name=buff.readLine();
		showMessage("enter your PASSWORD");
		String password=buff.readLine();
		showMessage("admin login successful\n");
		
		
	}

	public void addaccountant(BufferedReader buff, Connection mConnection) throws  Exception {
		// TODO Auto-generated method stub
		
		PreparedStatement stmtInsert = mConnection.prepareStatement("insert into accountant values(?,?,?,?)");
		showMessage("enter the name");
		stmtInsert.setString(1, buff.readLine());
		showMessage("enter the password");
		stmtInsert.setString(2, buff.readLine());
		showMessage("enter the email");
		stmtInsert.setString(3, buff.readLine());
		showMessage("enter the contact_number");
		stmtInsert.setString(4, buff.readLine());

		showMessage(stmtInsert.executeUpdate() + " No of Records Inserted");

		
	}

	public void viewaccountant(BufferedReader buff, Connection mConnection) throws Exception {
		// TODO Auto-generated method stub
		
		Statement stmt=mConnection.createStatement();
		ResultSet rs=stmt.executeQuery("select * from accountant");
		while(rs.next())
			showMessage(rs.getString(1)+ " " +rs.getString(2)+ " " +rs.getString(3)+ " "+rs.getString(4));
		mConnection.close();
	}

	public void logout(BufferedReader buff) throws Exception {
		// TODO Auto-generated method stub
		String continueChoice;
		boolean transaction=true;
		showMessage("Do you Want to logout\nlogout \nNo");
		continueChoice =buff.readLine();
		if(continueChoice.equalsIgnoreCase("logout"))
			transaction=false;
	}
}