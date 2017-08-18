package SearchigAlgorithm;

public class CeilingSortedArray {

	public static int getCieling(int[] arr, int val)
	{
		int i = 0;
		int j = arr.length-1;
		int cieling = Integer.MIN_VALUE;
		while(i <= j)
		{
			int mid = i + j >> 1;
			if(arr[mid] == val) 
			{
				cieling= val;
				break;
			}
			else if(arr[mid] < val)
			{
				i = mid + 1; 
			}
			else
			{
				j = mid - 1;
				cieling = arr[mid];
			}
		}
		return cieling;
	}
}
