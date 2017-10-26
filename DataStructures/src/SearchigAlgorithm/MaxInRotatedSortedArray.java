package SearchigAlgorithm;

public class MaxInRotatedSortedArray {

	public static int findMax(int[] arr)
	{
		int max = Integer.MIN_VALUE;
		int i = 0;
		int j = arr.length-1;
		
		while(i <= j)
		{
			int mid = i + j >> 1;
			if(i == j)
			{
				max = mid;
				break;
			}
			else if( arr[mid] < arr[j])
			{
				j = mid;
			}
			else
			{
				i = mid + 1;
			}
		}
		/*while(i <= j)
		{
			int mid = i+j >> 1;
			if(mid == i)
			{
				max = arr[mid];
				break;
			}
			else if(arr[mid] > arr[mid+1] )
			{
				j = mid;
			}
			else if( arr[mid] < arr[mid + 1])
			{
				i = mid +1;
			}
			else if(arr[mid] < arr[mid-1])
			{
				j = mid-1;
			}
			else if(arr[mid] > arr[mid -1])
				i =mid;
		}*/
		return max;
	}
}
