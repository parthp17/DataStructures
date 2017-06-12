package Sorting;

import java.util.Arrays;

public class RadixSort {

	public int[] radixSort(int[] arr)
	{
		int max = Integer.MIN_VALUE;
		for(int i : arr)
		{
			max = max > i ? max : i;
		}
		
		for (int exp = 1 ; max/exp > 0 ; exp *= 10)
		{
			arr = coutingSort(arr,exp);
		}
		return arr;
	}
	
	private int[] coutingSort(int[] arr, int exp)
	{
		int[] output = new int[arr.length]; 
		int[] count = new int[10];
		
		for(int i = 0; i < arr.length; i++)
		{
			int digit = (arr[i]/exp)%10;
			count[digit] +=1; 
		}
		
		for(int i = 1; i < count.length ; i++)
		{
			count[i] += count[i-1];
		}
		
		for(int i = arr.length - 1 ; i >= 0; i--)
		{
			int digit = (arr[i]/exp)%10;
			output[count[digit]-1] = arr[i];
			count[digit]--;
		}
		
		return output;
	}
}
