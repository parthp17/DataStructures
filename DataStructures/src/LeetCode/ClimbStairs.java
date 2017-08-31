package LeetCode;

import java.util.Arrays;

public class ClimbStairs {

	public int climbStairs(int n) {
		
		int[] arr = new int[n+1];
		Arrays.fill(arr, -1);
		arr[0] = 1;
		climbStairs(n, arr);
		return arr[n];
	}
	
	public int climbStairs(int n, int[] arr)
	{
		if(n < 0) return 0;
		if(arr[n] != -1) return arr[n];
		arr[n] =  climbStairs(n-1, arr) + climbStairs(n-2, arr);
		return arr[n];
	}
	
	public static void main(String[] args) {
		System.out.println(new ClimbStairs().climbStairs(4));
	}
}
