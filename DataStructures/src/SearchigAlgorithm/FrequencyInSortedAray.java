package SearchigAlgorithm;

public class FrequencyInSortedAray {

	public static int getFrequency(int[] arr, int n)
	{
		if(arr == null || arr.length == 0)return 0;
		
		int i = 0;
		int j = arr.length -1;
		
		
		int firstOccurence = firstOccurence(arr, i,j, n);
		if(firstOccurence == -1) return firstOccurence; 
		
		int lastOccurence = lastOccurence(arr,firstOccurence,j,n);
				
		return lastOccurence - firstOccurence + 1;
		
	}

	private static int lastOccurence(int[] arr, int firstOccurence, int j, int n) {
		int l= firstOccurence;
		int i = firstOccurence;
		while(i <= j)
		{
			int mid = i + j >> 1;
			if(arr[mid] == n)
			{
				if(arr[mid] != arr[mid+1])
				{
					l=mid;
					break;
				}
				else
				i = mid+1;
			}
			else
			{
				j = mid -1;
			}
			
		}		
		return l;
	}

	private static int firstOccurence(int[] arr, int i, int j, int n) {
		int f = -1;
		while(i <= j)
		{
			int mid = i+ j >> 1;
			if(arr[mid] == n)
			{
				if(mid == i || arr[mid-1] != arr[mid]) 
				{
					f = mid;
					break;
				}
				else
					j = mid-1;
			}
			else if(arr[mid] < n)
			{
				i = mid +1;
			}
			else{
				j = mid -1;
			}
		}
		return f;
	}
	
}
