package bankingApplication;

import java.io.BufferedReader;

public class AXIS implements RBI
{
	public int ROI=7;
	public int MIN_FD_AMOUNT=8000;
	public int min_years=7;
	public int BAL=MIN_BAL;
	
	@Override
	public void openAccount(BufferedReader buff) 
	{
		try
		{
			System.out.println("Enter your name");
			String name=buff.readLine();
			System.out.println("Enter your Email");
			String Email=buff.readLine();
			System.out.println("Enter your phone");
			String phone=buff.readLine();
			
			System.out.println("congratulations your account is opend");
			System.out.println("your Details are \nName: "+name+"\nEmail: "+Email+"\nPhone: "+phone);
		}
		catch(Exception e) {
			System.out.println("Exception is "+e);
		}
	}

	@Override
	public void deposit(BufferedReader buff) {
		try {
			System.out.println("Enter the amount to be deposited");
			String amount = buff.readLine();
			BAL = BAL + Integer.parseInt(amount);
			System.out.println("Balance is "+BAL);
		}
		catch(Exception e) {
			System.out.println("Exception is "+e);
		}
	}

	@Override
	public void withdrawl(BufferedReader buff) {
		try {
			System.out.println("Enter the amount to be Withdrawl");
			String amount = buff.readLine();
			if(BAL - Integer.parseInt(amount) > MIN_BAL)
				BAL = BAL - Integer.parseInt(amount);
			else
				System.out.println("MIN BAL is not maintained after withdrawl !!");
			System.out.println("Balance is "+BAL);
		}
		catch(Exception e) {
			System.out.println("Exception is "+e);
		}
	}

	@Override
	public void openFD(BufferedReader buff) {
		try {
			System.out.println("Enter your FD amount");
			String fdamount = buff.readLine();
			System.out.println("Enter Term Duration of FD");
			String years = buff.readLine();
			if(Integer.parseInt(fdamount) > MIN_FD_AMOUNT && Integer.parseInt(years) > min_years) {
				int TotalFDAmount = Integer.parseInt(fdamount) + (ROI*Integer.parseInt(fdamount));
				for(int i=2; i<Integer.parseInt(years); i++)
					TotalFDAmount = TotalFDAmount + (ROI*TotalFDAmount);
				System.out.println("Your Total FD Amount after "+years+" years will be "+TotalFDAmount);
			}
				
		}
		catch(Exception e) {
			System.out.println("Exception is "+e);
		}
	}

			
			
		}
	
		
	

	

