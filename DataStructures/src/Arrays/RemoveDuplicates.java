package Arrays;

public class RemoveDuplicates {

	public int removeDuplicatesInSorted(int[] nums) {
        if(nums.length == 0) return 0;
        int j = 0;
        for(int i = 1 ; i < nums.length; i++)
        {
            if(nums[i] == nums[j]) continue;
            else
                nums[++j] = nums[i];
        }
        return ++j;
    }
	
	public int removeElement(int[] nums, int val) {
        
        int j = 0;
        for(int i = 0; i < nums.length; i++)
            if(nums[i] != val)
                nums[j++] = nums[i];
        
        return j;
    }
}
