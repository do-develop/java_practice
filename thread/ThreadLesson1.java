package thread;

public class ThreadLesson1 {

	public static void main(String[] args) {
		//System.out.println(Thread.activeCount());
		
		Thread.currentThread().setPriority(10);
		//System.out.println(Thread.currentThread().getPriority());
		
		//System.out.println(Thread.currentThread().isAlive());
		
		/*
		for(int i=3; i>0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Testing Thread Sleep Done!");
		*/
		
		MyThread thread2 = new MyThread();
		
		thread2.setDaemon(true);
		System.out.println(thread2.isDaemon());
		
		thread2.start();
		//System.out.println(thread2.isAlive());
		//thread2.setName("Second Thread");
		//System.out.println(thread2.getName());
		//System.out.println(thread2.getPriority()); //priority is inherited
		
	}

}
