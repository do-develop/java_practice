package adapterPattern;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//This is the adapter class
//Adapter class is a wrapper class which implements the desired 
//target interface and modifies the specific request available 
//from the Adaptee class.
public class BankCustomer extends BankDetails implements CreditCard {

	@Override
	public void giveBankDetails() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.print("Enter the account holder name: ");
			String customerName = br.readLine();
			System.out.println();
			
			System.out.print("Enter the account number:");  
			long accountNumber = Long.parseLong(br.readLine());
			System.out.println();
			
			System.out.print("Enter the bank name: ");
			String bankName = br.readLine(); 
			
			setAccountHolderName(customerName);
			setAccountNumber(accountNumber);
			setBankName(bankName);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public String getCreditCard() {
		long accountNumber = getAccountNumber();
		String accountHolderName = getAccountHolderName();
		String bankName = getBankName();
		
		return ("The Account number "+accountNumber+" of "+accountHolderName+" in "
				+bankName+ "bank is valid and authenticated for issuing the credit card.");  
	}

}
