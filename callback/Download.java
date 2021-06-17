package javafx_practice.callback;

public class Download implements Runnable {

	public interface CallBack {
		public void iAmDone(String downloadText);
	}
	
	private final CallBack callBack;
	
	public Download(CallBack callBack) {
		//Constructor of Download object gives it a callback method
		this.callBack = callBack;
	}
	
	//run() method can't take in an argument
	@Override
	public void run() {
		String name = String.valueOf(this);
		callBack.iAmDone(name);
	}

}
