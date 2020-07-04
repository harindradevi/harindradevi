package studentFee;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


class userClass<T> { 
	T obj;

	void create(T obj) { 
		this.obj = obj;
	}

	T getInstance() { 
		return obj;
	}

	
	
}

public class Feemanagement {
	
	Connection mConnectionObject;
	public Connection getInstance() throws Exception {
		if(mConnectionObject==null)
		{
			mConnectionObject=DriverManager.getConnection("jdbc:mysql://localhost:3306/accountant?serverTimezone=UTC", "root", "Harindradevi@1996"
					);
			return mConnectionObject;
		}
		else
			return mConnectionObject;
		}


	InputStreamReader isr = null;
	BufferedReader buff = null;
	Admin mAdmin = null;
	Accountantsection mAccountantsection=null;
	
	String userchoice;
	String clientchoice;
	public static void showMessage(String Message)
	{
		System.out.println(Message);
	}
	
	
	

	public static void main(String[] args) throws Exception {

		Feemanagement mFMObject = new Feemanagement();

		mFMObject.isr = new InputStreamReader(System.in);
		mFMObject.buff = new BufferedReader(mFMObject.isr);
	
		
		
		String continueChoice;
		boolean transaction=true;
		boolean repeat=true;
		
			do {
				
			showMessage("Welcome to FEES MANAGEMENT SYSTEM\n");
			showMessage("SELECT your USER  choice\n1.Admin\n2.Accountant Section\n");
			String muserchoice = mFMObject.buff.readLine();

			
			switch (Integer.parseInt(muserchoice)) {
			case 1:
				userClass<Admin> obj = new userClass<Admin>();
				obj.create(new Admin());
				mFMObject.mAdmin = obj.getInstance();
				
				showMessage(" Admin login PAGE\n");
				do{
					mFMObject.mAdmin.login(mFMObject.buff);
					showMessage("ADMIN SECTION\n");
					showMessage("select your section\n 1.ADD ACCOUNTANT \n 2.VIEW ACCOUNTANT \n 3.LOGOUT");
				String clientchoice=mFMObject.buff.readLine();
				
				switch(Integer.parseInt(clientchoice)) {
				case 1: mFMObject.mAdmin.addaccountant(mFMObject.buff,mFMObject.getInstance());
				break;
				case 2: mFMObject.mAdmin.viewaccountant(mFMObject.buff,mFMObject.getInstance());
				break;
				case 3: mFMObject.mAdmin.logout(mFMObject.buff);
				break;
				default:
					showMessage("task is not performed");
				
				}showMessage("Do you Want to Continue\nYes\nNo");
				continueChoice = mFMObject.buff.readLine();
				if (continueChoice.equalsIgnoreCase("No"))
					transaction = false;
				}while(transaction);
				break;
				
			case 2:
				userClass<Accountantsection> obj1=new userClass<Accountantsection>();
				obj1.create(new Accountantsection());
				mFMObject.mAccountantsection=obj1.getInstance();
				do {
					showMessage("select your choice\n 1.ADD STUDENT \n 2.VIEW STUDENT \n 3.EDIT STUDENT \n 4.DUE FESS \n 5.LOGOUT");
				String clientchoice1=mFMObject.buff.readLine();
				
				switch(Integer.parseInt(clientchoice1)) {
					case 1: mFMObject.mAccountantsection.addstudent(mFMObject.buff,mFMObject.getInstance());
					break;
					case 2: mFMObject.mAccountantsection.viewstudent(mFMObject.buff,mFMObject.getInstance());
					break;
					case 3: mFMObject.mAccountantsection.editstudent(mFMObject.buff,mFMObject.getInstance());
					break;
					case 4: mFMObject.mAccountantsection.dueefees(mFMObject.buff,mFMObject.getInstance());
					break;
					case 5: mFMObject.mAccountantsection.logout(mFMObject.buff);
					break;
					default: showMessage("task not completed");
				}System.out.println("Do you Want to Continue\nYes\nNo");
				continueChoice = mFMObject.buff.readLine();
				if (continueChoice.equalsIgnoreCase("No"))
					transaction = false;
					
				}while(transaction);
				break;
				default: showMessage("select atleast one task\n");
			}showMessage("Do you Want to End feemanagement\nYes\nNo");
			 mFMObject.userchoice = mFMObject.buff.readLine();
			if (mFMObject.userchoice.equalsIgnoreCase("yes"))
				repeat = false;
			}while(repeat);
			
			showMessage("****THANK YOU****");
	}
}