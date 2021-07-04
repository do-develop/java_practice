package lab6.practice;

import java.util.concurrent.Callable;

public class CallableWorkerThread implements Callable<String>{

	private int workerNumber;

	CallableWorkerThread(int workerNumber){
		this.workerNumber = workerNumber;
	}
	@Override
	public String call() throws Exception {
		for(int i=1; i<=100; ++i) {
			System.out.printf("Worker %d: %d\n", workerNumber, i);
			if(i==100) {
				System.out.printf("Worker %d ended\n", workerNumber);
			}
			try {
				Thread.sleep(100);
			}catch (InterruptedException e) {e.printStackTrace();}
		}
		return "Worker " + workerNumber;
	}
	
}
