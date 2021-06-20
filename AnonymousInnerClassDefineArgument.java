
public class AnonymousInnerClassDefineArgument {

	public static void main(String[] args) {
		//Anonymous Inner Class that define inside argument
		Thread thread = new Thread(new Runnable() {
			public void run() {
				System.out.println("Child Thread");
			}
		});
		thread.start();
		System.out.println("Main Thread");
	}

}
