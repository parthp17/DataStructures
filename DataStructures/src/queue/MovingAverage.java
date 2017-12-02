package queue;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class MovingAverage {

    /** Initialize your data structure here. */
    
	Queue<Integer> queue;
	int size;
	double average;
	public MovingAverage(int size) {
		this.average = 0;
		this.size = size;
		queue = new ArrayBlockingQueue<>(size);
    }
    
    public double next(int val) {
        
    	if(this.queue.size() < this.size)
    	{
    		this.average = ((this.average * queue.size() + val )/( queue.size() + 1));
    		this.queue.add(val);
    	}
    	else
    	{
    		this.average = ((this.average * queue.size() + val - queue.peek())/queue.size());
    		this.queue.poll();this.queue.offer(val);
    	}
    	return this.average;
    }
    
    public static void main(String[] args) {
		
    	MovingAverage m = new MovingAverage(3);
    	
    			System.out.println(m.next(1));// = 1
    			System.out.println(m.next(10));// = (1 + 10) / 2
    			System.out.println(m.next(3));// = (1 + 10 + 3) / 3
    			System.out.println(m.next(5));// = (10 + 3 + 5) / 3
	}
}
