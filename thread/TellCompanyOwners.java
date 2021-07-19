package session5;

public class TellCompanyOwners extends Thread {
	
	private Company company;
	
	public TellCompanyOwners (Company company) {
		this.company = company;
	}
	
	public void run() {
		company.tellSubsidiaries();
    	System.out.println("Information Collection for " +company.name()+" finished.");
	}
	
	public static Company[] makeSomeUp(){
		Company ansett= new Company("ansett");
		Company skywest= new Company("skywest");
		Company airNZ= new Company("airNZ");
		Company qantas= new Company("qantas");

	    ansett.owns(skywest);
		skywest.owns(ansett);
		airNZ.owns(ansett);
		
		Company[] Company= {ansett, airNZ, qantas, skywest};
		return Company;
	}

	public static void main(String[] args) throws InterruptedException {
		
		Company[] company = makeSomeUp();
		
		int size = company.length;
		TellCompanyOwners[] tellThread = new TellCompanyOwners[size];
		
		for (int i=0; i<size; i++)
            tellThread[i]= new TellCompanyOwners(company[i]);

		//start thread to collect data
		for (int i=0; i<size; i++)
			tellThread[i].start();
		
		//wait for the data collection threads to finish
		for (int i=0; i<size; i++)
		    tellThread[i].join();
		
		//list the gathered information
		for (int i=0; i<size; i++)
			company[i].listOwners();
		
		System.out.println("Main finished.");
	}

}
