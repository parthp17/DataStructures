package SearchigAlgorithm;

public class MissingNumberSortedArray {

	public int findMissingNumber(int[] arr, int n)
	{
		return findMissingNumber(arr, 0, arr.length-1,n);
	}

	private int findMissingNumber(int[] arr, int l, int h, int n) 
	{
		if(l > h) return 0;

		int mid = (l + h) >> 1;

		if(arr[mid] == mid) 
			return findMissingNumber(arr,mid+1,h,n);
		else
		{
			if(mid == 0 || arr[mid -1] == mid -1 ) 
				return mid;
			else
				return findMissingNumber(arr,l,mid-1,n);
		}
	}
	
	public int findMissingNumber(int[] arr)
	{
		 if(arr == null || arr.length == 0) return -1;
		 
		 int i = 0;
		 int j  = arr.length -1;
		 int m = arr[j]+1;
		 while(i <= j)
		 {
			int mid = i+j >> 1;
		 	if(arr[mid] == mid)
		 	{
		 		i =mid + 1;
		 	}
		 	else
		 	{
		 		if(mid == i || arr[mid -1] == mid -1)
		 		{
		 			m = mid;
		 			break;
		 		}
		 		else
		 		{
		 			j = mid -1;
		 		}
		 	}
		 }
		return m;
	}
}