package SearchigAlgorithm;

public class SearchInRotatedSortedArray {

	public int search(int[] nums, int target) {
		/*if (nums == null || nums.length == 0)
			return -1;
		return search(nums, 0, nums.length - 1, target);
*/
		return searchIterative(nums, target);
	}

	private int search(int[] nums, int low, int high, int target) {
		if (low > high)
			return -1;

		int mid = (low + high) / 2;

		if (nums[mid] == target)
			return mid;

		if (nums[low] <= nums[mid]) {

			if (target >= nums[low] && target < nums[mid])
				return search(nums, low, mid - 1, target);

			return search(nums, mid + 1, high, target);
		}

		if (target > nums[mid] && target <= nums[high])
			return search(nums, mid + 1, high, target);

		return search(nums, low, mid - 1, target);
	}
	
	private int searchIterative(int[] nums, int target)
	{
		int i = 0;
		int j = nums.length-1;
		int mid = -1;
		while(i <= j)
		{
			mid = i + j >> 1;
		
			if(nums[mid] == target)
				return mid;
			else if (nums[mid] < nums[j])
			{
				if(target > nums[mid] )
				{
					/// right
					i = mid + 1;
				}
				else
				{
					//left
					j = mid -1;
				}
			}
			else
			{
				if(target > nums[mid] )
				{
					//left
					j = mid -1;
				}
				else
				{
					// right
					i = mid + 1;
				}
			}
		}
		return mid;
	}
}
