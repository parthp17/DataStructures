package Threads;

public class Mutex {

	boolean available;
	
	public Mutex()
	{
		this.available = true;
	}
	
	
	/*public boolean acquire()
	{
		synchronized (this) {
			while(!available)
			{
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
			available = false;
			return true;
		}
	}*/
}
