package SearchigAlgorithm;

public class FixedPointSortedAray {

	public static int findFixedPoint(int[] arr)
	{
		if(arr == null || arr.length == 0) return -1;
		
		int val = -1;
		int i = 0;
		int j = arr.length -1;
		
		while(i <= j)
		{
			int mid = i+j >>1;
				
			if(arr[mid] == mid)
			{
				val = mid;
				break;
			}
			else if(arr[mid] > mid)
			{
				j = mid -1;
			}
			else
			{
				i = mid+1;
			}
		}
		return val;
	}
	
	public static int findFixedPointRecursive(int[] arr)
	{
		if(arr == null || arr.length == 0) return -1;
		return findFixedPointRecursive(arr,0,arr.length-1);
		
	}

	private static int findFixedPointRecursive(int[] arr, int i, int j) 
	{
		if(i > j) return -1;
		
		int mid = i +j >> 1;
		if(arr[mid] == mid)
		{
			return mid;
		}
		else if(arr[mid] > mid)
		{
			return findFixedPointRecursive(arr, i, mid-1);
		}
		else
		{
			return findFixedPointRecursive(arr, mid+1, j);
		}
	}
	
}
