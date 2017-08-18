package Threads;

public class PoolMain {

	public static void main(String[] args)
	{
		ThreadPool pool = new ThreadPool(20);
		
		Runnable[] tasks = new Runnable[20];
		
		for(int i = 0 ; i < 20 ; i++)
		{
			tasks[i] = () -> {
				System.out.println("Executing anonymus task...");
			};
		}
		pool.execute(tasks);
	}
	
}
