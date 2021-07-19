package session5;

public class Company {

	private String name;
	private Company[] subsidiary = new Company[0]; // whom I own (some of)
	private Company[] owner = new Company[0]; //who owns (some of) me
    
    public Company(String name) {
    	this.name = name;
    }
    
    public synchronized void tellSubsidiaries() {
    	System.out.println("Telling all the subsidiaries of " + name);
    	
    	for(int i=0; i<subsidiary.length; i++) {
    		// !!! The following for-loop is just to slow down
    		// the thread so that this method takes a bit longer -
    		// to help create a deadlock for demo purposes as
    		// the machine is too fast!! Comment out this loop 
    		// if deadlocks are not to be created.
    		/*
    		for (long j=0; j<490000; j++){
                j=2*j+63-7*9-j;
            }
            */
            (subsidiary[i]).addOwner(this);
    	}
    	System.out.println("Finished telling all the subsidiaries"+" of "+name);
    }
    
    public synchronized void addOwner(Company newOwner){
    	System.out.println("Adding a new owner of "+name);
    	
        int l = owner.length;
    	Company[] temp=new Company[l+1];
    	
        for(int i=0; i<l; i++) {
            temp[i]=owner[i];
            temp[l]=newOwner;
            owner=temp;
        } 
    		
        System.out.println("Finished adding a new owner of " + name);
	}
    
	public void owns(Company newSubsidiary){
    		//add a new subsidiary ie someone I own
    		int l=subsidiary.length;
    		Company[] temp=new Company[l+1];
    		for(int i=0; i<l; i++)
                	temp[i]=subsidiary[i];
            
    		temp[l]=newSubsidiary;
    		subsidiary=temp;
	}
    
    public void listOwners(){
        System.out.println("The owners of " +name+" are:");
		
        for(int i=0; i<owner.length; i++)
            System.out.println(owner[i].name);

        System.out.println("That's all.");
    }
    
    public String name(){
        return name;
    }
}
