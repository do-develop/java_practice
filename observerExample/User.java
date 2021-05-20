package observerExample;

public class User implements Observer {

	private Observable observable = null;
	
	public User (Observable observable){
        this.observable = observable;
    }
	
	 @Override
	public void update() {
		 buyDress();
		 unsubscribe();
	}
	 
	public void buyDress(){
		System.out.println("get my red dress");
	}
	    
	public void unsubscribe(){
		observable.removeObserver(this);
	}
	 
	 
}
