package SearchigAlgorithm;

public class MinInRotatedSortedArray {

	public static int findMin(int[] arr)
	{
		int min = Integer.MAX_VALUE;
		int i = 0;
		int j = arr.length-1;
		
		while(i <= j)
		{
			int mid = i+j >> 1;
			if(i == j)
			{
				min = arr[mid];
				break;
			}
			else if(arr[mid] < arr[j])
			{
				j = mid;
			}
			else
			{
				i = mid+1;
			}
		}
		return min;
	}
}
