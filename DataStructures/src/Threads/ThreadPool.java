package Threads;

import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {

	private final int nThreads;
	private final WorkerThread[] pool;
	private final LinkedBlockingQueue<Runnable> queue;
	private static final int DEfAULT_SIZE = 10;
	
	public ThreadPool()
	{
		this(DEfAULT_SIZE);
	}
	
	public ThreadPool(int numOfThreads)
	{
		if(numOfThreads < 1)
			numOfThreads = DEfAULT_SIZE;
		
		this.nThreads = numOfThreads;
		pool = new WorkerThread[nThreads];
		queue = new LinkedBlockingQueue<>();
		for(int i = 0; i < this.nThreads; i++)
		{
			pool[i] = new WorkerThread();
			pool[i].start();
		}
			
	}
	
	private class WorkerThread extends Thread
	{ 
		@Override
		public void run()
		{
			Runnable task;
			
			while(true)
			{
				synchronized(queue)
				{
					while(queue.isEmpty())
						try {
							queue.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					task = queue.poll();
				}
				try
				{
					System.out.println(Thread.currentThread().getId() + " " + Thread.currentThread().getName());
					task.run();
				}
				catch(RuntimeException r)
				{
					r.printStackTrace();
				}
			}
		}
	}
	
	public int getnThreads() {
		return nThreads;
	}
	
	public void execute(Runnable task)
	{
		synchronized(this.queue)
		{
			this.queue.add(task);
			this.queue.notify();
		}
	}
	
	public void execute(Runnable[] tasks)
	{
		synchronized (queue) {
			Arrays.stream(tasks).forEach(t -> execute(t));
		}
	}
}