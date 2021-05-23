package adapterPattern;

//This is the adaptee class
//Adaptee class is the class which is used by the Adapter class
//to reuse the existing functionality and modify them for desired use.
public class BankDetails {

	private String bankName;
	private String accountHolderName;
	private long accountNumber;
	
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	
}
