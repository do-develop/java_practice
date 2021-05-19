package thread;

public class MultithreadingLesson1 {

	public static void main(String[] args) throws InterruptedException {
		//way1 - creating thread as a subclass
		MyThread thread1 = new MyThread();
		
		//way2 - creating thread using runnable interface
		MyRunnable runnable1 = new MyRunnable();
		Thread thread2 = new Thread(runnable1);
		
		thread1.setDaemon(true);
		thread2.setDaemon(true);
		
		thread1.start();
		//calling thread(ex main) wait until the specified thread dies or 
		//for x amount of millisecond 
		thread1.join(3000); 
		thread2.start();
		
		System.out.println(1/0); //daemon will exit upon the end of user thread
	}

}
