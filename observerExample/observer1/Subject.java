package exercise6.observer1;

public interface Subject {

	//method to register and unregister observers
	public void register(Observer obj);
	public void unregister(Observer obj);
	
	//method to notify observers of change
	public void notifyObservers();
	
	//method for the observer to get updates from subject
	public Object getUpdate(Observer obj);
}
