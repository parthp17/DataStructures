package SearchigAlgorithm;

public class AnyPeakElement {

	public static int findPeak(int[] arr)
	{
		int i = 0;
		int j = arr.length-1;
		int peak = Integer.MIN_VALUE;
		while(i <= j)
		{
			int mid = i + j >> 1;
			if(mid == 0 || mid ==arr.length -1)
			{
				peak = arr[i] > arr[j] ? arr[i] : arr[j];
				break;
			}
			else if(arr[mid] > arr[mid -1] && arr[mid] > arr[mid + 1])
			{
				peak = arr[mid];
				break;
			}
			else if(arr[mid] < arr[mid - 1])
			{
				j = mid -1;
			}
			else
			{
				i = mid + 1;
			}
		}
		return peak;
	}
	
}
