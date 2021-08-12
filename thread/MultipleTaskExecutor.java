package exercise5;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PrintTask implements Runnable{

	private int sleepTime;
	private String threadName;
	private static Random randomness = new Random();
	
	public PrintTask(String threadName) {
		this.threadName = threadName;
		sleepTime = randomness.nextInt(5000);
	}
	
	@Override
	public void run() {
		
		try {
			System.out.printf("%s is going to sleep for %d milliseconds\n", 
					threadName, sleepTime);
			Thread.sleep(sleepTime);
		}catch(InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		System.out.printf("%s is done sleeping\n", threadName);
		
	}
	
}

public class MultipleTaskExecutor {

	public static void main(String[] args) {
		
		//create runnable tasks
		PrintTask task1 = new PrintTask("Task1");
		PrintTask task2 = new PrintTask("Task2");
		PrintTask task3 = new PrintTask("Task3");
		PrintTask task4 = new PrintTask("Task4");
		PrintTask task5 = new PrintTask("Task5");

		System.out.println("Starting Executor");
		
		//Create ExecutorService to manage threads
		ExecutorService threadExecutor = Executors.newCachedThreadPool();

		threadExecutor.execute(task1);
		threadExecutor.execute(task2);
		threadExecutor.execute(task3);
		threadExecutor.execute(task4);
		threadExecutor.execute(task5);
		
		threadExecutor.shutdown();
		
		System.out.println("Thread started, main ends");
	}

}
