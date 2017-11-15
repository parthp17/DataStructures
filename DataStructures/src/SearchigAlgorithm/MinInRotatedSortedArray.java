package SearchigAlgorithm;

public class MinInRotatedSortedArray {

	public static int findMin(int[] arr)
	{
		 if(arr.length == 1) return arr[0];
	        int min = Integer.MAX_VALUE;
			int i = 0;
			int j = arr.length-1;
			
			while(i <= j)
			{
				int mid = i+j >> 1;
				if(arr[mid] > arr[j])
	            {
	                i = mid + 1;
	            }
	            else if(arr[mid] < arr[j])
	            {
	                j = mid;
	                min = arr[mid];
	            }
	            else
	            {
	                j--;
	                min = arr[mid];
	            }
			}
			return min;
	}
}
