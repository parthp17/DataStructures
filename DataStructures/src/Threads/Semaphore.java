package Threads;

public class Semaphore<Resources> {

	private int count;
	Resources resources[];
	public Semaphore(int count)
	{
		this.count = count;
		this.resources = (Resources[])new Object[count];
	}
	
}
