package SearchigAlgorithm;

import java.util.Arrays;

public class SumClosestToTargetPair {

	public static int[] findPair(int[] arr, int target)
	{
		
		Arrays.sort(arr);
		int[] pair = new int[2];
		int i  = 0;
		int j = arr.length -1;
		int sum = Integer.MAX_VALUE;
		while(i < j)
		{
			int currentSum = (arr[i] + arr[j]);
			
			if (Math.abs(target-currentSum) < Math.abs(target-sum))
			{
				sum = currentSum;
				pair[0] = arr[i];
				pair[1] = arr[j];
			}
			if(target - currentSum > 0) i++;
			else j--;
		}
		return pair;
		
	}
	
}
