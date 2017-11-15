package SearchigAlgorithm;

public class MaxInRotatedSortedArray {

	public static int findMax(int[] arr)
	{
		 if(arr.length == 1) return arr[0];
	        int max = Integer.MIN_VALUE;
			int i = 0;
			int j = arr.length-1;
			
			while(i <= j)
			{
				int mid = i+j >> 1;
				if(arr[mid] < arr[j])
	            {
	                i = mid + 1;
	            }
	            else if(arr[mid] > arr[j])
	            {
	                j = mid;
	                max = arr[mid];
	            }
	            else
	            {
	                j--;
	                max = arr[mid];
	            }
			}
			return max;
	}
}
