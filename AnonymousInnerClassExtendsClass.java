
public class AnonymousInnerClassExtendsClass {

	public static void main(String[] args) {
		//Anonymous inner class that extends a class
		Thread t = new Thread() {
			public void run() {
				System.out.println("Child Thread");
			}
		};
		t.start();
		System.out.println("Main Thread");
	}

}
