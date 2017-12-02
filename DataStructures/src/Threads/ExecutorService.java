package Threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorService {

	public static void main(String[] args)
	{
		
		java.util.concurrent.ExecutorService executor = Executors.newCachedThreadPool();
		
		/*executor.submit(new Runnable(){
			public void run()
			{
				System.out.println("Entering task");
				try{
				Thread.sleep(5000);
				}catch (Exception e) {

				}
				System.out.println("worker thread " + Thread.currentThread().toString());
				
				System.out.println("completed task");
			}
		});*/
		
		Future<String> f = executor.submit(new Callable<String>(){
			
			@Override
			public String call() throws Exception {
				// TODO Auto-generated method stub
				return String.valueOf(Thread.currentThread().getId());
			}
		});
		
		
		try {
			System.out.println(f.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("main completed" + Thread.currentThread().toString());
		executor.shutdown();
	}
	
}
