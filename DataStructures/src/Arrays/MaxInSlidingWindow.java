package Arrays;

import java.util.Deque;

public class MaxInSlidingWindow {

	public static void printMaxInSlidingWindow(int[] arr, int k)
	{
		Deque<Integer> dq = new java.util.LinkedList();
		int i = 0;
		for(; i < k ; i++)
		{
			while( !dq.isEmpty() && arr[i] >= arr[dq.peekLast()])
			{
				dq.pollLast();
			}
			
			dq.addLast(i);
		}
		for(; i < arr.length ; i++)
		{
			System.out.println(arr[dq.peekFirst()]);
			//System.out.println(arr[dq.peekFirst()]);
			while( !dq.isEmpty() && (i - k) >= dq.peekFirst())
			{
				dq.pollFirst();
			}
			while( !dq.isEmpty() && arr[i] >= arr[dq.peekLast()])
			{
				dq.pollLast();
			}
			dq.addLast(i);
		}
		System.out.println(arr[dq.peekFirst()]);
		
		
	}
	
	public static void main(String[] args) {
		
		printMaxInSlidingWindow(new int[]{1,3,1,2,0,5}, 3);
		
	}
}
