package Arrays;

import java.util.HashSet;
import java.util.Set;

public class ConatinsDuplicate {

	// in at most k window
	public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i < k && i < nums.length; i++)
        {
        	if(set.contains(nums[i]))
        		return true;
        	else
        		set.add(nums[i]);
        }
        
        for(int i = k ; i < nums.length ;i++)
        {
        	if(set.contains(nums[i]))
        		return true;
        	else
        	{
        		set.add(nums[i]);
        		set.remove(nums[i-k]);
        	}
        }
        return false;
    }
}
