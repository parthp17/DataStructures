package SearchigAlgorithm;

public class FloorSortedArray {

	public static int getFloor(int[] arr, int val)
	{
		int i = 0;
		int j = arr.length-1;
		
		int floor = Integer.MAX_VALUE;
		while(i <= j)
		{
			int mid  = (i+j) >> 1;
			if(arr[mid] == val)
			{
				floor = val;
				break;
			}
			else if(arr[mid] > val)
			{
				j = mid-1;
			}
			else
			{
				i = mid + 1;
				floor = arr[mid];
			}
		}
		return floor;
	}
}
