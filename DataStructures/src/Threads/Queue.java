package Threads;

public class Queue {

	int itemCount = 0;
	
}


class Producer{
	
	private Queue q;
	
	Producer(Queue q)
	{
		this.q = q;
	}
	
	void produceItem()
	{
		synchronized (q) {
			q.itemCount++;
			q.notify();
		}
	}
	
}

class Consumer{
	
	private Queue q;
	
	Consumer(Queue q)
	{
		this.q = q;
	}
	
	void consumeItem()
	{
		synchronized (q) {
			try{
			
				while(q.itemCount < 1) 
					q.wait();
				q.itemCount--;
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
		}
	}
}