package observerExample;

public class ObservePatternTest {

	public static void main(String[] args) {
		
		RedDress reddress = new RedDress();
		
		User observerA = new User(reddress);
		User observerB = new User(reddress);
				
		reddress.addObserver(observerA);
		reddress.addObserver(observerB);
		
		reddress.setInStock(true);
		//reddress.setInStock(true);
	}
}
