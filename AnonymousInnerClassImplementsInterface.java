
public class AnonymousInnerClassImplementsInterface {

	public static void main(String[] args) {
		//Anonymous Inner class that implements a interface
		Runnable runnable = new Runnable() {
			public void run() {
				System.out.println("Child Thread");
			}
		};
		
		Thread thread = new Thread(runnable);
		thread.start();
		System.out.println("Main Thread");

	}

}
