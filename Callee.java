package sample;

import java.util.Scanner;

public class Callee {
	
	private String message;
	private CallBack callback;
	
	public interface CallBack{
		public void onGetMessage(Callee callee);
	}
	
	public Callee() {
		message = "";
		callback = null;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setCallback(CallBack callback) {
		this.callback = callback;
	}
	
	public void getInputMessage() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a message: ");
		message = scanner.nextLine();
		
		if(callback != null)
			this.callback.onGetMessage(Callee.this);
	}

}
