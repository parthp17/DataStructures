package LeetCode;

import java.util.Arrays;

public class ClimbStairs {

	public int climbStairs(int n) {
		
		int[] arr = new int[n+1];
		//Arrays.fill(arr, -1);
		arr[0] = 1;
		climbStairs(n, arr);
		return arr[n];
	}
	
	public int climbStairs(int n, int[] arr)
	{
		if(n < 0) return 0;
		if(arr[n] != 0) return arr[n];
		for(int i = 1; i <= 3; i++ )
			arr[n] +=  climbStairs(n-i, arr);
		return arr[n];
	}
	
	public static void main(String[] args) {
		System.out.println(new ClimbStairs().climbStairs(4));
	}
	
}
