package SearchigAlgorithm;

public class SearchInAlmostSortedArray {

	public static int find(int[] arr, int n)
	{
		int val = -1;
		int i = 0;
		int j = arr.length-1;
		
		while(i <= j)
		{
			int mid = i+j >> 1;
			if(arr[mid] == n)
			{
				val = mid;
				break;
			}
			if (arr[mid] <= arr[j]) 
			{
				if(arr[mid] < n)
					i = mid + 1;
				else
					j = mid -1;
			}
			else
			{
				if(arr[mid] > n)
					j = mid -1;
				else
					i = mid+1;
			}
		}
		return val;
	}
	
	/*public static int find(int[] arr, int l, int h, int n)
	{
		
	}*/
	
}
