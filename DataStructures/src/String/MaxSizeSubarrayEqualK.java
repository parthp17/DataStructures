package String;

import java.util.HashMap;
import java.util.Map;

public class MaxSizeSubarrayEqualK {

	public int maxSubArrayLen(int[] nums, int k) {
	    int sum = 0, max = 0;
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for (int i = 0; i < nums.length; i++) {
	        sum = sum + nums[i];
	        if (sum == k) max = i + 1;
	        else if (map.containsKey(sum - k)) max = Math.max(max, i - map.get(sum - k));
	        if (!map.containsKey(sum)) map.put(sum, i);
	    }
	    return max;
	}
	
	public static void main(String[] args) {
		MaxSizeSubarrayEqualK m = new MaxSizeSubarrayEqualK();		
		System.out.println(m.maxSubArrayLen(new int[]{1, -1, 5, -2, 3}, 5));
	}
	
}
