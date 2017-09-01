package LeetCode;

import java.util.Arrays;

public class BestTimeBuySellStock {

	//Single transaction
	public int maxProfit(int[] arr){
		
		int maxHere = 0;
		int maxOverAll = 0;
		
		for(int i = 1 ; i < arr.length ; i++)
		{
			int temp = maxHere + arr[i] - arr[i-1]; 
			maxHere = temp > 0 ? temp : 0;
			maxOverAll = maxOverAll >= maxHere ? maxOverAll : maxHere;
		}
		return maxOverAll;
	}
	
	//k transactions
	public int maxProfit(int[] arr, int k)
	{
		
		if( k > arr.length /2){
			int profit = 0;
			for(int i = 1 ; i < arr.length ; i++)
				if(arr[i] > arr[i-1]) 
					profit+=arr[i] - arr[i-1];
			return profit;
			
		}
		int[][] matrix = new int[k+1][arr.length];
		int maxDiff;
		for(int i  = 1; i < matrix.length ;i++)
		{
			maxDiff = matrix[i-1][0] - arr[0];
			for(int j  = 1 ; j < matrix[0].length ;j++)
			{
				maxDiff = maxDiff > matrix[i-1][j] -arr[j] ? maxDiff : matrix[i-1][j] -arr[j];
				matrix[i][j] = matrix[i][j-1] > maxDiff + arr[j] ? matrix[i][j-1]:maxDiff + arr[j]; // not making a transaction on that day.
				/*int temp = arr[j];
				for(int m = 0 ; m < j ; m++)
				{
					temp =  matrix[i-1][m] + arr[j] - arr[m];
					matrix[i][j] = matrix[i][j] <  temp ? temp :matrix[i][j];
				}*/
			}
		}
		return matrix[matrix.length-1][matrix[0].length-1];
	}
	
	public static void main(String[] args) {
		System.out.println(new BestTimeBuySellStock().maxProfit(new int[]{2,5,7,1,4,3,1,3}, 3));
	}
	
}
